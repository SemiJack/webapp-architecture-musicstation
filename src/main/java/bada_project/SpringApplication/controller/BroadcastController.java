package bada_project.SpringApplication.controller;

import bada_project.SpringApplication.dao.BroadcastDAO;
import bada_project.SpringApplication.dao.RecordingDAO;
import bada_project.SpringApplication.dao.TrackDAO;
import bada_project.SpringApplication.model.Broadcast;
import bada_project.SpringApplication.model.Recording;
import bada_project.SpringApplication.model.Track;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class BroadcastController {
    @Autowired
    private BroadcastDAO broadcastDAO;
    @Autowired
    private TrackDAO trackDAO;
    @Autowired
    private RecordingDAO recordingDAO;

    @RequestMapping(value = {"/broadcasts/add/save","/broadcasts/update/save"},method = RequestMethod.POST)
    public String save(@ModelAttribute("broadcast") Broadcast broadcast) {
        broadcastDAO.saveOrUpdate(broadcast);
        return "redirect:/broadcasts/show";
    }

    @RequestMapping("/broadcasts/add")
    public String addBroadcast(Model model){
        Broadcast broadcast = new Broadcast();
        model.addAttribute("broadcast",broadcast);
        return "broadcasts/add-broadcast";
    }


    @RequestMapping("/broadcasts/show")
    public String viewTableBroadcasts(Model model) {
        List<Broadcast> broadcasts = broadcastDAO.getAll();
        model.addAttribute("broadcasts", broadcasts);
        return "broadcasts/show-broadcasts";
    }

    @RequestMapping("/broadcasts/edit/tracks")
    public String showTracksToBroadcast(Model model) {
        List<Recording> recordings = recordingDAO.getAll();
        model.addAttribute("recordings", recordings);
        List<Track> tracks = trackDAO.getAll();
        model.addAttribute("tracks", tracks);
        return "broadcasts/edit/tracks";
    }

    @RequestMapping("/broadcasts/edit/tracks/{tracks}")
    public String addTracksToBroadcast(@PathVariable(name = "tracks") String tracks, Model model) {

        //model.getAttribute("")
        //String[] substring = tracks.split("");
        //for(String i : substring){
        //
       // }
        //ddress address = addressDAO.get(id);
        //mav.addObject("address",address);
        return "broadcasts/edit/tracks";
    }


    @RequestMapping("/broadcasts/delete")
    public String viewDeleteTableBroadcasts(Model model) {
        List<Broadcast> broadcasts = broadcastDAO.getAll();
        model.addAttribute("broadcasts", broadcasts);
        return "broadcasts/delete-broadcasts";
    }

    @RequestMapping(value="/broadcasts/update/{id}")
    public ModelAndView updateBroadcast(@PathVariable(name = "id")int id) {
        ModelAndView mav = new ModelAndView("/broadcasts/update-broadcast");
        Broadcast broadcast = broadcastDAO.get(id);
        mav.addObject("broadcast",broadcast);
        return mav;
    }

    @RequestMapping("/broadcasts/delete/{id}")
    public String deleteBroadcast(@PathVariable(name = "id")int id) {
        broadcastDAO.delete(id);
        return "redirect:/broadcasts/delete";
    }
}
