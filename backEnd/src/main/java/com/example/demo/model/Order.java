package com.example.demo.model;

import javax.persistence.*;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "title",nullable=false)
    private String title;

    @Column(name = "price",nullable=false)
    private double price;

    @Column(name = "userid",nullable = false)
    private long userid;

    public Order(){}

    public Order(long id, String title, double price, long userid) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.userid = userid;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public long getUserid() {
        return userid;
    }

    public void setUserid(long userid) {
        this.userid = userid;
    }
}
