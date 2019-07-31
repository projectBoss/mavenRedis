package com.util;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerUtil {
    /**
     * 序列化
     * 
     * @param object
     * @return
     */
    public static byte[] serialize(Object object) {
        ObjectOutputStream Oput = null;
        ByteArrayOutputStream Bput = null;
        try {
        	Bput = new ByteArrayOutputStream();
        	Oput = new ObjectOutputStream(Bput);
        	Oput.writeObject(object);
            byte[] bytes = Bput.toByteArray();
            return bytes;
        } catch (Exception e) {
        }
        return null;
    }

    /**
     * fan序列化
     * @param bytes
     * @return
     */
    public static Object noserialize(byte[] bytes) {
        ByteArrayInputStream noserialize = null;
        try {
        	noserialize = new ByteArrayInputStream(bytes);
            ObjectInputStream ois = new ObjectInputStream(noserialize);
            return ois.readObject();
        } catch (Exception e) {

        }
        return null;
    }

}