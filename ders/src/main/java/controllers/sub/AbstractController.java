/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers.sub;

import dao.MySessionFactory;
import javax.validation.Valid;
import modelattributes.SearchAttribute;
import modelattributes.sub.AbstractAtttribute;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
//import sessions.IpTool;
import view.Order;
import view.Pager;

/**
 *
 * @author Abdullah Gürlek <abdullah.gurlek3 at gmail.com>
 */
public abstract class AbstractController {

    @Autowired
    public MySessionFactory mySessionFactoryInstance;

    @RequestMapping({"/index", "/"})
    public abstract String index(@Valid @ModelAttribute("Pager") Pager pager, ModelMap map);

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public abstract String add(ModelMap map, @PathVariable("lang") String lang);

    // @RequestMapping(value = "/add", method = RequestMethod.POST)
    // public abstract String addOk(@Valid @ModelAttribute("AbstractAtttribute") Object abstractAtttribute, BindingResult result, @PathVariable("lang") String lang);
    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public abstract String edit(@PathVariable("id") Long id, ModelMap map, @PathVariable("lang") String lang);

    // @RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
    // public abstract String editOk(@PathVariable("id") Long id,
    //        @Valid @ModelAttribute("AbstractAtttribute") AbstractAtttribute abstractAtttribute,
    //        @PathVariable("lang") String lang);
    @RequestMapping(value = "/editAll")
    public abstract String editAll(@Valid @ModelAttribute("Pager") Pager pager,
            ModelMap map,
            @ModelAttribute("Order") Order order,
            @PathVariable("lang") String lang);

    public abstract String editSearch(@Valid @ModelAttribute("AbstractAtttribute") AbstractAtttribute abstractAtttribute,
            ModelMap map,
            @ModelAttribute("Order") Order order,
            @PathVariable("lang") String lang);

    @ResponseBody
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
    public abstract String deleteOk(@PathVariable("id") Long id, @PathVariable("lang") String lang);

    @RequestMapping("/show/{id}")
    public abstract String show(@PathVariable("id") Long id, ModelMap map, @PathVariable("lang") String lang);

    @RequestMapping("/showAll")
    public abstract String showAll(ModelMap map,
            @Valid @ModelAttribute("Pager") Pager pager,
            @Valid @ModelAttribute("Order") Order order,
            @PathVariable("lang") String lang);

    @RequestMapping("/category/{titleClean}")
    public abstract String category(ModelMap map,
            @PathVariable("titleClean") String titleClean,
            @Valid @ModelAttribute("Pager") Pager pager,
            @Valid @ModelAttribute("Order") Order order,
            @PathVariable("lang") String lang);

    @RequestMapping("/tag/{titleClean}")
    public abstract String tag(ModelMap map,
            @PathVariable("titleClean") String titleClean,
            @Valid @ModelAttribute("Pager") Pager pager,
            @Valid @ModelAttribute("Order") Order order,
            @PathVariable("lang") String lang);

    @RequestMapping("/search")
    public abstract String search(
            @Valid @ModelAttribute("AbstractAtttribute") SearchAttribute searchAttribute,
            @ModelAttribute("Pager") Pager pager,
            ModelMap map,
            @ModelAttribute("Order") Order order,
            @PathVariable("lang") String lang
    );
}
