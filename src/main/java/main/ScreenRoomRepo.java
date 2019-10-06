package main;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import db.ScreenRoom;

public interface ScreenRoomRepo extends JpaRepository<ScreenRoom, Integer>{
	
	@Query("FROM ScreenRoom sr where name = :name")
	public ScreenRoom getScreenRoomByName(@Param("name") String name);
}
