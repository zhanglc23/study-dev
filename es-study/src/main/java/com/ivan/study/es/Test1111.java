package com.ivan.study.es;

import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Description:
 * author zhanglc
 * Created on 2018/8/14.
 */

public class Test1111 {

    public static void main(String[] args) throws ParseException {
//        String date = "2016-08-15T16:00:00.000Z";
//        date = date.replace("Z", " UTC");
//        System.out.println(date);
//        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS Z");
//        Date d = format.parse(date);
//        System.out.println(d);

        String m = "00101105101082018081310000038068099999999交易成功                                                            201808133297186891  20180813112053201808132`201`2010020002039009435`203`2030020002039009441`1234567890123456`" ;

        System.out.println(getByteSub(m , 8 , 33)) ;



    }

    private static String getByteSub(String message , int len , int start) {
        String accDate = null ;
        try {
            byte[] bytes = message.getBytes("GB18030");
            byte[] tmp = new byte[8];
            for(int i = 0 ; i < len ; i++) {
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
}
