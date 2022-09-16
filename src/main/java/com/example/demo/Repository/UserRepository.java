package com.example.demo.Repository;

import com.example.demo.Business.Player;
import com.example.demo.Business.Score;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<Player,Long> {
    List<Player> findByName(String name);
/*    @Query(value="select SCORE.SCORE, PLAYER.NAME  from  PLAYER_SCORES join SCORE  on PLAYER_SCORES.SCORES_ID=SCORE.ID join PLAYER on PLAYER.ID=PLAYER_SCORES.PLAYER_ID",nativeQuery = true)
    List<Score> findByPointsWithNativeQuery();*/
}
