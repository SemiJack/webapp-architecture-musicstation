package bada_project.SpringApplication.controller;

import bada_project.SpringApplication.dao.AdresDAO;
import bada_project.SpringApplication.model.Adres;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class AdresController {
    @Autowired
    private AdresDAO adresDAO;

    @GetMapping("/adresy")
    public String viewTableAdresy(Model model){
        List<Adres> adresy = adresDAO.getAll();
        model.addAttribute("adresy",adresy);
        return "table/adresy";
    }
}
