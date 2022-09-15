package com.example.demo.Repository;

import com.example.demo.Business.Player;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<Player,Long> {
    List<Player> findByName(String name);
}
