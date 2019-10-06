package db;

import java.time.LocalDateTime;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.springframework.format.annotation.DateTimeFormat;

@Table(
	    uniqueConstraints=
	        @UniqueConstraint(columnNames={"date", "screenRoomId"})
	)
@Entity
public class Broadcast {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
	private LocalDateTime date;

	@ManyToOne(cascade = CascadeType.REMOVE)
	private Movie movie;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "screenRoomId")
	private ScreenRoom screenRoom;

	@OneToMany(cascade = CascadeType.REMOVE, mappedBy = "broadcast")
	private Collection<Client> client;

	private Integer remainingSeats = null;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "Broadcast [id=" + id + ", date=" + date + ", movie=" + movie + ", screenRoom=" + screenRoom + "]";
	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	public ScreenRoom getScreenRoom() {
		return screenRoom;
	}

	public void setScreenRoom(ScreenRoom screenRoom) {
		this.screenRoom = screenRoom;
	}

	public Collection<Client> getClient() {
		return client;
	}

	public void setClient(Collection<Client> client) {
		this.client = client;
	}

	public Integer getRemainingSeats() {
		return remainingSeats;
	}

	public void setRemainingSeats(Integer remainingSeats) {
		this.remainingSeats = remainingSeats;
	}

}
