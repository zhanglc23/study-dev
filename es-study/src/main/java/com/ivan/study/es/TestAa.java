package com.ivan.study.es;

import com.alibaba.fastjson.JSON;
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
import org.elasticsearch.xpack.client.PreBuiltXPackTransportClient;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.concurrent.ExecutionException;

/**
 * Description:
 * author zhanglc
 * Created on 2018/8/14.
 */

public class TestAa {

    private static Logger logger = LogManager.getLogger(Class.class);
    private static TransportClient client = null;

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        String date = "2018.08.12";

        String index = "index-acmadmfront-filebeat-2018.08.12-doc";

        //获取连接
        getESSercherClient("172.16.76.14", 9300);

        BoolQueryBuilder type = QueryBuilders.boolQuery().mustNot(QueryBuilders.existsQuery("response"))
                .must(QueryBuilders.termsQuery("type", "00504", "00510"));

        seracher(index , client , 1000 , type);

    }


    public static void seracher(String index, TransportClient client, int pageSize, QueryBuilder query ) throws ExecutionException, InterruptedException {
        SearchResponse response = client.prepareSearch(index).setQuery(query).setSearchType(SearchType.DFS_QUERY_THEN_FETCH)
                .setScroll(new TimeValue(20000)).setSize(pageSize).execute().get();

        //获取总命中数
        long totalHits = response.getHits().getTotalHits();
        logger.info(">>>>>>>>totalHits = {}" , totalHits);

        //获取scrollId
        String scrollId = response.getScrollId();
        boolean hasFlag = true;
        boolean first = true ;
        long totalCount = 0;

        SearchHit[] hits  ;
        while (hasFlag) {
            if(first) {
                hits = response.getHits().getHits() ;
                first = false ;
            }else {
                SearchResponse get = client.prepareSearchScroll(scrollId).setScroll(new TimeValue(20000)).execute().actionGet();
                scrollId = get.getScrollId() ;
                hits = get.getHits().getHits();
            }

            //如果查询到遍历，查询不到继续
            if(hits.length > 0 ) {
                if(totalCount < totalHits ) {
                    logger.info(">>>>>>>>length {}" , hits.length);
                    totalCount += hits.length ;
                    for (final SearchHit h : hits) {
                        logger.info(">>>>>>>>{}" , JSON.toJSONString(h.getSource()));
//                        taskExecutor.execute(new Runnable() {
//                            @Override
//                            public void run() {
//                                h.getSource();
//                                process.process((String) h.getSource());
//                            }
//                        });
                    }

                }
            }else {
                hasFlag = false;
            }


        }
        logger.info("---------------------{}" , totalCount);
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
