package com.ivan.study.es;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.search.SearchType;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.common.unit.TimeValue;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.sort.SortOrder;
import org.elasticsearch.xpack.client.PreBuiltXPackTransportClient;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ExecutionException;

/**
 * Description:
 * author zhanglc
 * Created on 2018/8/10.
 */

public class SecondTest {

    private static Logger logger = LogManager.getLogger(Class.class);

    private static TransportClient client = null;

    private static Set<String> txCode = new HashSet<String>() ;

    static {
        //"0130009", "0130010", "0130011", "0130014", "0130019", "0130021", "0130023", "0130024", "0130033"
        txCode.add("0130009") ;
        txCode.add("0130010") ;
        txCode.add("0130011") ;
        txCode.add("0130014") ;
        txCode.add("0130019") ;
        txCode.add("0130021") ;
        txCode.add("0130023") ;
        txCode.add("0130024") ;
        txCode.add("0130033") ;
        Settings settings = Settings.builder()
                .put("client.transport.sniff", true)
                .put("client.transport.ignore_cluster_name", true)
                .put("xpack.security.user", "Qindex2:Q_index099_TT").build();
        try {
            client = new PreBuiltXPackTransportClient(settings)
                    .addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("172.16.76.14"), 9300));
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) throws ExecutionException, InterruptedException {

        BoolQueryBuilder re = QueryBuilders.boolQuery().mustNot(QueryBuilders.existsQuery("response"));

        SearchResponse response = client.prepareSearch("index-acmadm-filebeat-2018.08.09-doc")
                .setSearchType(SearchType.DFS_QUERY_THEN_FETCH)
                .setQuery(re)
                .addSort("@timestamp", SortOrder.ASC).setSize(100).setScroll(new TimeValue(10000)).execute().get();

        long totalCount = response.getHits().getTotalHits();
        int page = (int) totalCount / (5 * 100);
        logger.info("totalCount = {} , page = {} ", totalCount, page);

        for (int i = 0; i <= page; i++) {
            response = client.prepareSearchScroll(response.getScrollId())
                    .setScroll(new TimeValue(10000)).execute().actionGet();
            logger.info("page {} pagesize {} " , i , response.getHits().getHits().length);
            SearchHits searchHits = response.getHits();
            SearchHit[] hits = searchHits.getHits();
            if (hits.length > 0) {
                for (int j = 0 ; j < hits.length ; j++ ) {
                    SearchHit hit = hits[j];
//                    logger.info("page {} num {}  source >>> {} ", i , j , hit.getSource());
                    String orgJrn = (String) hit.getSource().get("orgJrn");
                    String msgId = (String) hit.getSource().get("msgId");
                    String msg = (String) hit.getSource().get("message");
                    String txCd = (String) hit.getSource().get("txCd");
                    String time = (String) hit.getSource().get("@timestamp");
                    if(!txCode.contains(txCd.substring(0 , 7))   ) {
                        logger.info("page {} num {} messId = {} , reqNo = {} , time = {} ,  msg = {}", i , j , msgId, orgJrn, time,  msg.replaceAll("[\\s*\\t\\n\\r]", ""));
                    }else {
                        logger.info("page {} num {} messId = {} , reqNo = {} , time = {} ,  查询报文" , i , j , msgId , orgJrn , time );
                        continue;
                    }

                    QueryBuilder q = QueryBuilders.matchPhraseQuery("msgId", msgId);
                    BoolQueryBuilder re1 = QueryBuilders.boolQuery().must(QueryBuilders.existsQuery("response")).must(q) ;
                    SearchResponse get = client.prepareSearch("index-acmadm-filebeat-2018.08.09-doc").setSearchType(SearchType.DFS_QUERY_THEN_FETCH).
                            setQuery(re1).execute().actionGet();
                    SearchHits hits1 = get.getHits();
                    SearchHit[] hits2 = hits1.getHits();

                    if (hits2.length > 0) {
                        for (SearchHit h : hits1) {
                            String response1 = (String) h.getSource().get("response");
                            String msgId2 = (String) h.getSource().get("msgId");
                            String msg3 = (String) h.getSource().get("message");
                            String time4 = (String) h.getSource().get("@timestamp");
                            String date = msg3.substring(msg3.indexOf("<AC_DT>")+7, msg3.indexOf("</AC_DT>"));
                            logger.info("page {} num {} messId = {} , accDate ={} response = {} , time = {} ,  msg = {}", i , j , msgId2, date , response1, time4,  msg3.replaceAll("[\\s*\\t\\n\\r]", ""));
                        }
                    }
                }
            }
        }

    }

}
