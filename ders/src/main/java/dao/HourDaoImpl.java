/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entities.Hour;
import entities.School;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author Abdullah Gürlek <abdullah.gurlek3 at gmail.com>
 */
@Component
public class HourDaoImpl implements HourDao {

    @Autowired
    MySessionFactory mySessionFactoryInstance;

    public void addHour(Long schoolId, String[] hourIds) {
        Session session = mySessionFactoryInstance.getSessionFactory().openSession();
        session.beginTransaction();
        School school = session.get(School.class, schoolId);

        for (String hourId : hourIds) {
            Hour hour = new Hour();
            hour.setName(hourId);
            hour.setSchool(school);
            if (school.getHours().contains(hour)) {

            } else {
                school.getHours().add(hour);
                session.save(hour);
            }
        }
        session.update(school);

        session.getTransaction().commit();
        session.close();
    }

}
