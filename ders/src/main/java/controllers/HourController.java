/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import controllers.sub.AbstractController;
import dao.HourDaoImpl;
import date.Days;
import date.Hours;
import entities.Hour;
import modelattributes.SearchAttribute;
import modelattributes.sub.AbstractAtttribute;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
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
@Controller
@RequestMapping("/hour")
public class HourController extends AbstractController {

    @Autowired
    HourDaoImpl hourDaoImpl;

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
        map.addAttribute("Hour", new Hour());
        map.addAttribute("Days", Days.values());
        map.addAttribute("Hours", Hours.values());

        return "addHour";
    }

    @RequestMapping(value = "/add/{schoolId}", method = RequestMethod.POST)
    public String addWithSchoolOk(ModelMap map, String lang, @PathVariable("schoolId") Long schoolId,
            @RequestParam("hours[]") String[] hourIds) {

        hourDaoImpl.addHour(schoolId, hourIds);

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
