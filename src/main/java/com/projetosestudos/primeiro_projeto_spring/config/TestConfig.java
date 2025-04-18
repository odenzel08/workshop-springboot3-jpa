package com.projetosestudos.primeiro_projeto_spring.config;

import com.projetosestudos.primeiro_projeto_spring.models.Order;
import com.projetosestudos.primeiro_projeto_spring.models.User;
import com.projetosestudos.primeiro_projeto_spring.repositories.OrderRepository;
import com.projetosestudos.primeiro_projeto_spring.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private OrderRepository orderRepository;

    @Override
    public void run(String... args) throws Exception {

        User user1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
        User user2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");

        Order order1 = new Order(null, Instant.parse("2025-06-20T19:53:07Z"), user1);
        Order order2 = new Order(null, Instant.parse("2025-07-21T03:42:10Z"), user2);
        Order order3 = new Order(null, Instant.parse("2025-07-22T15:21:22Z"), user1);

        userRepository.saveAll(Arrays.asList(user1, user2));
        orderRepository.saveAll(Arrays.asList(order1, order2, order3));
    }
}
