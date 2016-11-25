package com.mamad.controller.administration;

import java.util.List;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.mamad.model.administration.Workgroup;
import com.mamad.service.WorkgroupService;

@Controller
@RequestMapping("/administration")
public class WorkgroupController {
	
	@Autowired
	private WorkgroupService workgroupService;
	
	/**
	 * redirectering into the manage welcome page for the workgroup, the first page
	 * for the administration side
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView welcomemanage() {
		ModelAndView model = new ModelAndView("WelcomeAdministration");
		return model;		
	}
	
	@RequestMapping(value = "/manageWorkgroup", method = RequestMethod.GET)
	public ModelAndView manageWorkgroup() {
		ModelAndView model = new ModelAndView("ManageWorkgroup");
		model.addObject("workgroup", new Workgroup());
		return model;		
	}
	
	/**
	 *  
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/WorkgroupsList")
	public ModelAndView listWorkgroup() throws Exception {
		List<Workgroup> listeWG = workgroupService.list();
		ModelAndView model = new ModelAndView("WorkgroupList");
		model.addObject("workgroupList", listeWG);
		return model;
	}
	/**
	 * redirect to the welcome page after saving workgroup in a database
	 * @param collaborateur
	 * @return objet ModelAndView qui est la page d'accueil
	 */
	@RequestMapping(value = "/saveWorkgroup", method = RequestMethod.POST)
	public ModelAndView saveWorkgroup(@ModelAttribute Workgroup wg) {
		workgroupService.saveOrUpdate(wg);
		return new ModelAndView("redirect:/");
	}
	/**
	 * Get the workgroup form into the model and view object 
	 * @return objet ModelAndView
	 */
	@RequestMapping(value = "/newWorkgroup", method = RequestMethod.GET)
	public ModelAndView newWorkgroup() {
		ModelAndView model = new ModelAndView("WorkgroupForm");
		model.addObject("workgroup", new Workgroup());
		return model;		
	}
	
	/**
	 * update the workgroup with he id in the httpservletrequest object
	 * then redirect to the welcome page
	 * @param request
	 * @return objet ModelAndView
	 */
	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public ModelAndView modifierUser(HttpServletRequest request) {
		int userId = Integer.parseInt(request.getParameter("id"));
		Workgroup wg = workgroupService.getById(userId);
		ModelAndView model = new ModelAndView("WorkgroupForm");
		model.addObject("workgroup", wg);
		return model;		
	}
	/**
	 * delete a workgroup and redirect to the welcome page
	 * @param request
	 * @return objet ModelAndView, the welcome page here
	 */
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public ModelAndView supprimerUser(HttpServletRequest request) {
		int userId = Integer.parseInt(request.getParameter("id"));
		workgroupService.delete(userId);
		return new ModelAndView("redirect:/");		
	}
	
	@RequestMapping(value = "/managePortfolio",method = RequestMethod.GET)
	public ModelAndView welcomePortfolio() {
		ModelAndView model = new ModelAndView("ManagePortfolio");
		return model;		
	}
	
	
}
