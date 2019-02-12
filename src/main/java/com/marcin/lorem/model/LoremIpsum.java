package com.marcin.lorem.model;

import org.thymeleaf.util.StringUtils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LoremIpsum implements Lorem {

    private List<String> strings;
    private Random random = new Random();
    private String fileName;

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public LoremIpsum() {
        this.fileName = "lorem.txt";
        this.strings = readStrings(fileName);
    }


    private List<String> readStrings(String file) {
        List<String> strings = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {

                strings.add(line);
            }

        } catch (IOException e) {
            e.printStackTrace();

        }
        return strings;
    }

    @Override
    public String generateWords(int value) {
        StringBuilder stringBuilder = new StringBuilder();


        for (int wordCount = 0; wordCount < value; wordCount++) {

            String word = strings.get(random.nextInt(strings.size()));
            if (wordCount == 0) {
                stringBuilder.append(StringUtils.capitalizeWords(word));

            } else if (wordCount == value - 1) {
                stringBuilder.append(word);
                stringBuilder.append(".");
            } else
                stringBuilder.append(word);
            stringBuilder.append(" ");
        }

        return stringBuilder.toString().trim();

    }


    @Override
    public String generateParagraphs(int value) {

        StringBuilder stringBuilder = new StringBuilder();

        while (value > 0) {
            value--;

            stringBuilder.append(generateWords(random.nextInt(20) + 40));
            stringBuilder.append("\n");
        }

        return stringBuilder.toString();
    }

    public String generateHtmlWords(int value) {

        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("<p>\n");
        stringBuilder.append(generateWords(value));
        stringBuilder.append("\n</p>");
        return stringBuilder.toString();

    }

    public String generateHtmlParagraphs(int value) {

        StringBuilder stringBuilder = new StringBuilder();

        while (value > 0) {
            value--;
            stringBuilder.append("<p>");
            stringBuilder.append(generateWords(random.nextInt(20) + 40));
            stringBuilder.append("</p>\n");

        }

        return stringBuilder.toString();
    }

    public String generateHtmlList(int value) {

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<p>\n<ul>\n");
        while (value > 0) {

            value--;
            stringBuilder.append("<li>");
            stringBuilder.append(generateWords(random.nextInt(5) + 10));
            stringBuilder.append("</li>\n");

        }
        stringBuilder.append("</p>\n</ul>");
        return stringBuilder.toString();
    }

}