package com.example.teamsalary.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
@Table(name ="player")
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name="player_name")
    private String name;
    @Column(name="description")
    private String description;
    @Column(name="additional")
    private int additional;
    @Column(name="totalfee")
    private int total;
    @Column(name="tierId")
    private int tierId;

    @Column(name="pos")
    private int pos;
    @Column(name="pom")
    private int pom;
    @Column(name="winning_status")
    private int winstatus;
    @Column(name="tropy_price")
    private int tropyprice;

    public Player() {
    }

    public Player(int id, String name, String description, int additional, int total, int tierId, int pos, int pom, int winstatus, int tropyprice) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.additional = additional;
        this.total = total;
        this.tierId = tierId;
        this.pos = pos;
        this.pom = pom;
        this.winstatus = winstatus;
        this.tropyprice = tropyprice;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getAdditional() {
        return additional;
    }

    public void setAdditional(int additional) {
        this.additional = additional;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getTierId() {
        return tierId;
    }

    public void setTierId(int tierId) {
        this.tierId = tierId;
    }

    public int getPos() {
        return pos;
    }

    public void setPos(int pos) {
        this.pos = pos;
    }

    public int getPom() {
        return pom;
    }

    public void setPom(int pom) {
        this.pom = pom;
    }

    public int getWinstatus() {
        return winstatus;
    }

    public void setWinstatus(int winstatus) {
        this.winstatus = winstatus;
    }

    public int getTropyprice() {
        return tropyprice;
    }

    public void setTropyprice(int tropyprice) {
        this.tropyprice = tropyprice;
    }

    @Override
    public String toString() {
        return "Player{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", additional=" + additional +
                ", total=" + total +
                ", tierId=" + tierId +
                ", pos=" + pos +
                ", pom=" + pom +
                ", winstatus=" + winstatus +
                ", tropyprice=" + tropyprice +
                '}';
    }
}
