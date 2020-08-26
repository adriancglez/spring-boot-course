package com.smoothiemx.web.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/params")
public class ParamsController {

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("titulo", "Enviar parámetros del Request HTTP GET - URL");

        return "params/index";
    }

    /*
    * /params/string?texto=Hola%20Mundo
    */
    @GetMapping("/string")
    public String param(@RequestParam(name = "texto", required = false, defaultValue = "algún valor...") String texto, Model model) {
        model.addAttribute("titulo", "Recibir parámetros del Request HTTP GET - URL");
        model.addAttribute("resultado", "El texto enviado es: " + texto);
        return "params/ver";
    }

    /*
    * /params/mix-params?saludo=¿Cómo estás Adrián?&numero=9
    */
    @GetMapping("/mix-params")
    public String param(@RequestParam String saludo, @RequestParam Integer numero, Model model) {
        model.addAttribute("titulo", "Recibir varios parámetros de distintos tipos del Request HTTP GET - URL");
        model.addAttribute("resultado", "El texto enviado es: '" + saludo + "' y el número es '" + numero + "'");
        return "params/ver";
    }

    /*
     * /params/mix-params?saludo=¿Cómo estás Adrián?&numero=9
     */
    @GetMapping("/mix-params-request")
    public String param(HttpServletRequest request, Model model) {

        String saludo = request.getParameter("saludo");
        Integer numero = null;

        try {
            numero = Integer.parseInt(request.getParameter("numero"));
        } catch (NumberFormatException e) {
            numero = 0;
        }

        model.addAttribute("titulo", "Recibir varios parámetros de distintos tipos del Request HTTP GET - URL");
        model.addAttribute("resultado", "El texto enviado es: '" + saludo + "' y el número es '" + numero + "'");
        return "params/ver";
    }
}