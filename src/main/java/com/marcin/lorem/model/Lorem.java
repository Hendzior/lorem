package com.marcin.lorem.model;

public interface Lorem {

    String generateWords(int value);
    String generateParagraphs(int value);
    String generateHtmlWords(int value);
    String generateHtmlParagraphs(int value);
    String generateHtmlList(int value);
    String loremIpsumService(int amount, int type);

}
