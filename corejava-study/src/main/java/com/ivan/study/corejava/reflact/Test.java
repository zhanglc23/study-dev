package com.ivan.study.corejava.reflact;

import java.lang.reflect.Field;

/**
 * Description:
 * author zhanglc
 * Created on 2018/9/5.
 */

public class Test {

    public static void main(String[] args) {

        try {
            Class<?> aClass = ClassLoader.getSystemClassLoader().loadClass("com.ivan.study.corejava.reflact.App");

            Field[] fields1 = aClass.getDeclaredFields();
            for (Field f : fields1) {
                f.setAccessible(true);
                System.out.println(f.getName() );
            }

            Field[] fields = aClass.getFields();
            for (Field f : fields) {
                System.out.println(f.getName() +"  " + (String) f.get(f.getName()));
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

//        try {
//            Class<?> clazz = Class.forName("com.ivan.study.corejava.reflact.App");
//
//            Field[] fields = clazz.getFields();
//            for (Field f : fields) {
//                System.out.println(f.getName() +"  " + (String) f.get(f.getName()));
//            }
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
//        }


    }


}
