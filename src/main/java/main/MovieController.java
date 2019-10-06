package main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import db.Movie;
import db.Type;

@Controller
@RequestMapping(value = { "/movie" })
public class MovieController {

	@Autowired
	MovieRepo movieRepo;

	@GetMapping("getAll")
	public String getMovies(Model m) {
		System.out.println(movieRepo.findAll());
		m.addAttribute("result", movieRepo.findAll());
		return "showMovies";
	}

	@GetMapping(value = "add")
	public String addMovie(Model m) {
		m.addAttribute("type", new ArrayList<Type>(Arrays.asList(Type.values())));
		m.addAttribute("movie", movieRepo.findAll());
		return "addMovie";
	}

	@PostMapping("add")
	public String add(@ModelAttribute Movie movie, @RequestParam Type type, @RequestParam Collection<String> actors) {
		movieRepo.save(movie);
		return "resultAddMovie";
	}

	@GetMapping(value = "delete")
	public String deleteMovie(Model m) {
		ArrayList<String> movieNames = new ArrayList<String>();
		ArrayList<Integer> movieIds = new ArrayList<Integer>();
		movieRepo.findAll().forEach(Movie -> movieNames.add(Movie.getName()));
		movieRepo.findAll().forEach(Movie -> movieIds.add(Movie.getId()));
		m.addAttribute("movie", movieNames);
		m.addAttribute("movieIds", movieIds);
		return "deleteMovie";
	}

	@RequestMapping("deleteById")
	public String deleteById(Model m, @RequestParam(required = false, defaultValue = "-1") int id) {
		try {
			m.addAttribute("movieIdentifier", id);
			movieRepo.deleteById(id);
		} catch (Exception e) {
			e.printStackTrace();
			m.addAttribute("movieIdentifier", "No entity exception!!!");
		}
		return "resultDeleteMovie";
	}

	@RequestMapping("deleteByName")
	public String deleteByName(Model m, @RequestParam(required = false, defaultValue = "") String name) {
		try {
			m.addAttribute("movieIdentifier", name);
			movieRepo.deleteByName(name);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "resultDeleteMovie";
	}

}
