package com.mamad.controller;

/*import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.medisys.dao.CompteRenduDao;
import com.medisys.dao.ContactDao;
import com.medisys.dao.administration.WorkgroupDao;
import com.medisys.model.CompteRendu;
import com.medisys.model.Contact;
import com.medisys.model.administration.Workgroup;

import org.springframework.beans.factory.annotation.Autowired;
*/import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
//import com.google.gson.Gson;
//import com.google.gson.GsonBuilder;

/**
 * main controller for handle all request from the welcome page. 
 * it redirect to the other controller whose expect all pattern to 
 * redirect to the other page
 * It the same of servlet in a jsp/servlet architecture
 * @author Mamad
 *
 */
@Controller
public class MainController {
	
	/**
	 * Welcome page goes here
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/")
	public ModelAndView welcome() throws Exception {
		ModelAndView model = new ModelAndView("Welcome");
		return model;
	}

	
}
