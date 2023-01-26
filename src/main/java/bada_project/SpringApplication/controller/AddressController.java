package bada_project.SpringApplication.controller;

import bada_project.SpringApplication.dao.AddressDAO;
import bada_project.SpringApplication.model.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class AddressController {
    @Autowired
    private AddressDAO addressDAO;

    @RequestMapping(value = {"/addresses/add/save","/addresses/update/save"},method = RequestMethod.POST)
    public String save(@ModelAttribute("address") Address address) {
        addressDAO.saveOrUpdate(address);
        return "redirect:/addresses/show";
    }

    @RequestMapping("/addresses/add")
    public String addAddress(Model model){
        Address address = new Address();
        model.addAttribute("address",address);
        return "addresses/add-addresses";
    }


    @RequestMapping("/addresses/show")
    public String viewTableAddresses(Model model) {
        List<Address> addresses = addressDAO.getAll();
        model.addAttribute("addresses", addresses);
        return "addresses/show-addresses";
    }

    @RequestMapping("/addresses/prototype")
    public String protytype(Model model) {
        List<Address> addresses = addressDAO.getAll();
        model.addAttribute("addresses", addresses);
        return "addresses/prototype";
    }

    @RequestMapping("/addresses/delete")
    public String viewDeleteTableAddresses(Model model) {
        List<Address> addresses = addressDAO.getAll();
        model.addAttribute("addresses", addresses);
        return "addresses/delete-addresses";
    }

    @RequestMapping(value="/addresses/update/{id}")
    public ModelAndView updateAddress(@PathVariable(name = "id")int id) {
        ModelAndView mav = new ModelAndView("/addresses/update-addresses");
        Address address = addressDAO.get(id);
        mav.addObject("address",address);
        return mav;
    }

    @RequestMapping("/addresses/delete/{id}")
    public String deleteAddress(@PathVariable(name = "id")int id) {
        addressDAO.delete(id);
        return "redirect:/addresses/delete";
    }
}
