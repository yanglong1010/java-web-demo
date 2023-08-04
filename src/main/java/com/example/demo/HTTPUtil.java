package com.example.demo;

import org.apache.http.HttpResponse;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

import java.util.Scanner;

public class HTTPUtil {
    public static void sendRequest(String url) throws Exception {
        int timeout = 5 * 1000;
        RequestConfig config = RequestConfig.custom()
                .setConnectTimeout(timeout)
                .setConnectionRequestTimeout(timeout)
                .setSocketTimeout(timeout).build();

        CloseableHttpClient httpclient = HttpClientBuilder.create().setDefaultRequestConfig(config).build();
        HttpGet httpget = new HttpGet(url);
        HttpResponse httpresponse = httpclient.execute(httpget);
        Scanner sc = new Scanner(httpresponse.getEntity().getContent());
        System.out.println(httpresponse.getStatusLine());
        while(sc.hasNext()) {
            System.out.println(sc.nextLine());
        }
    }
}
