/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import controllers.sub.AbstractController;
import dao.LessonDaoImpl;
import dao.SchoolDaoImpl;
import entities.Lesson;
import entities.School;
import java.util.List;
import javax.validation.Valid;
import modelattributes.SearchAttribute;
import modelattributes.sub.AbstractAtttribute;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import view.Order;
import view.Pager;

/**
 *
 * @author Abdullah Gürlek <abdullah.gurlek3 at gmail.com>
 */
@Controller
@RequestMapping("/lesson")
public class LessonController extends AbstractController {

    @Autowired
    LessonDaoImpl lessonDaoImpl;

    @Autowired
    SchoolDaoImpl schoolDaoImpl;

    @Override
    public String index(Pager pager, ModelMap map) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String add(ModelMap map, String lang) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @RequestMapping(value = "/add/{schoolId}", method = RequestMethod.GET)
    public String addWithSchool(ModelMap map, String lang, @PathVariable("schoolId") Long schoolId) {
        map.addAttribute("Lesson", new Lesson());
        return "addLesson";
    }

    @RequestMapping(value = "/add/{schoolId}", method = RequestMethod.POST)
    public String addWithSchoolOk(ModelMap map, String lang, @Valid @ModelAttribute("Lesson") Lesson lesson,
            BindingResult result, @PathVariable("schoolId") Long schoolId) {
        if (result.hasErrors()) {
            return "addLesson";
        }

        schoolDaoImpl.addLesson(schoolId, lesson);

        return "redirect:../showAll/" + schoolId;
    }

    @Override
    public String edit(Long id, ModelMap map, String lang) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String editAll(Pager pager, ModelMap map, Order order, String lang) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String editSearch(AbstractAtttribute abstractAtttribute, ModelMap map, Order order, String lang) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String deleteOk(Long id, String lang) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String show(Long id, ModelMap map, String lang) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String showAll(ModelMap map, Pager pager, Order order, String lang) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @RequestMapping("/showAll/{schoolId}")
    public String showAllWithSchool(ModelMap map, Pager pager, Order order,
            String lang, @PathVariable("schoolId") Long schoolId) {
        List<Lesson> lessons = lessonDaoImpl.getAllWithSchool(lang, pager, order, schoolId);
        map.addAttribute("lessons", lessons);
        return "lessons";
    }

    @Override
    public String category(ModelMap map, String titleClean, Pager pager, Order order, String lang) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String tag(ModelMap map, String titleClean, Pager pager, Order order, String lang) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String search(SearchAttribute searchAttribute, Pager pager, ModelMap map, Order order, String lang) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
