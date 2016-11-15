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
import view.Order;
import view.Pager;

/**
 *
 * @author Abdullah Gürlek <abdullah.gurlek3 at gmail.com>
 */
public interface TeacherDao {

    public List<Teacher> getAll(String lang, Pager pager, Order order);

    public void insert(Teacher teacher);

    void addTeacher(Long schoolId, Teacher teacher);

}
