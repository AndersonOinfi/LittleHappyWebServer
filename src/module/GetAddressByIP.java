package module;

import cons.Constant;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class GetAddressByIP {
    public static String Get(String ip) throws IOException{
        URL search_url=new URL(Constant.IP_SEARCHER_URLS.getFirst()+ip+"&format=text");
        HttpURLConnection urlConnection=(HttpURLConnection)search_url.openConnection();
        /*
         ***复习文件读写***
         */
        InputStream stream=urlConnection.getInputStream();
        BufferedReader reader=new BufferedReader(new InputStreamReader(stream, "Utf-8"));
        String address="";
        String tmp;
        while ((tmp=reader.readLine())!=null){
            address+=tmp;
        }
        // todo
        System.out.println(address);
        reader.close();
        return address;
    }
}
