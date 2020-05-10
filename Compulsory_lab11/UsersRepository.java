package com.example.demo1.repository;

import com.example.demo1.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<Player,Integer> {

}
