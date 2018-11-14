package com.ysm.ublog.utils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SeralizableUtils {

    public static byte[] seralizable(Object object){
        ObjectOutputStream objectOutputStream = null;
        ByteArrayOutputStream byteArrayOutputStream = null;
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
            objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            objectOutputStream.writeObject(object);
            byte[] bytes = byteArrayOutputStream.toByteArray();
            return bytes;
        } catch (Exception e) {
           throw new RuntimeException(e.getMessage());
        }
    }

    public static Object unseralizable(byte[] bytes){
        ObjectInputStream objectInputStream = null;
        ByteArrayInputStream byteArrayInputStream = null;
        try {
            byteArrayInputStream = new ByteArrayInputStream(bytes);
            objectInputStream = new ObjectInputStream(byteArrayInputStream);
            Object o = objectInputStream.readObject();
            return o;
        } catch (Exception e) {
           throw new RuntimeException(e.getMessage());
        }
    }
}
