/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entities.Lesson;
import entities.School;
import java.util.List;
import org.hibernate.FetchMode;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import view.Order;
import view.Pager;

/**
 *
 * @author Abdullah Gürlek <abdullah.gurlek3 at gmail.com>
 */
@Component
public class SchoolDaoImpl implements SchoolDao {

    @Autowired
    MySessionFactory mySessionFactoryInstance;

    @Override
    public List<School> getAll(String lang, Pager pager, Order order) {
        Session session = mySessionFactoryInstance.getSessionFactory().openSession();
        List<School> schools = session.createCriteria(School.class).list();
        session.close();;
        return schools;
    }

    public void insert(School school) {
        Session session = mySessionFactoryInstance.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(school);
        session.getTransaction().commit();
        session.close();;

    }

    public School get(Long schoolId) {
        Session session = mySessionFactoryInstance.getSessionFactory().openSession();
        School school = (School) session.createCriteria(School.class)
                .add(Restrictions.idEq(schoolId))
                .setFetchMode("lessons", FetchMode.EAGER)
                .setMaxResults(1)
                .uniqueResult();
        session.close();;
        return school;

    }

    public void addLesson(Long schoolId, Lesson lesson) {
        Session session = mySessionFactoryInstance.getSessionFactory().openSession();
        School school = session.get(School.class, schoolId);
        school.getLessons().add(lesson);
        lesson.setSchool(school);
        session.save(lesson);
        session.update(school);
        session.close();;
    }

}
