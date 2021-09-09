package com.litsynp.demo.domain.user.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;
import javax.validation.Valid;
import com.litsynp.demo.domain.post.domain.Post;
import com.litsynp.demo.domain.post.repository.PostRepository;
import com.litsynp.demo.domain.user.domain.User;
import com.litsynp.demo.domain.user.exception.UserNotFoundException;
import com.litsynp.demo.domain.user.repository.UserRepository;
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
public class UserController {

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private PostRepository postRepository;

  @GetMapping("/jpa/users")
  public List<User> retrieveAllUsers() {
    return userRepository.findAll();
  }

  @GetMapping("/jpa/users/{id}")
  public EntityModel<User> retrieveUser(@PathVariable int id) {
    Optional<User> userOptional = userRepository.findById(id);

    if (!userOptional.isPresent()) {
      throw new UserNotFoundException("id-" + id);
    }

    // "all-users", SERVER_PATH + "/jpa/users"
    EntityModel<User> resource = EntityModel.of(userOptional.get());
    WebMvcLinkBuilder linkTo = linkTo(methodOn(this.getClass()).retrieveAllUsers());

    // HATEOAS
    resource.add(linkTo.withRel("all-users"));

    return resource;
  }

  @PostMapping("/jpa/users")
  public ResponseEntity<Object> createUser(@Valid @RequestBody User user) {
    User savedUser = userRepository.save(user);

    URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
        .buildAndExpand(savedUser.getId()).toUri();

    return ResponseEntity.created(location).build();
  }

  @DeleteMapping("/jpa/users/{id}")
  public void deleteUser(@PathVariable int id) {
    userRepository.deleteById(id);
  }

  @GetMapping("/jpa/users/{id}/posts")
  public List<Post> retrieveAllPostsFromUser(@PathVariable int id) {
    Optional<User> userOptional = userRepository.findById(id);

    if (!userOptional.isPresent()) {
      throw new UserNotFoundException("id-" + id);
    }

    return userOptional.get().getPosts();
  }

  @PostMapping("/jpa/users/{id}/posts")
  public ResponseEntity<Object> createPostForUser(@PathVariable int id, @RequestBody Post post) {
    Optional<User> userOptional = userRepository.findById(id);

    if (!userOptional.isPresent()) {
      throw new UserNotFoundException("id-" + id);
    }

    User user = userOptional.get();

    post.setUser(user);
    postRepository.save(post);
    Post savedPost = postRepository.save(post);

    URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
        .buildAndExpand(savedPost.getId()).toUri();

    return ResponseEntity.created(location).build();
  }

}
