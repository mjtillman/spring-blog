package com.codeup.blog.Controllers;

import com.codeup.blog.Models.BlogPost;
import com.codeup.blog.Models.BlogPostRepository;
import com.codeup.blog.Models.Users;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.codeup.blog.Services.EmailService;

@Controller
public class BlogPostController {

  private final BlogPostRepository blogPostRepo;
  private final Users userRepo;
  private EmailService emailService;

  public BlogPostController(BlogPostRepository blogPostRepo, Users userRepo, EmailService emailService) {
    this.blogPostRepo = blogPostRepo;
    this.userRepo = userRepo;
    this.emailService = emailService;
  }

  @GetMapping("/posts")
  public String viewPosts(Model model) {
    model.addAttribute("blogPosts", blogPostRepo.findAll());

    return "posts/show";
  }

  @GetMapping("/posts/{id}")
  public String viewPostByID(@PathVariable Long id, Model model) {
    BlogPost post = blogPostRepo.findOne(id);
    model.addAttribute("blogPost", post);

    return "posts/show";
  }

  @GetMapping("/posts/{id}/edit")
  public String editPost(@PathVariable Long id, Model model) {
    BlogPost post = blogPostRepo.findOne(id);
    model.addAttribute("blogPost", post);

    return "posts/show";
  }

  @GetMapping("/posts/create")
  public String viewPostForm(Model model) {
    model.addAttribute("BlogPost", new BlogPost());
    return "posts/create";
  }

  @PostMapping("/posts/create")
  public String createPost(@ModelAttribute BlogPost newPost) {
    newPost.setOwner(userRepo.findOne(1L));
    blogPostRepo.save(newPost);
    emailService.prepareAndSend(newPost, "Post has been created", "Post has been created successfully and you can find it with the ID of " + newPost.getId());
    return "posts/show";
  }

}