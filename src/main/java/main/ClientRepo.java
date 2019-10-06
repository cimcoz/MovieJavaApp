package main;

import org.springframework.data.jpa.repository.JpaRepository;

import db.Client;

public interface ClientRepo extends JpaRepository<Client, Integer>{

}
