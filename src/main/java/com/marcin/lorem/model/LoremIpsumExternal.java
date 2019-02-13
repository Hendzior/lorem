package com.marcin.lorem.model;

import com.thedeanda.lorem.LoremIpsum;

public class LoremIpsumExternal implements Lorem {
    private LoremIpsum loremIpsum = new LoremIpsum();
    private com.marcin.lorem.model.LoremIpsum loremIpsumMarcin = new com.marcin.lorem.model.LoremIpsum();

    @Override
    public String generateWords(int value) {
        return loremIpsum.getWords(value);
    }

    @Override
    public String generateParagraphs(int value) {
        return loremIpsum.getParagraphs(value, value);
    }

    @Override
    public String generateHtmlWords(int value) {
        return loremIpsumMarcin.generateHtmlWords(value);
    }

    @Override
    public String generateHtmlParagraphs(int value) {
        return loremIpsum.getHtmlParagraphs(value, value);
    }

    @Override
    public String generateHtmlList(int value) {
        return loremIpsumMarcin.generateHtmlList(value);
    }

    @Override
    public String loremIpsumService(int amount, int type) {

        String lorems;

        switch (type) {
            case 1:
                lorems = generateWords(amount);
                break;
            case 2:
                lorems = generateHtmlParagraphs(amount);
                break;
            case 3:
                lorems = generateHtmlList(amount);
                break;
            default:
                lorems = generateHtmlParagraphs(amount);
                break;
        }

        return lorems;
    }
}

