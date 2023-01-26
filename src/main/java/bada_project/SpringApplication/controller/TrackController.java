package bada_project.SpringApplication.controller;


import bada_project.SpringApplication.dao.TrackDAO;
import bada_project.SpringApplication.model.Track;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class TrackController {
    @Autowired
    private TrackDAO trackDAO;

    @RequestMapping(value = {"/tracks/add/save", "/tracks/update/save"}, method = RequestMethod.POST)
    public String save(@ModelAttribute("tracks") Track track) {
        trackDAO.saveOrUpdate(track);
        return "redirect:/tracks/show";
    }

    @RequestMapping("/tracks/add")
    public String addTrack(Model model) {
        Track track = new Track();
        model.addAttribute("track", track);
        return "tracks/add-tracks";
    }


    @RequestMapping("/tracks/show")
    public String viewTableTracks(Model model) {
        List<Track> tracks = trackDAO.getAll();
        model.addAttribute("tracks", tracks);
        return "tracks/show-tracks";
    }

    @RequestMapping("/tracks/delete")
    public String viewDeleteTableTracks(Model model) {
        List<Track> tracks = trackDAO.getAll();
        model.addAttribute("tracks", tracks);
        return "tracks/delete-tracks";
    }

    @RequestMapping(value = "/tracks/update/{id}")
    public ModelAndView updateTrack(@PathVariable(name = "id") int id) {
        ModelAndView mav = new ModelAndView("/tracks/update-tracks");
        Track track = trackDAO.get(id);
        mav.addObject("track", track);
        return mav;
    }

    @RequestMapping("/tracks/delete/{id}")
    public String deleteTrack(@PathVariable(name = "id") int id) {
        trackDAO.delete(id);
        return "redirect:/tracks/delete";
    }
}
