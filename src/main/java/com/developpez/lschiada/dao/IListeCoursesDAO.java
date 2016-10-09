package com.developpez.lschiada.dao;

import java.util.List;

import com.developpez.lschiada.bean.Course;

public interface IListeCoursesDAO{
	List<Course> rechercherCourses();
	
	//On ajoute la méthode recevant une entité en paramètre
	void creerCourse(final Course pCourse);
	
	//On ajoute la méthode permettant la suppression recevant une entité en paramètre
	void supprimerCourse(final Course pCourse);
	
	//On ajout la méthode permettant la modification recevant une entité en paramètre
	void modifierCourse(final Course pCourse);
}

