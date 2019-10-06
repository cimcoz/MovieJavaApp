package db;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Movie {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(unique = true)
	private String name;

	private int duration;

	public Movie() {
	}

	@Enumerated(EnumType.STRING)
	private Type type;

	@ElementCollection
	private Collection<String> actors;

	@OneToMany(mappedBy = "movie", cascade = CascadeType.REMOVE)
	private Collection<Broadcast> broadcast;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public Collection<String> getActors() {
		return actors;
	}

	public void setActors(Collection<String> actors) {
		this.actors = actors;
	}

	public Collection<Broadcast> getBroadcast() {
		return broadcast;
	}

	public void setBroadcast(Collection<Broadcast> broadcast) {
		this.broadcast = broadcast;
	}

	@Override
	public String toString() {
		return "Movie [id=" + id + ", name=" + name + ", duration=" + duration + ", type=" + type + ", actors=" + actors
				+ "]";
	}

}
