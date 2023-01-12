package bada_project.SpringApplication.controller;

import bada_project.SpringApplication.dao.AutorDAO;
import bada_project.SpringApplication.model.Autor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class AutorController {

    @Autowired
    private AutorDAO autorDAO;

    @GetMapping("/tables/autorzy")
    public String viewTableAutorzy(Model model){
        List<Autor> autorzy = autorDAO.getAll();
        model.addAttribute("autorzy",autorzy);
        return "tables/autorzy";
    }
}
