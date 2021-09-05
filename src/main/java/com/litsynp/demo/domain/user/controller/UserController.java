package com.litsynp.demo.domain.user.controller;

import java.net.URI;
import java.util.List;
import javax.validation.Valid;
import com.litsynp.demo.domain.user.dao.UserDaoService;
import com.litsynp.demo.domain.user.exception.UserNotFoundException;
import com.litsynp.demo.domain.user.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class UserController {

  @Autowired
  private UserDaoService userService;

  @GetMapping("/users")
  public List<User> retrieveAllUsers() {
    return userService.findAll();
  }

  @GetMapping("/users/{id}")
  public User retrieveUser(@PathVariable int id) {
    User user = userService.findOne(id);

    if (user == null) {
      throw new UserNotFoundException("id-" + id);
    }

    return user;
  }

  @PostMapping("/users")
  public ResponseEntity<Object> createUser(@Valid @RequestBody User user) {
    User savedUser = userService.save(user);

    URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
        .buildAndExpand(savedUser.getId()).toUri();

    return ResponseEntity.created(location).build();
  }

  @DeleteMapping("/users/{id}")
  public void deleteUser(@PathVariable int id) {
    User user = userService.deleteById(id);

    if (user == null) {
      throw new UserNotFoundException("id-" + id);
    }
  }

}
