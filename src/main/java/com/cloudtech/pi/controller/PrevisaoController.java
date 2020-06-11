package com.cloudtech.pi.controller;

import com.cloudtech.pi.domain.Previsao;
import com.cloudtech.pi.service.ClimaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/previsoes")
public class PrevisaoController {

    @Autowired
    private ClimaService service;

    @GetMapping("/pesquisar")
    public String pesquisar(){
        return "previsoes/pesquisar";
    }

    @GetMapping("/previsao")
    public String mostrar(ModelMap model){
        model.addAttribute("clima", service.buscarTodos());
        return "previsoes/prevsao";
    }

    @PostMapping("/salvar")
    public String salvar(Previsao previsao){
        service.salvar(previsao);
        return "redirect:previsoes/previsao";
    }
}
