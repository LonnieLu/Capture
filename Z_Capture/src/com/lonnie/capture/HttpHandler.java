package com.lonnie.capture;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class HttpHandler {
  
  public static int time_out_value= 5*60*1000;
  private String httprequestMethod = "GET";

  public String getHtmlContentByUrl(String url) {
    
    BufferedReader l_reader = null;
    StringBuffer sTotalString = new StringBuffer();
    
    URL reUrl;
    try {
      reUrl = new URL(url);
      HttpURLConnection http = null;
      http = (HttpURLConnection) reUrl.openConnection();
      http.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1) AppleWebKit/536.11 (KHTML, like Gecko) Chrome/20.0.1132.57 Safari/536.11");
      http.setConnectTimeout(time_out_value);
      http.setReadTimeout(time_out_value); 
      http.setRequestMethod(httprequestMethod);
      http.setDoOutput(true);
      
      l_reader = new BufferedReader(new InputStreamReader(http.getInputStream(),"GB2312"));
      String sCurrentLine = null;
      while ((sCurrentLine = l_reader.readLine()) != null)
      {
        sTotalString.append(sCurrentLine);
        sTotalString.append("\r\n");
      }
    } catch (MalformedURLException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
    return sTotalString.toString();
  }
}
