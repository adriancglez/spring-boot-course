package com.smoothiemx.web.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
@RequestMapping("/app")
public class IndexController {

    //@GetMapping({"/","/index","/home"})
    @GetMapping("")
    public String index(Model model) {
        model.addAttribute("titulo", "¡Hola Spring Framework con Model");
        return "index";
    }

    @GetMapping("/index")
    public String index(ModelMap model) {
        model.addAttribute("titulo", "¡Hola Spring Framework desde ModelMap");
        return "index";
    }

    @GetMapping("/principal")
    public String index(Map<String, Object> map) {
        map.put("titulo", "¡Hola Spring Framework desde Map");
        return "index";
    }

    @GetMapping("/home")
    public ModelAndView index(ModelAndView mv) {
        mv.addObject("titulo", "Hola Spring Framework desde ModelAndView");
        mv.setViewName("index");
        return mv;
    }
}