package com.litsynp.demo.domain.mockuser.controller;

import java.net.URI;
import java.util.List;
import javax.validation.Valid;
import com.litsynp.demo.domain.mockuser.dao.MockUserDaoService;
import com.litsynp.demo.domain.mockuser.exception.MockUserNotFoundException;
import com.litsynp.demo.domain.mockuser.model.MockUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;;

@RestController
public class MockUserController {

  @Autowired
  private MockUserDaoService mockUserService;

  @GetMapping("/mock-users")
  public List<MockUser> retrieveAllUsers() {
    return mockUserService.findAll();
  }

  @GetMapping("/mock-users/{id}")
  public EntityModel<MockUser> retrieveUser(@PathVariable int id) {
    MockUser user = mockUserService.findOne(id);

    if (user == null) {
      throw new MockUserNotFoundException("id-" + id);
    }

    // "all-users", SERVER_PATH + "/users"
    EntityModel<MockUser> resource = EntityModel.of(user);
    WebMvcLinkBuilder linkTo = linkTo(methodOn(this.getClass()).retrieveAllUsers());

    // HATEOAS
    resource.add(linkTo.withRel("mock-all-users"));

    return resource;
  }

  @PostMapping("/mock-users")
  public ResponseEntity<Object> createUser(@Valid @RequestBody MockUser user) {
    MockUser savedUser = mockUserService.save(user);

    URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
        .buildAndExpand(savedUser.getId()).toUri();

    return ResponseEntity.created(location).build();
  }

  @DeleteMapping("/mock-users/{id}")
  public void deleteUser(@PathVariable int id) {
    MockUser user = mockUserService.deleteById(id);

    if (user == null) {
      throw new MockUserNotFoundException("id-" + id);
    }
  }

}
