package no.kristiania.pgr200.http;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class HttpQuery {

    private Map<String, String> parameters = new LinkedHashMap<>();


    public HttpQuery(String query) {
        for(String parameter : query.split("&")){
            int equalPos = parameter.indexOf('=');
            String paramName = urlDecode(parameter.substring(0, equalPos));
            String paramValue = urlDecode(parameter.substring(equalPos+1));
            addParameter(paramName.toLowerCase(), paramValue);
        }
    }

    public String getParameter(String parameter) {
        return parameters.get(parameter);
    }

    public void addParameter(String type , String value) {
        parameters.put(type, value);
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for(Map.Entry<String, String> entry : parameters.entrySet()){
            if(result.length()>0) result.append("&");
            result.append(urlEncode(entry.getKey())+"="+urlEncode(entry.getValue()));
        }
        return result.toString();
    }

    private String urlDecode(String substring){
        try{
            return URLDecoder.decode(substring, "UTF-8");
        } catch (UnsupportedEncodingException e){
            throw new RuntimeException(e);
        }
    }

    private String urlEncode(String value){
        try{
            return URLEncoder.encode(value, "UTF-8");
        } catch (UnsupportedEncodingException e){
            throw new RuntimeException(e);
        }
    }
}