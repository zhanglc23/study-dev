package com.ivan.study.es;

import com.ivan.study.Msg;
import com.ivan.study.MsgType;
import com.ivan.study.RegexUtil;
import org.apache.commons.codec.binary.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.search.SearchType;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.common.unit.TimeValue;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.xpack.client.PreBuiltXPackTransportClient;

import java.io.UnsupportedEncodingException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.DecimalFormat;
import java.util.concurrent.ExecutionException;

/**
 * Description:
 * author zhanglc
 * Created on 2018/8/13.
 */

public class FAccTest {
    private static Logger logger = LogManager.getLogger(Class.class);

    private static TransportClient client = null;

    private static final String INDEX_ACMT_PRIFIX = "index-acmadm-filebeat-" ;
    private static final String INDEX_FRONT_PRIFIX = "index-acmadmfront-filebeat-" ;
    private static final String INDEX_SUFFIX = "-doc" ;

    public static void main(String[] args) {

        getAccDate("00101105101082018081210000030631399999999交易成功                                                            201808123292315004  20180812093540201808122`201`2010020002037513131`203`2030020002037513147`1234567890123456`") ;

        String date = "2018.08.12" ;

        String index = "index-acmadmfront-filebeat-2018.08.12-doc";

        //获取连接
        getESSercherClient("172.16.76.14", 9300);

        BoolQueryBuilder type = QueryBuilders.boolQuery().mustNot(QueryBuilders.existsQuery("response"))
                .must(QueryBuilders.termsQuery("type", "00504" , "00510"));
        //        QueryBuilder type = QueryBuilders.matchPhraseQuery("type", "00101");
        try {
            logger.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>acmt front acc woacc is start<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
            SearchResponse frsp = client.prepareSearch(index).setQuery(type).setSearchType(SearchType.DFS_QUERY_THEN_FETCH)
                    .setScroll(new TimeValue(10000)).setSize(1000).execute().get();

            long totalHits = frsp.getHits().getTotalHits();
            int page = (int) totalHits / (5 * 1000);
            logger.info("front acc woacc total = {} , totalpage = {}", totalHits, page);
            for (int i = 0; i <= page; i++) {
                SearchResponse fres = client.prepareSearchScroll(frsp.getScrollId()).setScroll(new TimeValue(10000)).execute().actionGet();
                SearchHits searchHits = fres.getHits();
                SearchHit[] hits = searchHits.getHits();
                logger.info("front acc woacc page = {} , size = {}", totalHits, i, hits.length);
                if (hits.length > 0) {
                    for (int j = 0; j < hits.length; j++) {
                        SearchHit hit = hits[j];
                        Msg reqMsg = getMsg(hit, MsgType.REQ, null);
                        String msgId = (String) hit.getSource().get("msgId");
//                        logger.info("front acc woacc request page = {} , size = {} , NO = {} , msg = {}" ,  i ,  hits.length , j , message);
                        BoolQueryBuilder rm = QueryBuilders.boolQuery().must(QueryBuilders.existsQuery("response"))
                                .must(QueryBuilders.matchPhraseQuery("msgId", msgId));
                        SearchResponse frp = client.prepareSearch(index).setQuery(rm).execute().actionGet();
                        SearchHits shits = frp.getHits();
                        SearchHit[] hits2 = shits.getHits();
                        if (hits2.length > 0) {
                            for (int m = 0; m < hits2.length; m++) {
                                SearchHit h = hits2[m];
                                Msg rspmsg = getMsg(h, MsgType.RSP, reqMsg);
                                reqMsg.setAccDate(rspmsg.getAccDate());
                                logger.info("front acc woacc req page = {} , size = {} , NO = {} , msg = {}", i, hits2.length, j, reqMsg);
                                logger.info("front acc woacc rsp page = {} , size = {} , NO = {} , msg = {}", i, hits2.length, j, rspmsg);
                            }
                        } else {
                            logger.warn("front acc woacc no response page = {} , size = {} , NO = {} ", i, hits.length, j);
                        }
                    }
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }


    }

    private static Msg getMsg(SearchHit hit, MsgType msgType, Msg reqMsg) {
        String time = (String) hit.getSource().get("@timestamp");
        String source = (String) hit.getSource().get("log_source");
        String msgId = (String) hit.getSource().get("msgId");
        String type;
        String message = null;
        String accDate = null;
        if (MsgType.REQ.equals(msgType)) {
            message = getFixReqMsg(((String) hit.getSource().get("message")).replaceAll(RegexUtil.SPACE_OR_ENTER, ""));
            type = (String) hit.getSource().get("type");
        } else {
            message = RegexUtil.getSubStr((String) hit.getSource().get("message"), RegexUtil.RGEX_FIXMSG_RSP, 1);
            type = reqMsg.getTxCode();
            accDate = getAccDate(message) ;
        }
        //String time, String source, String messageId, String message, MsgType msgType, String accDate, String txCode
        return new Msg(time, source, msgId, message, msgType, accDate, type);
    }



    private static String getAccDate(String message) {
        String accDate = null ;
        try {
            byte[] bytes = message.getBytes("GB18030");
            byte[] tmp = new byte[8];
            int start = 143 ;
            for(int i = 0 ; i < 8 ; i++) {
                byte aByte = bytes[start];
                tmp[i] = aByte ;
                start++ ;
            }
            accDate = new String(tmp) ;
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return accDate ;
    }

    private static String getFixReqMsg(String message) {
        String subStr = RegexUtil.getSubStr(message, RegexUtil.RGEX_FIXMSG_REQ, 1);
        DecimalFormat df = new DecimalFormat("000000");
        if (null != subStr) {
            try {
                return new StringBuffer(subStr).insert(0, df.format(subStr.getBytes("GB18030").length + 6)).toString();
            } catch (UnsupportedEncodingException e) {
                logger.error("get message [{}] length error ", message, e);
            }
        }
        return null;
    }


    private static void getESSercherClient(String host, int port) {
        try {
            Settings settings = getSettings("Qindex2", "Q_index099_TT");
            client = new PreBuiltXPackTransportClient(settings)
                    .addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName(host), port));
        } catch (UnknownHostException e) {
            throw new RuntimeException();
        }
    }

    private static Settings getSettings(String user, String pwd) {
        Settings settings = Settings.builder()
                .put("client.transport.sniff", true)
                .put("client.transport.ignore_cluster_name", true)
                .put("xpack.security.user", user + ":" + pwd).build();
        return settings;
    }
}
