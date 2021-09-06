package com.litsynp.demo.domain.mockuser.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import com.litsynp.demo.domain.mockuser.model.MockUser;
import org.springframework.stereotype.Component;

@Component
public class MockUserDaoService {

  private static List<MockUser> users = new ArrayList<>();

  private static int usersCount = 3;

  static {
    users.add(new MockUser(1, "Adam", new Date()));
    users.add(new MockUser(2, "Eve", new Date()));
    users.add(new MockUser(3, "Jack", new Date()));
  }

  public List<MockUser> findAll() {
    return users;
  }

  public MockUser save(MockUser user) {
    if (user.getId() == null) {
      user.setId(++usersCount);
    }

    users.add(user);
    return user;
  }

  public MockUser findOne(int id) {
    for (MockUser user : users) {
      if (user.getId() == id) {
        return user;
      }
    }

    return null;
  }

  public MockUser deleteById(int id) {
    Iterator<MockUser> iterator = users.iterator();

    while (iterator.hasNext()) {
      MockUser user = iterator.next();

      if (user.getId() == id) {
        iterator.remove();
        return user;
      }
    }

    return null;
  }

}
