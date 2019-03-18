package com.marcin.lorem.controller;

import com.marcin.lorem.service.LoremIpsumService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class LoremController {

    private LoremIpsumService lorem;

    public LoremController(LoremIpsumService lorem) {
        this.lorem = lorem;
    }

    @GetMapping("/")
    public String loremForm() {
        return "form";
    }

    @GetMapping("/result")
    public String getResult(@RequestParam int amount, @RequestParam int type, ModelMap map) {
        map.addAttribute("result", lorem.loremIpsum(amount, type));
        return "result";
    }

    @ExceptionHandler(NumberFormatException.class)
    public String handleMissingParams(RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("message", "Enter number!");
        return "redirect:/";
    }
}


