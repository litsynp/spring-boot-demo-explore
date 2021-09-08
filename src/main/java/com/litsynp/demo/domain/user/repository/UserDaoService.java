package com.litsynp.demo.domain.user.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import com.litsynp.demo.domain.user.domain.User;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class UserDaoService {

  @PersistenceContext
  private EntityManager entityManager;

  public long insert(User user) {
    entityManager.persist(user);
    return user.getId();
  }
}
