package com.codeup.blog;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PostController {

  @GetMapping("/posts")
  @ResponseBody
  public String viewPosts() {
    return "Here is a blog post:";
  }

  @GetMapping("/posts/{id}")
  @ResponseBody
  public String viewPostByID(@PathVariable int id) {
    return "Here is post #" + id + ".";
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
