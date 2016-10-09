package com.developpez.lschiada;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/bonjour/{personne}")
public class BonjourController{
	
	//le controller traite les requêtes GET dont l'URI est /bonjour
	@RequestMapping(method = RequestMethod.GET)
	
	/*la valeur "Regis" est associé à l'attribut "personne" grâce à addAttribute de ModelMap
	public String afficherBonjour(final ModelMap pModel){
		pModel.addAttribute("personne", "Regis");*/

	//Maintenant on récupère un paramètre de la requête pour le passer à la valeur de l'attribut
	//le paramètre "personne" est récupéré grâce à l'annot RequestParam, dans ce cas
	//il faudra écrire dans l'url : localhost:8080/spring-demo/bonjour?personne=Spring
	//@RequestParam(value="personne") final String pPersonne){
	
	//Mais ici on extrait le paramètre depuis l'URI avec PathVariable
	public String afficherBonjour(final ModelMap pModel,
			
		@PathVariable(value="personne") final String pPersonne) {
		
		pModel.addAttribute("personne", pPersonne);
		
		//redirige vers la ressource bonjour
		return "bonjour";
	}
}