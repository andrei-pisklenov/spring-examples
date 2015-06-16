package com.example.spring.shjconf.controller;

import com.example.spring.shjconf.model.User;
import com.example.spring.shjconf.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * A single controller
 */
@Controller
@RequestMapping(value = "/")
public class MainController {
    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView index() {
        ModelMap model = new ModelMap();

        List<User> userList = userService.getAllUsers();
        model.addAttribute("userList", userList);

        return new ModelAndView("page-index", model);
    }

    @RequestMapping("/deleteuser/{id}")
    public ModelAndView deleteUser(@PathVariable("id") Long id) {
        userService.deleteUser(id);

        return new ModelAndView("redirect:/");
    }

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView addUser(
            @RequestParam("userName") String userName,
            @RequestParam("email") String email) {

        userService.addUser(new User(userName, email));

        return new ModelAndView("redirect:/");
    }
}