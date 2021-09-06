package com.litsynp.demo.domain.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonVersioningController {

  // Different types of versioning
  // 1. URI versioning (e.g., Twitter)
  // - polluting URI space
  // - documentation is easier
  @GetMapping("v1/person")
  public PersonV1 personV1() {
    return new PersonV1("Bob Charlie");
  }

  @GetMapping("v2/person")
  public PersonV2 personV2() {
    return new PersonV2(new Name("Bob", "Charlie"));
  }

  // 2. Request parameter versioning (e.g., Amazon)
  // - polluting URI space
  // - documentation is easier
  @GetMapping(value = "/person/param", params = "version=1")
  public PersonV1 paramV1() {
    return new PersonV1("Bob Charlie");
  }

  @GetMapping(value = "/person/param", params = "verison=2")
  public PersonV2 paramV2() {
    return new PersonV2(new Name("Bob", "Charlie"));
  }

  // 3. Header versioning == MIME type versioning == Media type versioning (e.g., GitHub)
  // - misuse of HTTP headers (HTTP headers are not meant for versioning)
  // - caching becomes difficult
  // - can't be used on browser
  @GetMapping(value = "/person/header", headers = "X-API_VERSION=1")
  public PersonV1 headerV1() {
    return new PersonV1("Bob Charlie");
  }

  @GetMapping(value = "/person/header", headers = "X-API_VERSION=2")
  public PersonV2 headerV2() {
    return new PersonV2(new Name("Bob", "Charlie"));
  }

  // 4. Produces versioning == Accept header versioning (e.g., Microsoft)
  // - misuse of HTTP headers (HTTP headers are not meant for versioning)
  // - caching becomes difficult
  // - can't be used on browser
  @GetMapping(value = "/person/produces", produces = "application/vnd.company.app-v1+json")
  public PersonV1 producesV1() {
    return new PersonV1("Bob Charlie");
  }

  @GetMapping(value = "/person/produces", headers = "application/vnd.company.app-v2+json")
  public PersonV2 producesV2() {
    return new PersonV2(new Name("Bob", "Charlie"));
  }

}
