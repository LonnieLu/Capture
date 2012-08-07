package com.lonnie.capture;

import java.util.List;

import com.lonnie.capture.model.CaptureNews;

public interface CaptureParser {

  List<String> getNewsUrlList();
  
  List<CaptureNews> getNewsList(List<String> newsListUrl);
}
