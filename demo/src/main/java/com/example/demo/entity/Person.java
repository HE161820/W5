/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.entity;

/**
 *
 * @author BUI QUOC BAO
 */
import javax.persistence.Column;

@Entity
@Table(name = "PERSON")
@Data

public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    private String name;
    
    private String age;
    
    @Column(naem="home_address")
    private String homeAddress;
}
