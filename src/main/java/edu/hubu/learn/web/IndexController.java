package edu.hubu.learn.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.PathVariable;

import edu.hubu.learn.entity.User;
import edu.hubu.learn.service.UserService;
import edu.hubu.learn.entity.Wtt;
import edu.hubu.learn.service.WttService;

@Controller
@RequestMapping("/")
public class IndexController {

    @Autowired
    private UserService userService;

    @Autowired
    private WttService wttService;

    @RequestMapping("/")
    public ModelAndView index() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("index");
        return mav;
    }

    @RequestMapping("/user")
    public ModelAndView user() {
        ModelAndView mav = new ModelAndView();
        User user = userService.getUser(1l);
        mav.addObject("user", user);
        mav.setViewName("user");
        return mav;
    }

    @RequestMapping("/wtt")
    public ModelAndView getwtt() {
        ModelAndView mav = new ModelAndView();
        Wtt wtt = wttService.getWtt(1L);
        mav.addObject("wtt", wtt);
        mav.setViewName("wtt");
        return mav;
    }
    @RequestMapping("/wtt/{id}")
    public ModelAndView getWtt(@PathVariable Long id) {
        ModelAndView mav = new ModelAndView();
        Wtt wtt = wttService.getWtt(id);
        mav.addObject("wtt", wtt);
        mav.setViewName("wtt");
        return mav;
    }
}