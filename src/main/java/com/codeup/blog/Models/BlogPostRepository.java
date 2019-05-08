package com.codeup.blog.Models;

import org.springframework.data.repository.CrudRepository;

public interface BlogPostRepository extends CrudRepository<BlogPost, Long> {
    BlogPost findBlogPostById(Long id);
}
