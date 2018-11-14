package com.ysm.ublog.utils;

public class RandomNumUtils {

    public static String randomnummber(int length){
        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i <length; i++) {
            int num = (int)(Math.random()*10);
            buffer.append(num);
        }
        return buffer.toString();
    }


    public static void main(String[] args){
        String randomnummber = randomnummber(6);
        System.out.println(randomnummber);
    }
}
