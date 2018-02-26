package com.ice.controller;

import com.ice.service.UserService;
import com.ice.vo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {
    @Autowired
    private UserService userService;
    @RequestMapping("/user")
    public ModelAndView userTest(long userId){
        User user = userService.findUserById(userId);
        ModelAndView mv = new ModelAndView("user");
        mv.addObject(user);
        return mv;
    }
}
