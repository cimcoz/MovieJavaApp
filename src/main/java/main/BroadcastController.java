package main;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;

import db.Broadcast;
import db.Movie;
import db.ScreenRoom;

@Controller
@RequestMapping(value = { "/broadcast" })
public class BroadcastController {

	@Autowired
	MovieRepo movieRepo;

	@Autowired
	BroadcastRepo broadcastRepo;

	@Autowired
	ScreenRoomRepo screenRoomRepo;

	@GetMapping("add")
	public String addBroadcast(Model m) {
		ArrayList<String> movieNames = new ArrayList<String>();
		ArrayList<String> screenRooms = new ArrayList<String>();
		movieRepo.findAll().forEach(Movie -> movieNames.add(Movie.getName()));
		screenRoomRepo.findAll().forEach(ScreenRoom -> screenRooms.add(ScreenRoom.getName()));
		m.addAttribute("movie", movieNames);
		m.addAttribute("screenRooms", screenRooms);
		return "addBroadcast";
	}

	@PostMapping("add")
	public String addBroadcastForMovie(Model model, @ModelAttribute Broadcast broadcast, @RequestParam String name,
			@RequestParam String screenRoomName) {
		try {
			ScreenRoom sr = screenRoomRepo.getScreenRoomByName(screenRoomName);
			Movie m = movieRepo.getMovieByName(name);
			broadcast.setScreenRoom(sr);
			broadcast.setMovie(m);
			broadcast.setRemainingSeats(sr.getSeats());
			broadcastRepo.save(broadcast);
			model.addAttribute("movieName", name);
			model.addAttribute(broadcast);
			return "resultAddBroadcast";
		} catch (Exception e) {
			e.printStackTrace();
			return "resultExceptionAddBroadcast";
		}
	}
}
