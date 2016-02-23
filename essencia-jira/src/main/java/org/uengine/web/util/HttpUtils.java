package org.uengine.web.util;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.*;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by uengine on 2016. 2. 22..
 */
public class HttpUtils {

    public HttpResponse makeRequest(String type, String uri, String data, Map<String, String> headers) throws IOException {
        HttpRequestBase request = null;

        switch (type) {
            case "GET":
                request = new HttpGet(uri);
                break;
            case "POST":
                request = new HttpPost(uri);
                break;
            case "PUT":
                request = new HttpPut(uri);
                break;
            case "DELETE":
                request = new HttpDelete(uri);
                break;
            default:
                throw new RuntimeException("Invalid HTTP request type: " + type);
        }

        if (headers != null) {
            for (Map.Entry<String, String> header : headers.entrySet()) {
                request.setHeader(header.getKey(), header.getValue());
            }
        }

        if (data != null) {
            try {
                if (request instanceof HttpPut)
                    ((HttpPut) request).setEntity(new StringEntity(data, "UTF-8"));
                if (request instanceof HttpPost)
                    ((HttpPost) request).setEntity(new StringEntity(data, "UTF-8"));
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        }

        HttpClient client = new DefaultHttpClient();

        System.out.println("Making " + request.getMethod() + " request to: " + uri);
        HttpResponse httpResponse = client.execute(request);

        return httpResponse;
    }
}
