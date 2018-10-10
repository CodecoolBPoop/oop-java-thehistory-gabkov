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
        for (int i = 0; i < wordsArray.length; i++) {
            if (wordsArray[i].equals(from)) wordsArray[i] = to;
            }
        }

    @Override
    public void replaceMoreWords(String[] fromWords, String[] toWords) {
        //TODO: check the TheHistory interface for more information
        String[] to = {String.join(" ", toWords)};
        String[] temp = new String[wordsArray.length];
        String firstFromWord = fromWords[0];
        int fromLen = fromWords.length;
        int toIncrementRemove = fromLen-1;
        int j = 0;
        int removed = 0;

        for (int i = 0; i < wordsArray.length; i++) {
            String current = wordsArray[i];
            if (current.equals(firstFromWord) && i+fromLen <= wordsArray.length){
                String[] toCompare = Arrays.copyOfRange(wordsArray, i, i+fromLen);
                if (Arrays.equals(fromWords, toCompare)){
                    System.arraycopy(to, 0, temp, j, 1);
                    i+=fromLen-1 ;
                    removed+= toIncrementRemove;
                } else {
                    System.arraycopy(wordsArray, i, temp, j, 1);
                }
            } else {
                System.arraycopy(wordsArray, i, temp, j, 1);
            }
            j++;
        }
        String[] finalArray = new String[temp.length-removed];
        System.arraycopy(temp, 0, finalArray, 0, temp.length-removed);
        wordsArray = finalArray;
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
