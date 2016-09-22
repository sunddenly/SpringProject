package org.hebut.scse.basic.encode;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

/**
 * Created by jxy on 2016/8/25.
 */
public class Code {
    public static void main(String[] args) throws UnsupportedEncodingException {
        String code = "%E6%B1%89%E5%AD%97";
        String decode = URLDecoder.decode(code,"ISO-8859-1");
        System.out.println(decode);//æ±å­
        byte[] b = decode.getBytes("ISO-8859-1");
        System.out.println(bytesToHexString(b));//e6b189e5ad97
        String name = new String(decode.getBytes("ISO-8859-1"), "utf-8");//汉字
        System.out.println(name);
        System.out.println(getEncoding(name));

        System.out.println("-------------------1");
        String decode1 = URLDecoder.decode(code,"gbk");
        System.out.println(decode1);//æ±å­
        byte[] b1 = decode1.getBytes("gbk");
        System.out.println(bytesToHexString(b1));//e6b189e5ad97
        String name1 = new String(decode1.getBytes("gbk"), "utf-8");//汉字
        System.out.println(name1);

        System.out.println("-------------------2");
        String decode2 = URLDecoder.decode(code,"utf-16");
        System.out.println(decode2);//æ±å­
        byte[] b2 = decode2.getBytes("utf-16");
        System.out.println(bytesToHexString(b2));//e6b189e5ad97
        String name2 = new String(decode2.getBytes("utf-16"), "utf-8");//汉字
        System.out.println(name2);

        System.out.println("-------------------3");
        String decode3 = URLDecoder.decode(code,"ascii");
        System.out.println(decode3);//æ±å­
        byte[] b3 = decode3.getBytes("ascii");
        System.out.println(bytesToHexString(b3));//e6b189e5ad97
        String name3 = new String(decode3.getBytes("ascii"), "utf-8");//汉字
        System.out.println(name3);

        System.out.println("-------------------4");
        String decode4 = URLDecoder.decode(code,"gb2312");
        System.out.println(decode4);//æ±å­
        byte[] b4 = decode4.getBytes("gb2312");
        System.out.println(bytesToHexString(b4));//e6b189e5ad97
        String name4 = new String(decode4.getBytes("gb2312"), "utf-8");//汉字
        System.out.println(name4);

        System.out.println(getEncoding(decode));
        System.out.println(getEncoding(decode1));
        System.out.println(getEncoding(decode2));
        System.out.println(getEncoding(decode3));
        System.out.println(getEncoding(decode4));
        int i=0;

        String s="我";

        byte[] bytes = s.getBytes();//e6-88-91
        System.out.println(bytesToHexString(bytes));
        String s1=new String(bytes);//0x6211 25105
        System.out.println(s1+"--"+ ++i);

        bytes = s.getBytes("utf-8");//e6-88-91
        System.out.println(bytesToHexString(bytes));
        String s2=s=new String(bytes,"utf-8");//0x6211:25105
        System.out.println(s2+"--"+ ++i);

        bytes = s.getBytes("utf-16");//bom:feff-code-6211
        System.out.println(bytesToHexString(bytes));
        s=new String(bytes,"utf-16");//0x6211:25105
        System.out.println(s+"--"+ ++i);

        bytes = s.getBytes("utf-32");//00 00 62 11
        System.out.println(bytesToHexString(bytes));
        s=new String(bytes,"utf-32");//0x6211:25105
        System.out.println(s+"--"+ ++i);

        bytes = s.getBytes("gbk");//ced2
        System.out.println(bytesToHexString(bytes));
        s=new String(bytes,"gbk");//0x6211:25105
        System.out.println(s+"--"+ ++i);

        bytes = s.getBytes("gb2312");//ced2
        System.out.println(bytesToHexString(bytes));
        s=new String(bytes,"gb2312");//0x6211:25105
        System.out.println(s+"--"+ ++i);


    }
    public static String getEncoding(String str) {
        int i=0;
        String encode = "GB2312";
        try {
            byte[] bytes = str.getBytes(encode);
            String str2 = new String(bytes, encode);
            if (str.equals(str2)) {
                System.out.println(bytesToHexString(str.getBytes(encode))+":"+ ++i);
                String s = encode;
                return s;
            }
        } catch (Exception exception) {
        }
        encode = "ISO-8859-1";
        try {
            if (str.equals(new String(str.getBytes(encode), encode))) {
                System.out.println(bytesToHexString(str.getBytes(encode))+":"+ ++i);
                String s1 = encode;
                return s1;
            }
        } catch (Exception exception1) {
        }
        encode = "UTF-8";
        try {
            if (str.equals(new String(str.getBytes(encode), encode))) {
                System.out.println(bytesToHexString(str.getBytes(encode))+":"+ ++i);
                String s2 = encode;
                return s2;
            }
        } catch (Exception exception2) {
        }
        encode = "GBK";
        try {
            if (str.equals(new String(str.getBytes(encode), encode))) {
                System.out.println(bytesToHexString(str.getBytes(encode))+":"+ ++i);
                String s3 = encode;
                return s3;
            }
        } catch (Exception exception3) {
        }
        return null;
    }
    public static String bytesToHexString(byte[] src){
        StringBuilder stringBuilder = new StringBuilder("");
        if (src == null || src.length <= 0) {
            return null;
        }
        for (int i = 0; i < src.length; i++) {
            int v = src[i] & 0xFF;
            String hv = Integer.toHexString(v);
            if (hv.length() < 2) {
                stringBuilder.append(0);
            }
            stringBuilder.append(hv);
        }
        return stringBuilder.toString();
    }
}

