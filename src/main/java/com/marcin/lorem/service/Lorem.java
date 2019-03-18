package com.marcin.lorem.service;

public interface Lorem {

    String generateWords(int value);
    String generateParagraphs(int value);
    String generateHtmlWords(int value);
    String generateHtmlParagraphs(int value);
    String generateHtmlList(int value);


}
