package com.marcin.lorem.controller;

import com.marcin.lorem.model.Lorem;
import com.marcin.lorem.model.LoremIpsum;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class LoremController {


    @GetMapping("/")
    public String loremForm(){


        return "form";

    }

    @GetMapping("/result")
    public String getResult(@RequestParam int amount,@RequestParam int type, ModelMap map){

        Lorem loremIpsum = new LoremIpsum();

        String lorem;
        switch (type) {
            case 1: lorem = loremIpsum.generateHtmlWords(amount);
            break;
            case 2: lorem = loremIpsum.generateHtmlParagraphs(amount);
            break;
            case 3: lorem = loremIpsum.generateHtmlList(amount);
            break;
            default: lorem = loremIpsum.generateHtmlParagraphs(amount);

        }

        map.addAttribute("result", lorem);


        return "result";


        }


    }


