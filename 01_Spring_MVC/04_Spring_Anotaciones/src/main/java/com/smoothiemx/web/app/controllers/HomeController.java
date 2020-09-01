package com.smoothiemx.web.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping({"/","/index","/home"})
    public String index(Model model) {
        /* Redirect reinicia la petición http, permitiendo que la ruta (url) se actualice */
        // return "redirect:http://www.google.com";
        // return "redirect:/app";
        /* No reinicia la petición http, por lo que la ruta (url) no se actualiza, se usa para rutas de controlador */
        return "forward:/app/index";
    }
}