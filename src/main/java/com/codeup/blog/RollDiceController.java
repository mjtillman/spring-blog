package com.codeup.blog;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class RollDiceController {

  @GetMapping("/roll-dice")
  public String viewRollDice() {
    return "roll-dice";
  }

  @GetMapping("/roll-dice/{guess}")
  public String guessRoll(@PathVariable String guess, Model model) {
    model.addAttribute("guess", guess);

    Integer rollInt = (int) Math.floor(Math.random() * 6) + 1;
    String roll = rollInt.toString();
    model.addAttribute("roll", roll);

    String message;
    if (guess.equals(roll)) {
      message = "Good guess!";
    } else {
      message = "Sorry, try again.";
    }
    model.addAttribute("message", message);

    return "roll-dice";
  }

}