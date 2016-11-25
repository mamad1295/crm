package com.mamad.controller.administration;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/administration/managePortfolio")
public class PortfolioController {
	/**
	 * This method adds ManagePortfolio page to the model and view object 
	 * when handle the requuest /administration/manageportfolio
	 * @return model and view object
	 */
	@RequestMapping(value = "/managePortfolio",method = RequestMethod.GET)
	public ModelAndView welcomePortfolio() {
		ModelAndView model = new ModelAndView("ManagePortfolio");
		return model;		
	}
	
}
