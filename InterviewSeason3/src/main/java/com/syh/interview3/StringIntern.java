package com.syh.interview3;

/**
 * @author hsy
 * @date 2021/4/20
 */
public class StringIntern {

    public static void main(String[] args) {
        String str1 = new StringBuilder("哈哈").append("您好").toString();
        System.out.println("str1 = " + str1);
        System.out.println("str2 = " + str1.intern());
        System.out.println(str1 == str1.intern());

        String str3 = new StringBuilder("ja").append("va").toString();
        System.out.println("str3 = " + str3);
        System.out.println("str4 = " + str3.intern());
        System.out.println(str3 == str3.intern());


    }
}
