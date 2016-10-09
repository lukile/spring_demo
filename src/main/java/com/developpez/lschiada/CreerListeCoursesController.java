package com.developpez.lschiada;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.developpez.lschiada.bean.Course;
import com.developpez.lschiada.services.IServiceListeCourses;

//Comporte 2 méthodes : afficher et creer
@Controller
public class CreerListeCoursesController{
	
	@Autowired
	private IServiceListeCourses service;
	
	@RequestMapping(value="/afficherCreationListeCourses", method = RequestMethod.GET)
	//La méthode place la liste des courses dans l'attribut "listeCourses" et initialise le formulaire "creation"
	//S'il n'est pas déjà présent dans l'attribut "creation"
	public String afficher(final ModelMap pModel){
		final List<Course> lListeCourses = service.rechercherCourses();
		pModel.addAttribute("listeCourses", lListeCourses);
		
		if(pModel.get("creation") == null){
			pModel.addAttribute("creation", new CreationForm());
		}
		return "creation";
	}
	
	@RequestMapping(value="/creerCreationListeCourses", method = RequestMethod.POST)
	//"@ModelAttribute" indique que le paramètre "pCreation" est constitué à partir de l'attribut "creation"
	//"@Valid" indique que le formulaire doit être validé grâce aux annotations contenues dans "CreationForm" 
	
	//La méthode "creer" appelle la méthode de création en bdd s'il n'y a pas d'erreurs de validation, puis appelle la méthode "afficher"
	public String creer(@Valid @ModelAttribute(value="creation") final CreationForm pCreation,
			final BindingResult pBindingResult, final ModelMap pModel){
		
		if(!pBindingResult.hasErrors()){
			final Integer lIntQuantite = Integer.valueOf(pCreation.getQuantite());
			service.creerCourse(pCreation.getLibelle(), lIntQuantite);
		}
		return afficher(pModel);
	}
}
//Les messages d'erreurs sont présents dans le "messages_fr.properties"