package com.smoothiemx.web.app.controllers;

import com.smoothiemx.web.app.models.Usuario;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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

    @RequestMapping("/perfil")
    public String perfil(Model model) {

        Usuario usuario = new Usuario();
        usuario.setNombre("Adrián");
        usuario.setApellido("González");
        usuario.setEmail("adrian@gmail.com");

        model.addAttribute("titulo", "Perfil del Usuario ".concat(usuario.getNombre()));
        model.addAttribute("usuario", usuario);

        return "perfil";
    }

    @RequestMapping("/listar")
    public String listar(Model model) {

        List<Usuario> usuarios = Arrays.asList(
                new Usuario("Adrián", "Gonzalez", "adrian@gmail.com"),
                new Usuario("Juan", "Perez", "juan@gmail.com"),
                new Usuario("John", "Doe", "john@gmail.com"),
                new Usuario("Tornado", "Roe", "tornado@gmail.com")
        );

        model.addAttribute("titulo", "Listado de usuarios");
        model.addAttribute("usuarios",usuarios);

        return "listar";
    }
}