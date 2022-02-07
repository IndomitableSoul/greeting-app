package com.bridgelabz.greetingapp.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author -> Nikita Amar <amarnikita09@gmail.com>
 * openjdk version "11.0.12" 2021-07-20
 * OpenJDK Runtime Environment 18.9 (build 11.0.12+7)
 * OpenJDK 64-Bit Server VM 18.9 (build 11.0.12+7, mixed mode)
 */
@Entity
@Table(name = "Greeting")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Greeting {
    @Id
    private long id;
    private  String greetingWish;
}