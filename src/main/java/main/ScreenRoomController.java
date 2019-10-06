package main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import db.ScreenRoom;

@Controller
@RequestMapping(value = { "/screenRoom" })
public class ScreenRoomController {

	@Autowired
	BroadcastRepo broadcastRepo;

	@Autowired
	ScreenRoomRepo screenRoomRepo;

	@GetMapping("add")
	public String addBroadcast() {
		return "addScreenRoom";
	}

	@PostMapping("add")
	public String addBroadcastForMovie(Model model, @ModelAttribute ScreenRoom screenRoom) {
		try {
			screenRoomRepo.save(screenRoom);
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("message", "Error, already in DB! Try one more time!");
			return "addScreenRoom";
		}

		return "resultAddScreenRoom";
	}
}