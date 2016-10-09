package com.developpez.lschiada;

import java.util.List;

import javax.validation.Valid;

/*Contient une liste qui comporte l'annotation @Valid afin de provoquer la validation de chaque 
  élément de la liste lorsque le formulaire sera validé en entrée de la méthode "modifier" du contrôleur */

public class ModificationForm{
	
	@Valid
	private List<ModificationCourse> listeCourses;
	
	public void setListeCourses(final List<ModificationCourse> pListeCourses){
		listeCourses = pListeCourses;
	}
	
	public List<ModificationCourse> getListeCourses(){
		return listeCourses;
	}
}
 