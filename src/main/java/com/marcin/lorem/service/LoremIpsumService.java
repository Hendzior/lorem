package com.marcin.lorem.service;

import org.springframework.stereotype.Component;

@Component
public class LoremIpsumService {

    private Lorem lorem;

    public LoremIpsumService(Lorem lorem) {
        this.lorem = lorem;
    }

    public String loremIpsum(int amount, int type) {

        String lorems;

        switch (type) {
            case 1:
                lorems = lorem.generateHtmlWords(amount);
                break;
            case 2:
                lorems = lorem.generateHtmlParagraphs(amount);
                break;
            case 3:
                lorems = lorem.generateHtmlList(amount);
                break;
            default:
                lorems = lorem.generateHtmlParagraphs(amount);
                break;
        }

        return lorems;
    }

    @Override
    public String toString() {
        return "LoremIpsumService{" +
                "lorem=" + lorem +
                '}';
    }
}
