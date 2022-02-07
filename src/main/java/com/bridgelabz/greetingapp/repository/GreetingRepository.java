package com.bridgelabz.greetingapp.repository;
import com.bridgelabz.greetingapp.entity.Greeting;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 * @purpose -> UC4: Ability for the Greeting App to save the Greeting Message in the Repository
 */

public interface GreetingRepository extends JpaRepository<Greeting,Long> {
}