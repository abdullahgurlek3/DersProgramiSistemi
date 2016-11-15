/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entities.Lesson;
import entities.School;
import entities.Teacher;
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
public class TeacherDaoImpl implements TeacherDao {
    
    @Autowired
    MySessionFactory mySessionFactoryInstance;
    
    @Override
    public List<Teacher> getAll(String lang, Pager pager, Order order) {
        Session session = mySessionFactoryInstance.getSessionFactory().openSession();
        List<Teacher> schools = session.createCriteria(Teacher.class).list();
        session.close();;
        return schools;
    }
    
    public void insert(Teacher teacher) {
        Session session = mySessionFactoryInstance.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(teacher);
        session.getTransaction().commit();
        session.close();;
        
    }
    
    public Teacher get(Long schoolId) {
        Session session = mySessionFactoryInstance.getSessionFactory().openSession();
        Teacher teacher = session.get(Teacher.class, schoolId);
        session.close();;
        return teacher;
        
    }
    
    @Override
    public void addTeacher(Long schoolId, Teacher teacher) {
        Session session = mySessionFactoryInstance.getSessionFactory().openSession();
        School school = session.get(School.class, schoolId);
        school.getTeachers().add(teacher);
        teacher.setSchool(school);
        session.save(teacher);
        session.update(school);
        session.close();;
        
    }
    
    public List<Teacher> getAllWithSchool(String lang, Pager pager, Order order, Long schoolId) {
        Session session = mySessionFactoryInstance.getSessionFactory().openSession();
        List allList = session.createCriteria(Teacher.class).createCriteria("school")
                .add(Restrictions.idEq(schoolId)).list();
        session.close();;
        return allList;
    }
    
    public Teacher getWithLessons(Long teacherId) {
        Session session = mySessionFactoryInstance.getSessionFactory().openSession();
        Teacher teacher = (Teacher) session.createCriteria(Teacher.class)
                .add(Restrictions.idEq(teacherId))
                .setFetchMode("lessons", FetchMode.EAGER)
                .uniqueResult();
        session.close();;
        return teacher;
    }
    
    public Teacher getWithClasses(Long teacherId) {
        Session session = mySessionFactoryInstance.getSessionFactory().openSession();
        Teacher teacher = (Teacher) session.createCriteria(Teacher.class)
                .add(Restrictions.idEq(teacherId))
                .setFetchMode("classes", FetchMode.EAGER)
                .uniqueResult();
        session.close();;
        return teacher;
        
    }
    
    public void updateLessons(Long teacherId, Long[] lessonIds) {
        Session session = mySessionFactoryInstance.getSessionFactory().openSession();
        session.beginTransaction();
        Teacher teacher = session.get(Teacher.class, teacherId);
        List<Lesson> lessons = session.createCriteria(Lesson.class)
                .add(Restrictions.in("id", lessonIds))
                .list();
        
        for (Lesson lesson : lessons) {
            lesson.getTeachers().add(teacher);
            session.update(lesson);
        }
        
        teacher.getLessons().addAll(lessons);
        session.update(teacher);
        session.getTransaction().commit();
        session.close();
    }
    
    public void updateClasses(Long teacherId, Long[] classesIds) {
        Session session = mySessionFactoryInstance.getSessionFactory().openSession();
        session.beginTransaction();
        Teacher teacher = session.get(Teacher.class, teacherId);
        List<entities.Class> classes = session.createCriteria(entities.Class.class)
                .add(Restrictions.in("id", classesIds))
                .list();
        
        teacher.getClasses().addAll(classes);
        for (entities.Class classe : classes) {
            classe.getTeachers().add(teacher);
            session.update(classe);
        }
        
        session.update(teacher);
        session.getTransaction().commit();
        session.close();
        
    }
    
}
