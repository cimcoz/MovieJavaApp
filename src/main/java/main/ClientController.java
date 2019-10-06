package main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.time.LocalDateTime;

import db.Broadcast;
import db.Client;
import db.Contact;

@Controller
@RequestMapping(value = {"/client"})
public class ClientController {
		
	@Autowired
	ClientRepo clientRepo;
	
	@Autowired
	ScreenRoomRepo screenRoomRepo;
	
	@Autowired
	BroadcastRepo broadcastRepo;
	
	@GetMapping("sell")
	public String add(Model m)
	{
		ArrayList<LocalDateTime> broadcastDates = new ArrayList<LocalDateTime>();
		broadcastRepo.findAll().forEach(Broadcast -> broadcastDates.add(Broadcast.getDate()));
		m.addAttribute("broadcastDates", broadcastDates);
		return "addClient";
	}
	
	@PostMapping("sell")
	public String addClient(Model m, @ModelAttribute Client client, @ModelAttribute Contact contact, @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm") LocalDateTime date)
	{
		Broadcast broadcast = broadcastRepo.getBroadcastByDate(date);
		
		/**
		 * verify if there are available seats for that date
		 */
		if (broadcast.getRemainingSeats() > 0) {
			m.addAttribute(broadcast);
			client.setContact(contact);
			client.setBroadcast(broadcast);
			clientRepo.save(client);
			broadcast.setRemainingSeats(broadcast.getRemainingSeats()-1);
			broadcastRepo.save(broadcast);
			return "resultAddClient";
		}
		else {
			return "resultNoMoreSeats";
		}
		
	}
}
