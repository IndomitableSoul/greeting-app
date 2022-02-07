package com.bridgelabz.greetingapp.service;

import com.bridgelabz.greetingapp.entity.User;
import com.bridgelabz.greetingapp.entity.Greeting;
import com.bridgelabz.greetingapp.repository.GreetingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicLong;

/**
 * @author -> Nikita Amar <amarnikita09@gmail.com>
 * openjdk version "11.0.12" 2021-07-20
 * OpenJDK Runtime Environment 18.9 (build 11.0.12+7)
 * OpenJDK 64-Bit Server VM 18.9 (build 11.0.12+7, mixed mode)
 */
@Service
public class GreetingServiceImpl implements GreetingService {

    private static final String GREETING_WISH_MESSAGE = "Happy Birthday, %s";
    private AtomicLong atomicLong = new AtomicLong();

    @Autowired
    private GreetingRepository greetingRepository;

    /**
     * @param user
     * @return It returns the object of GreetingFrom in JSON format
     * @purpose -> UC3: Ability for the Greeting App to give Greeting message with first and last name and content
     */
    public Greeting addGreeting(User user) {
        String greetingWish = String.format(GREETING_WISH_MESSAGE, (user.toString().isEmpty()) ? "Hello World!!" : user.getFirstName() + " " + user.getLastName());
        return new Greeting(atomicLong.incrementAndGet(), greetingWish);
    }

    /**
     * @param user
     * @return It returns the object of user class and save into the repository
     * @purpose -> UC4 : Ability for the Greeting App to save the Greeting Message in the Repository
     */
    @Override
    public Greeting addGreetingForm(User user) {
        String greetingWish = String.format(GREETING_WISH_MESSAGE, (user.toString().isEmpty()) ? "Hello World!!" : user.getFirstName() + " " + user.getLastName());
        return greetingRepository.save(new Greeting(atomicLong.incrementAndGet(), greetingWish));
    }

    /**
     * @param id
     * @return It returns the message when ID is matched
     * @purpose -> UC5 : Ability for the Greeting App to find a Greeting Message by Id in the Repository
     */
    @Override
    public Greeting getGreetingById(Long id) {
        return greetingRepository.findById(id).get();
    }

    @Override
    public Greeting editGreeting(Long id, String firstName, String lastName) {
        Greeting existingGreeting = greetingRepository.findById(id).orElse(null);
        if (existingGreeting != null) {
            User user = new User();
            user.setFirstName(firstName);
            user.setLastName(lastName);
            String greetingWish = String.format(GREETING_WISH_MESSAGE, (user.toString().isEmpty()) ? "Hello World!!" : user.getFirstName() + " " + user.getLastName());
            return greetingRepository.save(new Greeting(id, greetingWish));
        }
        return null;
    }

    @Override
    public String deleteGreetingById(Long id) { greetingRepository.deleteById(id); return "Greeting data is delete -> " + id; }
}
