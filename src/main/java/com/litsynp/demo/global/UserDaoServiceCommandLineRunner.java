package com.litsynp.demo.global;

import com.litsynp.demo.domain.user.domain.User;
import com.litsynp.demo.domain.user.repository.UserDaoService;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class UserDaoServiceCommandLineRunner implements CommandLineRunner {

  private static final Logger log =
      org.slf4j.LoggerFactory.getLogger(UserDaoServiceCommandLineRunner.class);

  @Autowired
  private UserDaoService userService;

  @Override
  public void run(String... args) throws Exception {
    User user = new User("Jack", "Admin");
    long insert = userService.insert(user);
    log.info("New user is created : " + user);
  }
}
