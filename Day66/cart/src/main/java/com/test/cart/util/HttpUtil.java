package com.test.cart.util;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class HttpUtil {
    public static String getJSON(String path){
        try {
            URL url=new URL(path);
            URLConnection con = url.openConnection();
            InputStream in = con.getInputStream();
            BufferedReader reader=new BufferedReader(new InputStreamReader(in));
            String data=null;
            StringBuilder sd=new StringBuilder();
            while( (data=reader.readLine())!=null){
                sd.append(data);
            }
            reader.close();
            return sd.toString();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
