package com.codeup.blog.Controllers;

import com.codeup.blog.Models.BlogPost;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;

@Controller
public class BlogPostController {

  @GetMapping("/posts")
  public String viewPosts(Model model) {
    ArrayList<BlogPost> ufoBlog = new ArrayList<>();

    BlogPost ufoBlog1 = new BlogPost(
        "Area 51 - Fact or Fiction?",
        "Please go to my KickStarter to support my continued research into the existence of extraterrestrials",
        2);
    ufoBlog.add(ufoBlog1);

    BlogPost ufoBlog2 = new BlogPost(
        "Is Adrien Brody an alien?",
        "Read further to discover both supporting and contradictory evidence...",
        3);
    ufoBlog.add(ufoBlog2);

    model.addAttribute("blogPosts", ufoBlog);

    return "posts/show";
  }

  @GetMapping("/posts/{id}")
  public String viewPostByID(@PathVariable int id, Model model) {

    BlogPost firstPost = new BlogPost("Today I saw a UFO",
        "The truth is out there", 1);
    model.addAttribute("title", firstPost.getTitle());
    model.addAttribute("body", firstPost.getBody());
    model.addAttribute("id", firstPost.getId());

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
