package com.developpez.lschiada;

import java.util.List;

import javax.validation.Valid;

/*Contient une liste qui comporte l'annotation @Valid afin de provoquer la validation de chaque 
  �l�ment de la liste lorsque le formulaire sera valid� en entr�e de la m�thode "modifier" du contr�leur */

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
 