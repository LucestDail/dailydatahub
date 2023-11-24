package com.dailydatahub.dailydatahub.module;

import org.apache.http.Header;
import org.apache.http.HttpHost;
import org.apache.http.RequestLine;
import org.apache.http.util.EntityUtils;
import org.elasticsearch.client.Request;
import org.elasticsearch.client.Response;
import org.elasticsearch.client.RestClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class ElasticSearchComponent {

    private RestClient restClient;
    private Request request;
    private Response response;

    @Value("${elasticsearch.url}")
    private String elasticsearchUrl;

    @Value("${elasticsearch.protocol}")
    private String elasticsearchProtocol;

    @Value("${elasticsearch.port}")
    private int elasticsearchPort;

    public String search(String index, String keyword, int size, int page) throws Exception {
        restClient = RestClient.builder(new HttpHost(elasticsearchUrl, elasticsearchPort, elasticsearchProtocol)).build();
        request = requestBuilder(index, false);
        searchBuilder(keyword, size, page);
        response = restClient.performRequest(request);
        restClient.close();
        return EntityUtils.toString(response.getEntity()); 
    }

    public String searchCount(String index, String keyword) throws Exception {
        restClient = RestClient.builder(new HttpHost(elasticsearchUrl, elasticsearchPort, elasticsearchProtocol)).build();
        request = requestBuilder(index, true);
        searchCountBuilder(keyword);
        response = restClient.performRequest(request);
        return EntityUtils.toString(response.getEntity()); 
    }

    private void searchBuilder(String keyword, int size, int page){
        String query = "";
        if(keyword == null || keyword.isEmpty() || keyword.trim() == ""){
            query = "{\"query\": {\"match_all\": {}},\"size\":" + String.valueOf(size) + ",\"from\":" + String.valueOf(size*page) + ",\"sort\": {\"news_createdt\":\"desc\"}}";
        }else{
            query = "{\"query\": {\"query_string\": {\"query\":\"*" + keyword + "*\"}},\"size\":" + String.valueOf(size) + ",\"from\":" + String.valueOf(size*page) + ",\"sort\": {\"news_createdt\":\"desc\"}}";
        }
        request.setJsonEntity(query);
    }

    private void searchCountBuilder(String keyword){
        String query = "";
        if(keyword == null || keyword.isEmpty()){
            query = "{\"query\": {\"match_all\": {}}}";
        }else{
            query = "{\"query\": {\"query_string\": {\"query\":\"*" + keyword + "*\"}}}";
        }
        request.setJsonEntity(query);
    }

    private Request requestBuilder(String index, boolean isCount){
        return isCount ? new Request("POST", "/" + index + "/_count") : new Request("POST", "/" + index + "/_search");
    }

}