package main;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import db.Broadcast;

public interface BroadcastRepo extends JpaRepository<Broadcast, Integer> {

	@Query("FROM Broadcast b where date = :date")
	public List<Broadcast> getBroadcastByDate(@Param("date") LocalDateTime date);
}
