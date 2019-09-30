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
import java.util.List;

@Controller
@RequestMapping("/wtt")
public class WttController {


    @Autowired
    private WttService wttService;

    @RequestMapping("/wtt")
    public ModelAndView getwtt() {
        ModelAndView mav = new ModelAndView();
        Wtt wtt = wttService.getWtt(1L);
        mav.addObject("wtt", wtt);
        mav.setViewName("wtt");
        return mav;
    }

 
    @RequestMapping("/{id}")
    public ModelAndView wtt(@PathVariable Long id) {
        ModelAndView mav = new ModelAndView();
        Wtt wtt = wttService.getWtt(id);
        mav.addObject("wtt", wtt);
        mav.setViewName("wtt");
        return mav;
    }
    @RequestMapping("/list")
    public ModelAndView wtts() {
        ModelAndView mav = new ModelAndView();
        List<Wtt> wtts=wttService.getWtts();
        mav.addObject("wtts", wtts);
        mav.setViewName("wtts");
        return mav;
    }
}