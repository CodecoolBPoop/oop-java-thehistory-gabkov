package com.codecool.thehistory;

import java.util.Arrays;

public class TheHistoryArray implements TheHistory {

    /**
     * This implementation should use a String array so don't change that!
     */
    private String[] wordsArray = new String[0];


    @Override
    public void add(String text) {
        //TODO: check the TheHistory interface for more information
        wordsArray = text.split("\\s");
    }

    @Override
    public void removeWord(String wordToBeRemoved) {
        //TODO: check the TheHistory interface for more information
        String [] copy = new String[wordsArray.length-1];
        int count = 0;
        int removed = 0;
        for (String word : wordsArray) {
            if (word != null) {
                if(!word.equals(wordToBeRemoved)){
                    copy[count++] = word;
                } else {
                    removed++;
                }
            }
        }
        System.arraycopy(copy,0, wordsArray, 0, wordsArray.length-removed);
    }

    @Override
    public int size() {
        //TODO: check the TheHistory interface for more information
        return wordsArray.length;
    }

    @Override
    public void clear() {
        //TODO: check the TheHistory interface for more information
        wordsArray = new String[0];
    }

    @Override
    public void replaceOneWord(String from, String to) {
        //TODO: check the TheHistory interface for more information
        String words = String.join(" ", wordsArray);
        words = words.replace(from, to);
        wordsArray = words.split("\\s");
        }

    @Override
    public void replaceMoreWords(String[] fromWords, String[] toWords) {
        //TODO: check the TheHistory interface for more information
        String words = String.join(" ", wordsArray);
        String from = String.join(" ", fromWords);
        String to = String.join(" ", toWords);
        words = words.replace(from, to);
        wordsArray = words.split("\\s");
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (String word : wordsArray) {
            sb.append(word).append(" ");
        }
        if (sb.length() > 0) sb.deleteCharAt(sb.length() - 1); // last space char
        return sb.toString();
    }
}
