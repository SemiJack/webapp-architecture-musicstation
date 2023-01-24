package bada_project.SpringApplication.controller;

import bada_project.SpringApplication.Options;
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

import java.util.ArrayList;
import java.util.List;

@Controller
public class BroadcastController {
    @Autowired
    private BroadcastDAO broadcastDAO;
    @Autowired
    private TrackDAO trackDAO;
    @Autowired
    private RecordingDAO recordingDAO;

    @RequestMapping(value = {"/broadcasts/add/save","/broadcasts/details/save"},method = RequestMethod.POST)
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

    @RequestMapping("/broadcasts/details/{id}/tracks")
    public String showTracksToAdd(Model model, @PathVariable(name = "id") int id) {
        List<Track> tracks = trackDAO.getAll();
        model.addAttribute("tracks", tracks);
        List<Track> addedTracks = trackDAO.getTracksAddedToBroadcast(id);
        model.addAttribute("addedTracks", addedTracks);
        return "/broadcasts/edit/tracks";
    }

    @RequestMapping("/broadcasts/details/{id}/tracks/add/{id2}")
    public String addTrackToBroadcast(@PathVariable(name = "id")int id_broadcast,@PathVariable(name = "id2")int id_recording) {
        recordingDAO.bindWithBroadcast(id_recording, id_broadcast);
        return "broadcasts/edit/tracks";
    }

    @RequestMapping("/broadcasts/details/{id}/tracks/delete/{id2}")
    public String deleteTrackFromBroadcast(@PathVariable(name = "id")int id_broadcast,@PathVariable(name = "id2")int id_recording) {
        recordingDAO.unbindWithBroadcast(id_recording, id_broadcast);
        return "broadcasts/edit/tracks";
    }


    @RequestMapping("/broadcasts/delete")
    public String viewDeleteTableBroadcasts(Model model) {
        List<Broadcast> broadcasts = broadcastDAO.getAll();
        model.addAttribute("broadcasts", broadcasts);
        return "broadcasts/delete-broadcasts";
    }

    @RequestMapping(value="/broadcasts/details/{id}")
    public ModelAndView updateBroadcast(@PathVariable(name = "id")int id) {
        ModelAndView mav = new ModelAndView("/broadcasts/details-broadcast");
        Broadcast broadcast = broadcastDAO.get(id);
        mav.addObject("broadcast",broadcast);
        List<Recording> recordings = recordingDAO.getAll();
        mav.addObject("recordings", recordings);
        List<Track> tracks = trackDAO.getAll();
        mav.addObject("tracks", tracks);
        mav.addObject("options", new Options());
        return mav;
    }

    @RequestMapping("/broadcasts/delete/{id}")
    public String deleteBroadcast(@PathVariable(name = "id")int id) {
        broadcastDAO.delete(id);
        return "redirect:/broadcasts/delete";
    }
}
