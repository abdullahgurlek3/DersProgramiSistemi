/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entities.ClassRoom;
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
public class ClassRoomDaoImpl implements ClassRoomDao {

    @Autowired
    MySessionFactory mySessionFactoryInstance;

    public void addClassRoom(Long schoolId, ClassRoom classRoom) {
        Session session = mySessionFactoryInstance.getSessionFactory().openSession();
        School school = session.get(School.class, schoolId);
        school.getClassRooms().add(classRoom);
        classRoom.setSchool(school);
        
        session.beginTransaction();
        session.update(school);
        session.save(classRoom);
        session.getTransaction().commit();
        session.close();

    }

    public List<ClassRoom> getAllWithSchool(String lang, Pager pager, Order order, Long schoolId) {
        Session session = mySessionFactoryInstance.getSessionFactory().openSession();
        List<ClassRoom> classRooms = session.createCriteria(ClassRoom.class).createCriteria("school").add(Restrictions.idEq(schoolId)).list();
        session.close();
        return classRooms;
    }

}
