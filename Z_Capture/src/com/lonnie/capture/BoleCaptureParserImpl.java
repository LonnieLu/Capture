package com.lonnie.capture;

import java.util.ArrayList;
import java.util.List;

import com.lonnie.capture.model.CaptureNews;

public class BoleCaptureParserImpl implements CaptureParser {
  
  private String sinaUrl = "http://blog.jobbole.com/";
  private HttpHandler httpHandler;
  
  public BoleCaptureParserImpl() {
    this.httpHandler = new HttpHandler();
  }

  public List<String> getNewsUrlList() {
    List<String> urls = new ArrayList<String>();
    String content = httpHandler.getHtmlContentByUrl(sinaUrl);
    System.out.println(content);
    return urls;
  }

  public List<CaptureNews> getNewsList(List<String> newsListUrl) {
    List<CaptureNews> captureNews = new ArrayList<CaptureNews>();
    if (newsListUrl.size() > 0) {
      for (int i = 0; i < newsListUrl.size(); i++) {
        CaptureNews news = new CaptureNews();
        String content = httpHandler.getHtmlContentByUrl(newsListUrl.get(i));
        System.out.println(content);
        captureNews.add(news);
      }
    }
    return captureNews;
  }

  public HttpHandler getHttpHandler() {
    return httpHandler;
  }

  public void setHttpHandler(HttpHandler httpHandler) {
    this.httpHandler = httpHandler;
  }

}
