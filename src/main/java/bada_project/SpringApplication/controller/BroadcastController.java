package bada_project.SpringApplication.controller;

import bada_project.SpringApplication.dao.BroadcastDAO;
import bada_project.SpringApplication.dao.GuestDAO;
import bada_project.SpringApplication.dao.RecordingDAO;
import bada_project.SpringApplication.dao.TrackDAO;
import bada_project.SpringApplication.model.Broadcast;
import bada_project.SpringApplication.model.Guest;
import bada_project.SpringApplication.model.Track;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@Controller
public class BroadcastController {
    @Autowired
    private BroadcastDAO broadcastDAO;
    @Autowired
    private TrackDAO trackDAO;
    @Autowired
    private RecordingDAO recordingDAO;
    @Autowired
    private GuestDAO guestDAO;

    @RequestMapping(value = {"/broadcasts/add/save", "/broadcasts/details/save"}, method = RequestMethod.POST)
    public String save(@ModelAttribute("broadcast") Broadcast broadcast, @ModelAttribute("date") String date) {
        broadcastDAO.saveOrUpdate(broadcast);
        return "redirect:/broadcasts/show";
    }

    @RequestMapping("/broadcasts/add")
    public String addBroadcast(Model model) {
        Broadcast broadcast = new Broadcast();
        broadcast.setNr_rozglosni(1); // XD best solution
        model.addAttribute("broadcast", broadcast);
        return "broadcasts/add-broadcast";
    }


    @RequestMapping("/broadcasts/show")
    public String viewTableBroadcasts(Model model) {
        List<Broadcast> broadcasts = broadcastDAO.getAll();
        Collections.sort(broadcasts);
        model.addAttribute("broadcasts", broadcasts);
        return "broadcasts/show-broadcasts";
    }

    @RequestMapping(value = "/broadcasts/details/{id}")
    public String detailsBroadcast(Model model, @PathVariable(name = "id") int id) {
        Broadcast broadcast = broadcastDAO.get(id);
        model.addAttribute("broadcast", broadcast);
        model.addAttribute("id_broadcast", id);
        return "broadcasts/details-broadcast";
    }

    @RequestMapping("/broadcasts/details/{id}/tracks")
    public String showTracksToAdd(Model model, @PathVariable(name = "id") int id) {
        List<Track> tracks = trackDAO.getAll();
        model.addAttribute("tracks", tracks);
        List<Track> addedTracks = trackDAO.getTracksAddedToBroadcast(id);
        model.addAttribute("addedTracks", addedTracks);
        model.addAttribute("id_broadcast", id);
        return "broadcasts/edit/tracks";
    }

    @RequestMapping("/broadcasts/details/{id}/tracks/add/{id2}")
    public String addTrackToBroadcast(@PathVariable(name = "id") int id_broadcast, @PathVariable(name = "id2") int id_recording) {
        recordingDAO.bindWithBroadcast(id_recording, id_broadcast);
        return "redirect:/broadcasts/details/" + id_broadcast + "/tracks";
    }

    @RequestMapping("/broadcasts/details/{id}/tracks/delete/{id2}")
    public String deleteTrackFromBroadcast(@PathVariable(name = "id") int id_broadcast, @PathVariable(name = "id2") int id_recording) {
        recordingDAO.unbindWithBroadcast(id_recording, id_broadcast);
        return "redirect:/broadcasts/details/" + id_broadcast + "/tracks";
    }

    @RequestMapping("/broadcasts/details/{id}/guests")
    public String showGuestsToAdd(Model model, @PathVariable(name = "id") int id) {
        List<Guest> guests = guestDAO.getAll();
        model.addAttribute("guests", guests);
        List<Guest> addedGuests = guestDAO.getGuestsAddedToBroadcast(id);
        model.addAttribute("addedGuests", addedGuests);
        model.addAttribute("id_broadcast", id);
        return "broadcasts/edit/guests";
    }

    @RequestMapping("/broadcasts/details/{id}/guests/add/{id2}")
    public String addGuestToBroadcast(@PathVariable(name = "id") int id_broadcast, @PathVariable(name = "id2") int id_guest) {
        guestDAO.bindWithBroadcast(id_guest, id_broadcast);
        return "redirect:/broadcasts/details/" + id_broadcast + "/guests";
    }

    @RequestMapping("/broadcasts/details/{id}/guests/delete/{id2}")
    public String deleteGuestFromBroadcast(@PathVariable(name = "id") int id_broadcast, @PathVariable(name = "id2") int id_guest) {
        guestDAO.unbindWithBroadcast(id_guest, id_broadcast);
        return "redirect:/broadcasts/details/" + id_broadcast + "/guests";
    }


    @RequestMapping("/broadcasts/delete")
    public String viewDeleteTableBroadcasts(Model model) {
        List<Broadcast> broadcasts = broadcastDAO.getAll();
        model.addAttribute("broadcasts", broadcasts);
        return "broadcasts/delete-broadcasts";
    }


    @RequestMapping("/broadcasts/details/{id}/delete")
    public String deleteBroadcast(@PathVariable(name = "id") int id) {
        broadcastDAO.delete(id);
        return "redirect:/broadcasts/show";
    }

    @RequestMapping("/broadcasts/delete/{id}")
    public String directDeleteBroadcast(@PathVariable(name = "id") int id) {
        broadcastDAO.delete(id);
        return "redirect:/broadcasts/delete";
    }
}
