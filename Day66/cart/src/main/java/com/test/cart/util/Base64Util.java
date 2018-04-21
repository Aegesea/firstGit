package com.test.cart.util;

import java.util.Base64;
//base64编解码工具类
public class Base64Util {
    public static String encode(String src){
      return   Base64.getEncoder().encodeToString(src.getBytes());
    }
   public static String  decode(String src){
       byte[] bytes = Base64.getDecoder().decode(src);
       return new String(bytes);
   }
    public static void main(String[] args) {
       // System.out.println(encode("asdf~!@#水电工梵蒂冈"));
        System.out.println(decode("YXNkZn4hQCPmsLTnlLXlt6XmorXokoLlhog="));
    }
}
