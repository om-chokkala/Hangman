package com.example.demo.Business;

import javax.persistence.*;

@Entity
public class Score {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int score;

  /*  @OneToMany
    private int playerId;*/

    public Score() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public Score(int noOfWrongattempts) {
        this.score=(CountryService.MAXATTEMPTS-noOfWrongattempts)*10;
    }

}
