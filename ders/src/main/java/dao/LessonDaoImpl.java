/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entities.Lesson;
import entities.School;
import java.util.List;
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
public class LessonDaoImpl implements LessonDao {

    @Autowired
    MySessionFactory mySessionFactoryInstance;

    @Override
    public List<Lesson> getAll(String lang, Pager pager, Order order) {
        Session session = mySessionFactoryInstance.getSessionFactory().openSession();
        List allList = session.createCriteria(Lesson.class).list();
        session.close();
        return allList;
    }

    public List<Lesson> getAllWithSchool(String lang, Pager pager, Order order, Long schoolId) {
        Session session = mySessionFactoryInstance.getSessionFactory().openSession();
        List allList = session.createCriteria(Lesson.class).createCriteria("school")
                .add(Restrictions.idEq(schoolId)).list();
        session.close();;
        return allList;
    }

}
