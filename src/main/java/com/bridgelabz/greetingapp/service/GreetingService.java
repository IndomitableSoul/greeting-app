package com.bridgelabz.greetingapp.service;

import com.bridgelabz.greetingapp.entity.Greeting;
import com.bridgelabz.greetingapp.entity.User;

public interface GreetingService {
    Greeting addGreetingForm(User user);
    Greeting getGreetingById(Long id);
    Greeting editGreeting(Long id, String firstName, String lastName);
    String deleteGreetingById(Long id);
}