package com.codeup.blog.Models;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Users extends CrudRepository<User, Long> {
  User findUserById(Long id);
  User findByUsername(String username);

}