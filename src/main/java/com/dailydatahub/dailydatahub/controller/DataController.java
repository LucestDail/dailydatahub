package com.dailydatahub.dailydatahub.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.dailydatahub.dailydatahub.domain.MainCountDashboard;
import com.dailydatahub.dailydatahub.domain.News;
import com.dailydatahub.dailydatahub.module.ElasticSearchComponent;
import com.dailydatahub.dailydatahub.service.MainService;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;

@CrossOrigin
@SuppressWarnings({"unchecked", "unused"})
@Controller
@RequiredArgsConstructor
@RequestMapping("/data")
public class DataController {

	@Autowired
	private ElasticSearchComponent elasticSearchComponent;

	@Autowired
	private MainService mainService;

    @RequestMapping(value = "/newsraw", method = RequestMethod.GET)
	public ModelAndView getNewsraw(Model model
									, HttpServletRequest request
									, @RequestParam("page") Optional<Integer> page
									, @RequestParam("keyword") Optional<String> keyword) {
		ModelAndView mav = new ModelAndView();
		String searchResult = "";
		int currentPage = page.orElse(1);
		String searchKeyword = "";
		if(keyword.isPresent()) searchKeyword = keyword.get();
		try{
			searchResult = elasticSearchComponent.search("bs4news_news", searchKeyword, 20, currentPage);
			JSONParser parser = new JSONParser();  
			JSONObject json = (JSONObject) parser.parse(searchResult);  
			JSONArray hits = (JSONArray)((JSONObject)json.get("hits")).get("hits");
			List<JSONObject> results = new ArrayList<JSONObject>();
			List<News> newslist = new ArrayList<News>();
			for(int i=0; i<hits.size(); i++) {
				JSONObject newsElement = (JSONObject)((JSONObject)hits.get(i)).get("_source");
				News news = new News();
				news.setEtc1(newsElement.get("etc1").toString());
				news.setEtc2(newsElement.get("etc2").toString());
				news.setEtc3(newsElement.get("etc3").toString());
				news.setEtc4(newsElement.get("etc4").toString());
				news.setEtc5(newsElement.get("etc5").toString());
				news.setId(newsElement.get("id").toString());
				news.setNews_createdt(newsElement.get("news_createdt").toString());
				news.setNews_company(newsElement.get("news_company").toString());
				news.setNews_contents(newsElement.get("news_contents").toString());
				news.setNews_contents_raw(newsElement.get("news_contents_raw").toString());
				news.setNews_from(newsElement.get("news_from").toString());
				news.setNews_title(newsElement.get("news_title").toString());
				newslist.add(news);
			}
			mav.addObject("newslist", newslist);
		}catch(Exception e) {
			e.printStackTrace();
			searchResult = "검색에 실패했습니다.";
		}
		mav.setViewName("data/newsraw.html");
		return mav;
	}

	@RequestMapping(value = "/main", method = RequestMethod.GET)
	public ModelAndView getMainData (HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		MainCountDashboard mainCountDashboard = mainService.selectMainCountDashboard().get();
		mav.addObject(mainCountDashboard);
		mav.setViewName("data/main.html");
		return mav;
	}
	

    
}
