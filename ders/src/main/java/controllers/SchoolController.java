package controllers;

import controllers.sub.AbstractController;
import dao.MySessionFactory;
import dao.SchoolDaoImpl;
import entities.School;
import javax.validation.Valid;
import modelattributes.SearchAttribute;
import modelattributes.sub.AbstractAtttribute;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import view.Order;
import view.Pager;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Abdullah Gürlek <abdullah.gurlek3 at gmail.com>
 */
@Controller
@RequestMapping("/school")
public class SchoolController extends AbstractController {

    @Autowired
    SchoolDaoImpl schoolDaoImpl;

    @Override
    public String index(Pager pager, ModelMap map) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String add(ModelMap map, String lang) {
        map.addAttribute("School", new School());
        return "addSchool";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addOk(ModelMap map, String lang, @Valid @ModelAttribute("School") School school, BindingResult result) {
        if (result.hasErrors()) {
            return "addSchool";
        }
        schoolDaoImpl.insert(school);
        return "redirect:showAll";
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
        map.addAttribute("schools", schoolDaoImpl.getAll(lang, pager, order));
        return "schools";
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
