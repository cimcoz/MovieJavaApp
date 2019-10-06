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
import java.util.List;
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
		List<Broadcast> broadcast = broadcastRepo.getBroadcastByDate(date);
		
		/**
		 * verify if there are available seats for that date
		 */
		int maxValue = broadcast.size();
		int index;
		for (index=0; index < maxValue; index++) {
			if (broadcast.get(index).getRemainingSeats() > 0) {
				break;
			}
		}
		
		if (index == broadcast.size()) {
			return "resultNoMoreSeats"; }
		
		if (broadcast.get(index).getRemainingSeats() > 0) {
			m.addAttribute(broadcast.get(index));
			client.setContact(contact);
			client.setBroadcast(broadcast.get(index));
			clientRepo.save(client);
			broadcast.get(index).setRemainingSeats(broadcast.get(index).getRemainingSeats()-1);
			broadcastRepo.save(broadcast.get(index));
			return "resultAddClient";
		}
		return "resultNoMoreSeats";
	}
}
