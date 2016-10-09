package com.developpez.lschiada.services;

import java.util.List;

import com.developpez.lschiada.bean.Course;

public interface IServiceListeCourses{
	List<Course> rechercherCourses();
	
	//on ajoute la m�thode recevant en param�tres les valeurs de l'entit�
	void creerCourse(final String pLibelle, final Integer pQuantite);
	
	//On ajoute la m�thode de suppression recevant en param�tre l'identifiant de l'entit�
	void supprimerCourse(final Integer pIdCourse);
	
	//On ajout la m�thode de modification recevant en param�tre une liste d'entit�s
	void modifierCourse(final List<Course> pListeCourses);
}