/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entities.Lesson;
import entities.School;
import java.util.List;
import org.springframework.stereotype.Component;
import view.Order;
import view.Pager;

/**
 *
 * @author Abdullah Gürlek <abdullah.gurlek3 at gmail.com>
 */
interface SchoolDao {

    public List<School> getAll(String lang, Pager pager, Order order);

    public void insert(School school);

    void addLesson(Long schoolId, Lesson lesson);
}
