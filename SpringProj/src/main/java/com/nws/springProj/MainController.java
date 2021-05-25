package com.nws.springProj;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */

/*
 * servlet-context.xml의 component-scan에 의해서 HomeController의 @Controller이 읽혀
 * bean으로 등록되었고, annotation-driven은 @RequestMapping을 읽어들이면서 해당 요청(/)을 처리할 수 있는
 * Controller를 찾아냄.
 */
@Controller
public class MainController {

	private static final Logger logger = LoggerFactory.getLogger(MainController.class);

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);

		model.addAttribute("serverTime", formattedDate);

		return "main";
	}

}
