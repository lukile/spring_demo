package com.developpez.lschiada.dao;

import java.util.List;

import com.developpez.lschiada.bean.Course;

public interface IListeCoursesDAO{
	List<Course> rechercherCourses();
	
	//On ajoute la m�thode recevant une entit� en param�tre
	void creerCourse(final Course pCourse);
	
	//On ajoute la m�thode permettant la suppression recevant une entit� en param�tre
	void supprimerCourse(final Course pCourse);
	
	//On ajout la m�thode permettant la modification recevant une entit� en param�tre
	void modifierCourse(final Course pCourse);
}

