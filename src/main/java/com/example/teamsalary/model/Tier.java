package com.example.teamsalary.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
@Table(name ="tier")
public class Tier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name="tier_name")
    private String tirename;
    @Column(name="bsalary")
    private int bsalary;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "category_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIdentityInfo(generator= ObjectIdGenerators.PropertyGenerator.class, property="id")
    @JsonIdentityReference(alwaysAsId=true)
    @JsonProperty("category_id")
    private Category category;

    public Tier() {
    }

    public Tier(int id, String tirename, int bsalary, Category category) {
        this.id = id;
        this.tirename = tirename;
        this.bsalary = bsalary;
        this.category = category;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTirename() {
        return tirename;
    }

    public void setTirename(String tirename) {
        this.tirename = tirename;
    }

    public int getBsalary() {
        return bsalary;
    }

    public void setBsalary(int bsalary) {
        this.bsalary = bsalary;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Tier{" +
                "id=" + id +
                ", tirename='" + tirename + '\'' +
                ", bsalary=" + bsalary +
                ", category=" + category +
                '}';
    }
}
