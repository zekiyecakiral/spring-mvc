package com.mkyong.form.web;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.mkyong.form.model.Arac;
import com.mkyong.form.service.AracService;
//import javax.validation.Valid;

//http://www.tikalk.com/redirectattributes-new-feature-spring-mvc-31/
//https://en.wikipedia.org/wiki/Post/Redirect/Get
//http://www.oschina.net/translate/spring-mvc-flash-attribute-example
@Controller("/arac")
public class AracController {

	private final Logger logger = LoggerFactory.getLogger(AracController.class);


	private AracService aracService;
	@Autowired
	public void setUserService(AracService aracService) {
		this.aracService = aracService;
	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index(Model model) {
		logger.debug("index()");
		return "redirect:/arac";
	}


	// list page
	@RequestMapping(value = "/arac", method = RequestMethod.GET)
	public String showAllArac(Model model) {

		logger.debug("showAllArac()");
		model.addAttribute("aracs", aracService.findAll());
	
		return "arac/listarac";

	}
	// show add arac form
	@RequestMapping(value = "/arac/addarac", method = RequestMethod.GET)
	public String showAddAracForm(Model model) {

		logger.debug("showAddAracForm()");
		Arac arac = new Arac();
		// set default value
	
		model.addAttribute("aracForm", arac);
		//populateDefaultModel(model);
		return "arac/aracform";

	}
	// save or update user
		@RequestMapping(value = "/arac", method = RequestMethod.POST)
		public String saveOrUpdateArac(@ModelAttribute("aracForm") @Validated Arac arac,
				BindingResult result, Model model, final RedirectAttributes redirectAttributes) {

			logger.debug("saveOrUpdateArac() : {}", arac);

			if (result.hasErrors()) {
				//populateDefaultModel(model);
				return "arac/aracform";
			} else {

				redirectAttributes.addFlashAttribute("css", "success");
				if(arac.isNew()){
					redirectAttributes.addFlashAttribute("msg", "Arac başarıyla kaydedildi!");
				}else{
					redirectAttributes.addFlashAttribute("msg", "Arac başarıyla güncellendi!");
				}
				
				aracService.saveOrUpdate(arac);
				logger.info("arac kaydedildi.");
				
				// POST/REDIRECT/GET
				return "redirect:/arac/" + arac.getId();

			}

		}
		
		// show arac
		@RequestMapping(value = "/arac/{id}", method = RequestMethod.GET)
		public String showArac(@PathVariable("id") int id, Model model) {

			logger.debug("showArac() id: {}", id);

			Arac arac = aracService.findById(id);
			if (arac == null) {
				model.addAttribute("css", "danger");
				model.addAttribute("msg", "Arac not found");
			}
			model.addAttribute("arac", arac);

			return "arac/showarac";

		}
		// show update form
		@RequestMapping(value = "/arac/{id}/update", method = RequestMethod.GET)
		public String showUpdateAracForm(@PathVariable("id") int id, Model model) {

			logger.debug("showUpdateAracForm() : {}", id);

			Arac arac = aracService.findById(id);
			model.addAttribute("aracForm", arac);
			return "arac/aracform";

		}
		// delete arac
		@RequestMapping(value = "/arac/{id}/delete", method = RequestMethod.POST)
		public String deleteArac(@PathVariable("id") int id, final RedirectAttributes redirectAttributes) {

			logger.debug("deleteArac() : {}", id);

			aracService.delete(id);
			
			redirectAttributes.addFlashAttribute("css", "success");
			redirectAttributes.addFlashAttribute("msg", "Arac silindi!");
			
			return "redirect:/arac";

		}
	
	
	
}