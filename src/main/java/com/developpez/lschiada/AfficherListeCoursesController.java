package com.developpez.lschiada;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.developpez.lschiada.bean.Course;
import com.developpez.lschiada.services.IServiceListeCourses;

@Controller
@RequestMapping(value="/afficherListeCourses")
public class AfficherListeCoursesController {

    @Autowired
    private IServiceListeCourses service;

    @RequestMapping(method = RequestMethod.GET)
    public String afficher(ModelMap pModel) {
        final List<Course> lListeCourses = service.rechercherCourses();
        pModel.addAttribute("listeCourses", lListeCourses);
        return "listeCourses";
    }
}

//Le controleur "AfficherListeCoursesController" appelle le service et place
//le résultat dans l'attribut "listeCourses"