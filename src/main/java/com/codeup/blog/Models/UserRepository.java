package com.codeup.blog.Models;

import org.springframework.data.repository.CrudRepository;

interface UserRepository extends CrudRepository<User, Long> {
  User findUserById(Long id);
}