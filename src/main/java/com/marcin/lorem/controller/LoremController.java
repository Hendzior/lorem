package com.marcin.lorem.controller;

import com.marcin.lorem.model.Lorem;
import com.marcin.lorem.model.LoremIpsum;
import com.marcin.lorem.model.LoremIpsumExternal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class LoremController {

    private Lorem lorem;

    @GetMapping("/")
    public String loremForm() {

        return "form";

    }

    @GetMapping("/result")
    public String getResult(@RequestParam int amount, @RequestParam int type, ModelMap map) {

        lorem = new LoremIpsum();
        map.addAttribute("result", lorem.loremIpsumService(amount, type));

        return "result";


    }

}


