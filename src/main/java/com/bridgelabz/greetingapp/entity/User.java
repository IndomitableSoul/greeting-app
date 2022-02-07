package com.bridgelabz.greetingapp.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author -> Nikita Amar <amarnikita09@gmail.com>
 * openjdk version "11.0.12" 2021-07-20
 * OpenJDK Runtime Environment 18.9 (build 11.0.12+7)
 * OpenJDK 64-Bit Server VM 18.9 (build 11.0.12+7, mixed mode)
 */
@Data
@NoArgsConstructor
public class User {
    private String firstName;
    private String lastName;
}