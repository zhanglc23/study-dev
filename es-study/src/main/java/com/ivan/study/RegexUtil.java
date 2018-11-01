package com.ivan.study;

import java.io.UnsupportedEncodingException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Description:
 * author zhanglc
 * Created on 2018/8/3.
 */

public class RegexUtil {

    public static final String RGEX_MESSAGE_ID = "MsgId:\\[([A-Z0-9]{26})\\];" ;
    public static final String RGEX_FIXMSG_REQ = "\\]\\[([0-9]{47,}[0-9`\\sA-zA-z_?\\u4e00-\\u9fa5]{30,})\\]" ;
    public static final String RGEX_FIXMSG_RSP = "\\]\\[([0-9]{41,}[0-9`\\sA-zA-z_?\\u4e00-\\u9fa5]{30,})\\]" ;
    public static final String RGEX_XMLMSG_REQ = "<ROOT>(.*?)</ROOT>" ;
    public static final String RGEX_XMLMSG_RSP = "<RSP_CD>(.*?)</RSP_CD>" ;
    public static final String SPACE_OR_ENTER = "[\\s*\\t\\n\\r]" ;

    public static String getSubStr(String sourStr , String rgex ) {
        return getSubStr( sourStr , rgex ,0);
    }

    public static String getSubStr(String sourStr , String rgex , int groupIndex) {
        Pattern pattern = Pattern.compile(rgex);// 匹配的模式
        Matcher matcher = pattern.matcher(sourStr);
        while (matcher.find()) {
            return matcher.group(groupIndex);
        }
        return null ;
    }
    public static boolean isMatcher(String sourStr , String rgex) {
        Pattern pattern = Pattern.compile(rgex);// 匹配的模式
        return pattern.matcher(sourStr).find() ;
    }

    public static void main(String[] args) throws UnsupportedEncodingException {
        String a = "08-03 10:46:03,507 INFO - MsgId:[CSTDACM1ACM093000017622470];����:[172.16.94.4][21878];����:[325][<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n"
            + "<ROOT><HEAD><TX_CD>0130014</TX_CD><SYS_CNL>10101</SYS_CNL><ORG_TX_DT>20180803</ORG_TX_DT><ORG_JRN_NO>20180803104603502080</ORG_JRN_NO><CNL_TX_CD>0130014</CNL_TX_CD><BUS_CNL>101</BUS_CNL><VER_NO>0001</VER_NO></HEAD><BODY><USR_NO>110000101881240</USR_NO><AC_TYP>204</AC_TYP></BODY></ROOT>]" ;
        String b = "08-0311:39:18,500INFO-MsgId:[CRPMRAF1ACM092000001451100];����:[172.16.94.7][21422];����:[218][00101105101082018080315332675584699999999���׳ɹ�20180803324403150520180803113913201808032`201`2010020002015556037`203`2030020002015556043`1234567890123456`]";
//        System.out.println(getSubStr(a , RGEX_MESSAGE_ID , 1));
//        System.out.println(getSubStr(a , RGEX_XMLMSG_REQ , 0));
        //getSubStr(b , "]\\[([.*]{10,}.*)\\]" , null);

//        String c = new String( b.getBytes("gbk") , "utf-8") ;

        //getSubStr(b , "^\\]\\[(.*)`\\]" , null);
//            String c = new String( b.getBytes("gbk") , "utf-8") ;
//            System.out.println(c);
//        System.out.println(getSubStr(b , "\\]\\[(.*{41,})\\]$" , 1));
//        System.out.println(getSubStr(b , "\\]\\[(.*{41,})\\]$"));
//            getSubStr(c , "\\]\\[([0-9`?]{41,})\\`]" , 0);
//        getSubStr(b , "\\[(.*?)\\]" , null);
//        System.out.println();

//        String testStr = "12315<Test>show me</text>";
//        Pattern p = Pattern.compile("<Test>(.*)</text>");
//        Matcher m = p.matcher(testStr);
//        while(m.find()){
//            System.out.println(m.group(1));
//        }

        String req1 = "08-0910:11:11,071INFO-MsgId:[CRPMRAF1ACM095000000105758];����:[172.16.94.20][28108];����:[88][0090110110500201808091533780671062018080910111120180809110000037380720`1234567890123456`]" ;
        String req2 = "08-0906:01:29,846INFO-MsgId:[CRPMRAF1ACM093000000097130];����:[172.16.94.24][21614];����:[102][005101071070120180809107441401314201808090601292018080901`UNP_REQ_XXSD`001`20180808`1`01`2506647931```]" ;
        String req3 = "08-0908:28:40,518INFO-MsgId:[CRPMRAF1ACM093000000098793];接收:[172.16.94.16][32322];数据:[113][0010210510108201808091533774520512018080908284020180809110000069622019`2010020001381564096`销户`1234567890123456`]" ;
        String rsp = "08-0908:28:40,539INFO-MsgId:[CRPMRAF1ACM093000000098793];发送:[172.16.94.16][32322];数据:[234][00102105101082018080915337745205199999999交易成功20180809327675925120180809082840201808092`2010020001381564096`2010020001381564096`3`2030020001381564102`3`1234567890123456`]" ;

        System.out.println(getSubStr(req1 , "\\]\\[([0-9]{47,}[0-9`\\sA-zA-z_?\\u4e00-\\u9fa5]{30,})\\]" , 1));
        System.out.println(getSubStr(req2 , "\\]\\[([0-9]{47,}[0-9`\\sA-zA-z_?\\u4e00-\\u9fa5]{30,})\\]" ,1));
        System.out.println(getSubStr(req3 , "\\]\\[([0-9]{47,}[0-9`\\sA-zA-z_?\\u4e00-\\u9fa5]{30,})\\]" , 1 ));
        System.out.println(getSubStr(rsp , "\\]\\[([0-9]{41,}[0-9`\\sA-zA-z_?\\u4e00-\\u9fa5]{30,})\\]" , 1));


    }
}
