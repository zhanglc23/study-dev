package com.ivan.study.es;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.search.SearchType;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.common.unit.Fuzziness;
import org.elasticsearch.common.unit.TimeValue;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.ExistsQueryBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.RegexpQueryBuilder;
import org.elasticsearch.index.query.TermsQueryBuilder;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.sort.SortOrder;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.elasticsearch.xpack.client.PreBuiltXPackTransportClient;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.concurrent.ExecutionException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Description:
 * author zhanglc
 * Created on 2018/8/9.
 */

public class Test {

    private static Logger logger = LogManager.getLogger(Class.class);


    public static void main(String[] args) throws ExecutionException, InterruptedException, UnknownHostException {

        String a = "0130011用户余额查询";
        String b = "0131111用户余额查询";
//        String reg = "^[0130009|0130010|0130011|0130014|0130019|0130021|0130023|0130024|0130033][.*]{0,}" ;
//        String reg = "^(?!(0130009|0130010|0130011|0130014|0130019|0130021|0130023|0130024|0130033))$" ;
        String reg = "^(?:(?!(0130009|0130010|0130011|0130014|0130019|0130021|0130023|0130024|0130033)).)*$" ;
        Pattern compile = Pattern.compile(reg);
        Matcher matcher = compile.matcher(a);
        if(matcher.find()) {
            System.out.println(matcher.group());
        }
        System.out.println(matcher.find());


        Matcher matcher1 = compile.matcher(b);
        if(matcher1.find()) {
            System.out.println(matcher1.group());
        }


        Settings settings = Settings.builder()
                .put("client.transport.sniff", true)
                .put("client.transport.ignore_cluster_name", true)
                .put("xpack.security.user", "Qindex2:Q_index099_TT").build();
        TransportClient client = new PreBuiltXPackTransportClient(settings)
                .addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("172.16.76.14"), 9300));

//        ExistsQueryBuilder query = QueryBuilders.existsQuery("response");
        QueryBuilder txCd = QueryBuilders.regexpQuery("txCd", "^(?:(?!(0130009|0130010|0130011|0130014|0130019|0130021|0130023|0130024|0130033)).)*$");
//        BoolQueryBuilder txCd = QueryBuilders.boolQuery().mustNot(QueryBuilders.termsQuery("txCd", "0130009", "0130010", "0130011", "0130014", "0130019", "0130021", "0130023", "0130024", "0130033"));


//        TermsQueryBuilder txCd = QueryBuilders.termsQuery("txCd", "0130009", "0130010", "0130011", "0130014", "0130019", "0130021", "0130023", "0130024", "0130033");
        BoolQueryBuilder re = QueryBuilders.boolQuery().mustNot(QueryBuilders.existsQuery("response"));
//        BoolQueryBuilder txCd = QueryBuilders.boolQuery().mustNot(QueryBuilders.regexpQuery("txCd", "^[0130009|0130010|0130011|0130014|0130019|0130021|0130023|0130024|0130033][.*]{0,}"));

//        QueryBuilders.fuzzyQuery("txCd", "tel").fuzziness(Fuzziness.ONE) ;
//        QueryBuilders.prefixQuery("hotelName","花园")
        SearchResponse response = client.prepareSearch("index-acmadm-filebeat-2018.08.09-doc")
                .setSearchType(SearchType.DFS_QUERY_THEN_FETCH)
//                .setQuery(txCd)
                .setQuery(re)
                .addSort("@timestamp" , SortOrder.ASC).setSize(100).setScroll(new TimeValue(10000)).execute().get();

        long totalCount = response.getHits().getTotalHits();
        int page = (int) totalCount / (5 * 100);
        logger.info("totalCount = {} , page = {} " , totalCount , page);

        SearchHits searchHits = response.getHits();
        SearchHit[] hits = searchHits.getHits();
        if(hits.length > 0 ) {
            for (SearchHit hit : hits) {
                logger.info(">>>>>>>>>>>>>>>>>>>>>{}" ,  hit.getSource());
            }
        }




//        for (int i = 0; i <= page; i++) {
//            response = client.prepareSearchScroll(response.getScrollId())
//                    .setScroll(new TimeValue(10000)).execute().actionGet();
//
//            SearchHits searchHits = response.getHits();
//            SearchHit[] hits = searchHits.getHits();
//            if (hits.length > 0) {
//                for (SearchHit hit : hits) {
//                    logger.info(">>>>>>>>>>>>>>>>>>>>>{}" ,  hit.getSource());
//                    String orgJrn = (String) hit.getSource().get("orgJrn");
//                    String msgId = (String) hit.getSource().get("msgId");
//                    String msg = (String) hit.getSource().get("message");
//                    String time = (String) hit.getSource().get("@timestamp");
//                    logger.info("reqNo = {} , time = {} , messId = {} , msg = {}" , orgJrn , time , msgId , msg.replaceAll("[\\s*\\t\\n\\r]",""));
//
//                    QueryBuilder q = QueryBuilders.termQuery("msgId" , msgId) ;
//                    SearchResponse get = client.prepareSearch("index-acmadm-filebeat-2018.08.09-doc").setSearchType(SearchType.DFS_QUERY_THEN_FETCH).
//                            setQuery(q).execute().actionGet();
//                    SearchHits hits1 = get.getHits();
//                    SearchHit[] hits2 = hits1.getHits();
//
//                    if (hits2.length > 0 ) {
//                        for (SearchHit h : hits1) {
//                            String response1 = (String) h.getSource().get("response");
//                            String msgId2 = (String) h.getSource().get("msgId");
//                            String msg3 = (String) h.getSource().get("message");
//                            String time4 = (String) h.getSource().get("@timestamp");
//                            logger.info("response = {} , time = {} , messId = {} , msg = {}" , response1 , time4 , msgId2 , msg3.replaceAll("[\\s*\\t\\n\\r]",""));
//                        }
//                    }
//
//                }
//            }
//        }


//        System.out.println(response);


//        SearchHits hits = response.getHits();
//        System.out.println("hits = " + hits);


        client.close();


    }


}
