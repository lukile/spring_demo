package com.developpez.lschiada.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.developpez.lschiada.bean.Course;
import com.developpez.lschiada.dao.IListeCoursesDAO;

@Service
public class ServiceListeCourses implements IServiceListeCourses {
	
	private final IListeCoursesDAO dao;
	
	@Autowired	
	public ServiceListeCourses(IListeCoursesDAO dao) {
		this.dao = dao;
	}

	//Transation en lecture seule
	@Transactional(readOnly=true)
	public List<Course> rechercherCourses(){
		return dao.rechercherCourses();
	}
	
	//Constitue l'entité et l'envoie en paramètre à la DAO
	@Transactional
	public void creerCourse(final String pLibelle, final Integer pQuantite){
		final Course lCourse = new Course();
		lCourse.setLibelle(pLibelle);
		lCourse.setQuantite(pQuantite);
		
		dao.creerCourse(lCourse);
	}
	//Instancie une entité avec l'identifiant et l'envoie en paramètre à la DAO
	@Transactional
    public void supprimerCourse(final Integer pIdCourse){
    	final Course lCourse = new Course();
    	lCourse.setId(pIdCourse);
    	
    	dao.supprimerCourse(lCourse);
    }
	
	@Transactional 
	public void modifierCourse(final List<Course> pListeCourses){
		for(final Course lCourse : pListeCourses){
			dao.modifierCourse(lCourse);
		}
		
	}

}
