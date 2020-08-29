package io.kai.springboot.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import io.kai.springboot.topic.Topic;
import io.kai.springboot.topic.TopicService;

@Controller
//@RequestMapping("/")
public class DirectHomeController {
	
	@Autowired
	private TopicService topicService;
	
	/**
	 * 首頁
	 * 
	 * @param locale
	 *            Locale
	 * @param model
	 *            Model
	 * @return 轉址
	 */
	@RequestMapping("/home")
	public String home() {
		return new ModelAndView("home");
	}
	
	@RequestMapping("/topics2")
	public List<Topic> getAllTopics() {
		return topicService.getAllTopics();
	}
}
