package com.techscore.springboot;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MenuController {
    @Autowired
    MenuRepository menuRepository;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(Model model) {
    	System.out.println("---------------------debugging---------------------------------");
        List<Menu> menuList = menuRepository.findAll();
        model.addAttribute("menuList", menuList);
        return "index";
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public String detail(@PathVariable String id, Model model) {
        Optional<Menu> optMenu = menuRepository.findById(id);
        Menu menu = optMenu.get();
        model.addAttribute("menu", menu);
        return "detail";
    }

}