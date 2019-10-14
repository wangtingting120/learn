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

import javax.servlet.http.HttpServletRequest;

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

    @RequestMapping("/add")
    public ModelAndView addWtt() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("wtt_add");
        return mav;
    }

    @RequestMapping("/do_add")
    public ModelAndView doAddWtt(Wtt wtt) {
        wtt.setAvatar("");
        wttService.addWtt(wtt);
        ModelAndView mav = new ModelAndView("redirect:/wtt/list");
        return mav;
    }
    @RequestMapping("/modify/{id}")
    public ModelAndView modifyWtt(@PathVariable Long id) {
        ModelAndView mav = new ModelAndView();
        mav.addObject("wtt", wttService.getWtt(id));
        mav.setViewName("wtt_modify");
        return mav;
    }

    @RequestMapping("/do_modify")
    public ModelAndView doModifyWtt(Wtt wtt) {
        wtt.setAvatar("");
        wttService.modifyWtt(wtt);
        ModelAndView mav = new ModelAndView("redirect:/wtt/list");
        return mav;
    }

    @RequestMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable Long id) {
        wttService.deleteWtt(id);
        ModelAndView mav = new ModelAndView("redirect:/wtt/list");
        return mav;
    }

    @RequestMapping("/search")
    public ModelAndView searchWtt() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("wtt_search");
        return mav;
    }

    @RequestMapping("/do_search")
    public ModelAndView doSearchWtt(HttpServletRequest httpRequest) {
        ModelAndView mav = new ModelAndView();
        String keyword = httpRequest.getParameter("keyword");
        List<User> wtts = wttService.searchWtts(keyword);
        mav.addObject("wtts", wtts);
        mav.setViewName("wtts");
        return mav;
    }

 
} 