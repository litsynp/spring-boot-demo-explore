package com.litsynp.demo.global;

import java.util.List;
import java.util.Optional;
import com.litsynp.demo.domain.user.domain.User;
import com.litsynp.demo.domain.user.repository.UserRepository;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class UserRepositoryCommandLineRunner implements CommandLineRunner {

  private static final Logger log =
      org.slf4j.LoggerFactory.getLogger(UserRepositoryCommandLineRunner.class);

  @Autowired
  private UserRepository userRepository;

  @Override
  public void run(String... args) throws Exception {
    // Disabled to run `data.sql`
    // User user = new User("Jack", "Admin");
    // userRepository.save(user);
    // log.info("New user is created : " + user);

    // Optional<User> userWithIdOne = userRepository.findById(1L);
    // log.info("User is retrieved : " + userWithIdOne);

    // List<User> users = userRepository.findAll();
    // log.info("All users :" + users);

  }
}
