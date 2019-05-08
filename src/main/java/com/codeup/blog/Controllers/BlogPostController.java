package com.codeup.blog.Controllers;

import com.codeup.blog.Models.BlogPost;
import com.codeup.blog.Models.BlogPostRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class BlogPostController {

  private final BlogPostRepository blogPostRepo;

  public BlogPostController(BlogPostRepository blogPostRepo) {
    this.blogPostRepo = blogPostRepo;
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

  @GetMapping("/posts/create")
  @ResponseBody
  public String viewPostForm() {
    return "You tried to go to the post page.";
  }

  @PostMapping("/posts/create")
  @ResponseBody
  public String createPost() {
    return "Congratulations, you made an Internet post.";
  }

}
