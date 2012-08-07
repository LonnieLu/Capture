package com.lonnie.capture;

import java.util.ArrayList;
import java.util.List;

import com.lonnie.capture.model.CaptureNews;


public class CaptureService {
  
  public List<CaptureNews> getCaptureNews() {
    List<CaptureNews> news = new ArrayList<CaptureNews>();
    
    //Get news list
    CaptureParser sinaParser = new SinaCaptureParserImpl();
    news.addAll(sinaParser.getNewsList(sinaParser.getNewsUrlList()));
    
    //Get news list
    CaptureParser wangyiParser = new WangYiCaptureParserImpl();
    news.addAll(wangyiParser.getNewsList(wangyiParser.getNewsUrlList()));
    
    //Get news list
    CaptureParser tenxunParser = new TenXunCaptureParserImpl();
    news.addAll(tenxunParser.getNewsList(tenxunParser.getNewsUrlList()));
    return news;
  }

}
