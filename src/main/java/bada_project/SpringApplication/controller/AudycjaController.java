package bada_project.SpringApplication.controller;

import bada_project.SpringApplication.dao.AudycjaDAO;
import bada_project.SpringApplication.model.Audycja;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


import java.util.List;

@Controller
public class AudycjaController {

    @Autowired
    private AudycjaDAO audycjaDAO;

    @GetMapping("/audycje")
    public String viewTableAudycje(Model model){
        List<Audycja> audycje = audycjaDAO.getAll();
        model.addAttribute("audycje",audycje);
        return "table/audycje";
    }
}
