package com.developpez.lschiada.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.developpez.lschiada.bean.Course;

@Repository
public class ListeCoursesDAO implements IListeCoursesDAO {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Course> rechercherCourses() {
        final CriteriaBuilder lCriteriaBuilder = entityManager.getCriteriaBuilder();

        final CriteriaQuery<Course> lCriteriaQuery = lCriteriaBuilder.createQuery(Course.class);
        final Root<Course> lRoot = lCriteriaQuery.from(Course.class);
        lCriteriaQuery.select(lRoot);
        final TypedQuery<Course> lTypedQuery = entityManager.createQuery(lCriteriaQuery);

        return lTypedQuery.getResultList();
    }

    //Sauve la nouvelle entité en base
    public void creerCourse(final Course pCourse){
    	entityManager.persist(pCourse);
  }
    //Supprime l'entité en base
    public void supprimerCourse(final Course pCourse){
    	final Course lCourse = entityManager.getReference(Course.class, pCourse.getId());
    	entityManager.remove(lCourse);
    }
    
    /*Modification. Elle supprime l'entité en base. Elle lève une exception uniquement si la requête modifie un nombre 
     d'occurences différent de 1 (ce qui aura pour conséquence un rollback de transaction au niveau du service, le libellé de 
     l'exception contient le texte de la requête SQL*/
    
    public void modifierCourse(final Course pCourse){
    	final CriteriaBuilder lCriteriaBuilder = entityManager.getCriteriaBuilder();
    	
    	final CriteriaUpdate<Course> lCriteriaUpdate = lCriteriaBuilder.createCriteriaUpdate(Course.class);
    	final Root<Course> lRoot = lCriteriaUpdate.from(Course.class);
    	final Path<Course> lPath = lRoot.get("id");
    	final Expression <Boolean> lExpression = lCriteriaBuilder.equal(lPath, pCourse.getId());
    	lCriteriaUpdate.where(lExpression);
    	lCriteriaUpdate.set("quantite", pCourse.getQuantite());
    	final Query lQuery = entityManager.createQuery(lCriteriaUpdate);
    	final int lRowCount = lQuery.executeUpdate();
    	
    	if(lRowCount != 1){
    		final org.hibernate.Query lHQuery = lQuery.unwrap(org.hibernate.Query.class);
    		final String lSql = lHQuery.getQueryString();
    		throw new RuntimeException("Nombre d'occurences (" + lRowCount + ") modifiées différents de 1 pour " + lSql);
    	}
    }
}

//La DAO "ListeCoursesDAO" permet de lister les entités "Course" contenues dans la base de données