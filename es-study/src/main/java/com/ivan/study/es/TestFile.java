package com.ivan.study.es;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.ivan.study.Msg;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Description:
 * author zhanglc
 * Created on 2018/8/15.
 */

public class TestFile {


    public static void main(String[] args) throws IOException {

        List<String> file = getFromFile("e:\\es-norsp-xmlmsg.log");

        for (String s : file) {
            System.out.println(s);
//            Msg msg = JSON.parseObject(s, Msg.class);
//            System.out.println(msg.toString());
            JSONObject jsonObject = JSON.parseObject(s);
            System.out.println(jsonObject.getString("message"));
//            Msg msg = JSON.parseObject(s, Msg.class);
        }

    }


    public static List<String> getFromFile(String file) throws IOException {
        FileInputStream fis = new FileInputStream(file);

        List<String> list = new ArrayList<String>() ;

        BufferedReader in = new BufferedReader(new InputStreamReader(fis)) ;

        String line = null ;
        while ((line = in.readLine()) != null ) {
            line = line.substring(line.indexOf("{") , line.indexOf("}")+1) ;
            list.add(line) ;
        }
        in.close();
        fis.close();
        return list ;
    }



}
