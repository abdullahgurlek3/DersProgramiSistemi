/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import controllers.sub.AbstractController;
import dao.ClassDaoImpl;
import dao.LessonDaoImpl;
import dao.TeacherDaoImpl;
import entities.Lesson;
import entities.Teacher;
import java.util.List;
import java.util.Set;
import javax.validation.Valid;
import modelattributes.SearchAttribute;
import modelattributes.sub.AbstractAtttribute;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import view.Order;
import view.Pager;

/**
 *
 * @author Abdullah Gürlek <abdullah.gurlek3 at gmail.com>
 */
@Component
@RequestMapping("/teacher")
public class TeacherController extends AbstractController {

    @Autowired
    TeacherDaoImpl teacherDaoImpl;

    @Autowired
    LessonDaoImpl lessonDaoImpl;

    @Autowired
    ClassDaoImpl classDaoImpl;

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
        map.addAttribute("Teacher", new Teacher());
        return "addTeacher";
    }

    @RequestMapping(value = "/add/{schoolId}", method = RequestMethod.POST)
    public String addWithSchoolOk(ModelMap map, String lang, @Valid @ModelAttribute("Teacher") Teacher teacher,
            BindingResult result, @PathVariable("schoolId") Long schoolId) {
        if (result.hasErrors()) {
            return "addLesson";
        }

        teacherDaoImpl.addTeacher(schoolId, teacher);

        return "redirect:../showAll/" + schoolId;
    }

    @RequestMapping(value = "/editLessons/{teacherId}", method = RequestMethod.GET)
    public String editLessons(ModelMap map, String lang, @PathVariable("teacherId") Long teacherId) {
        Teacher teacher = teacherDaoImpl.getWithLessons(teacherId);
        map.addAttribute("lessons", lessonDaoImpl.getAllWithSchool(lang, null, null, teacher.getSchool().getId()));
        Set<Lesson> selectedLessons = teacher.getLessons();
        map.addAttribute("selectedLessons", selectedLessons);

        return "editLessons";
    }

    @RequestMapping(value = "/editLessons/{teacherId}", method = RequestMethod.POST)
    public String editLessonsOk(ModelMap map, String lang, @PathVariable("teacherId") Long teacherId,
            @RequestParam("lessons[]") Long[] lessonIds) {
        teacherDaoImpl.updateLessons(teacherId, lessonIds);
        return "ok";
    }

    @RequestMapping(value = "/editClasses/{teacherId}", method = RequestMethod.GET)
    public String editClasses(ModelMap map, String lang, @PathVariable("teacherId") Long teacherId) {
        Teacher teacher = teacherDaoImpl.getWithClasses(teacherId);
        map.addAttribute("classes", classDaoImpl.getAllWithSchool(lang, null, null, teacher.getSchool().getId()));
        Set<entities.Class> selectedClasses = teacher.getClasses();
        map.addAttribute("selectedClasses", selectedClasses);

        System.err.println(selectedClasses);

        return "editClasses";
    }

    @RequestMapping(value = "/editClasses/{teacherId}", method = RequestMethod.POST)
    public String editClassesOk(ModelMap map, String lang, @PathVariable("teacherId") Long teacherId,
            @RequestParam("classes[]") Long[] classesIds) {
        teacherDaoImpl.updateClasses(teacherId, classesIds);
        return "redirect:../showAll/" + teacherId;
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
        List<Teacher> teachers = teacherDaoImpl.getAllWithSchool(lang, pager, order, schoolId);
        map.addAttribute("teachers", teachers);
        return "teachers";
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
