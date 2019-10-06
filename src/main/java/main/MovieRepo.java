package main;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import db.Movie;

public interface MovieRepo extends JpaRepository<Movie, Integer> {

	// List<Movie> findByNameOrderByIdDesc(String name);
	@Modifying
	@Transactional
	@Query("DELETE FROM Movie m where name = :name")
	void deleteByName(@Param("name") String name);

	@Query("FROM Movie m where name = :name")
	public Movie getMovieByName(@Param("name") String name);

}
