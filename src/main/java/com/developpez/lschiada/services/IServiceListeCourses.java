package com.developpez.lschiada.services;

import java.util.List;

import com.developpez.lschiada.bean.Course;

public interface IServiceListeCourses{
	List<Course> rechercherCourses();
	
	//on ajoute la méthode recevant en paramètres les valeurs de l'entité
	void creerCourse(final String pLibelle, final Integer pQuantite);
	
	//On ajoute la méthode de suppression recevant en paramètre l'identifiant de l'entité
	void supprimerCourse(final Integer pIdCourse);
	
	//On ajout la méthode de modification recevant en paramètre une liste d'entités
	void modifierCourse(final List<Course> pListeCourses);
}