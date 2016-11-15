/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entities.Class;
import entities.School;
import java.util.List;
import java.util.Set;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author Abdullah Gürlek <abdullah.gurlek3 at gmail.com>
 */
@Component
public class ClassDaoImpl implements ClassDao {

    @Autowired
    MySessionFactory mySessionFactoryInstance;

    public List<entities.Class> getAllWithSchool(String lang, Object object, Object object0, long id) {
        Session session = mySessionFactoryInstance.getSessionFactory().openSession();
        List classes = session.createCriteria(entities.Class.class)
                .createCriteria("school")
                .add(Restrictions.idEq(id))
                .list();
        session.close();
        return classes;
    }

    public void insert(Long schoolId, Class class1) {
        Session session = mySessionFactoryInstance.getSessionFactory().openSession();
        School school = session.get(School.class, schoolId);
        Set<Class> classes = school.getClasses();
        classes.add(class1);
        
        class1.setSchool(school);
        school.setClasses(classes);

        session.beginTransaction();
        session.update(school);
        session.save(class1);
        session.getTransaction().commit();
        session.close();
    }

}
