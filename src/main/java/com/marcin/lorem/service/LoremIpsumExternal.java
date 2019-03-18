package com.marcin.lorem.service;

import com.thedeanda.lorem.LoremIpsum;

public class LoremIpsumExternal implements Lorem {

    private LoremIpsum loremIpsum;
    private com.marcin.lorem.service.LoremIpsum loremIpsumMarcin;

    public LoremIpsumExternal() {}

    public LoremIpsumExternal(LoremIpsum loremIpsum, com.marcin.lorem.service.LoremIpsum loremIpsumMarcin) {
        this.loremIpsum = loremIpsum;
        this.loremIpsumMarcin = loremIpsumMarcin;
    }

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
}

