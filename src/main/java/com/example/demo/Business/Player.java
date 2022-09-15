package com.example.demo.Business;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany( cascade = CascadeType.ALL)
    private List<Score> scores = new ArrayList<>();

    public Player() {
    }

    public Player(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Score> getScores() {
        return scores;
    }

    public void setScores(List<Score> scores) {
        this.scores = scores;
    }

    public void won(int noOfWrongattempts) {
        scores.add(new Score(noOfWrongattempts));
    }

    public void lost(int noOfWrongattempts) {
        scores.add(new Score(noOfWrongattempts));
    }
}
