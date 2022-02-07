package com.bridgelabz.greetingapp.controller;

import com.bridgelabz.greetingapp.entity.User;
import com.bridgelabz.greetingapp.service.GreetingService;
import com.bridgelabz.greetingapp.entity.Greeting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author -> Nikita Amar<amarnikita09@gmail.com>
 * openjdk version "11.0.12" 2021-07-20
 * OpenJDK Runtime Environment 18.9 (build 11.0.12+7)
 * OpenJDK 64-Bit Server VM 18.9 (build 11.0.12+7, mixed mode)
 */
@RestController
@RequestMapping("/home")
public class GreetingController {
    @Autowired
    GreetingService greetingInterface;

    /**
     * @purpose -> UC1 : Using GreetingController return JSON for different HTTP Methods.
     *          -> UC2 : GreetingController to use Services Layer to get Simple Greeting message ” Hello World ”
     * @param fistName
     * @param lastName
     * @return -> It returns the JSON format greeting Message
     */
    @GetMapping(value = {"","/","/greeting"})
    public Greeting greeting(@RequestParam(value = "fistName",defaultValue = "Hello") String fistName, @RequestParam(value = "lastName",defaultValue = "World") String lastName){
        User user = new User();
        user.setFirstName(fistName);
        user.setLastName(lastName);
        Greeting greetingForm = greetingInterface.addGreetingForm(user);
        System.out.println(greetingForm);
        return greetingForm;
    }

    /**
     * @purpose -> UC5 : Ability for the Greeting App to find a Greeting Message by Id in the Repository
     * @param id
     * @return -> It returns the Greeting Message form the H2 DataBase
     */
    @GetMapping("/GreetingById/{id}")
    public Greeting findGreetingById(@PathVariable Long id) { return greetingInterface.getGreetingById(id); }

    /**
     *
     * @param id
     * @param firstName
     * @param lastName
     * @return
     */
    @PutMapping("/editGreeting/{id}/{firstName}/{lastName}")
    public Greeting editGreetingName(@PathVariable Long id, @PathVariable String firstName, @PathVariable String lastName){ return greetingInterface.editGreeting(id,firstName,lastName); }

    @DeleteMapping("/deleteGreetingById/{id}")
    public String deleteGreetingById(@PathVariable Long id) {return greetingInterface.deleteGreetingById(id);}
}