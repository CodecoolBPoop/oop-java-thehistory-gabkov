package com.codecool.thehistory;

import java.util.*;

public class TheHistoryLinkedList implements TheHistory {
    /**
     * This implementation should use a String LinkedList so don't change that!
     */
    private List<String> wordsLinkedList = new LinkedList<>();

    @Override
    public void add(String text) {
        //TODO: check the TheHistory interface for more information
        wordsLinkedList = new LinkedList<>(Arrays.asList(text.split("\\s")));
    }

    @Override
    public void removeWord(String wordToBeRemoved) {
        //TODO: check the TheHistory interface for more information
        ListIterator<String> words = wordsLinkedList.listIterator();
        while(words.hasNext()){
            String word = words.next();
            if (word.equals(wordToBeRemoved)) words.remove();
        }
    }

    @Override
    public int size() {
        //TODO: check the TheHistory interface for more information
        return wordsLinkedList.size();
    }

    @Override
    public void clear() {
        //TODO: check the TheHistory interface for more information
        wordsLinkedList.clear();
    }

    @Override
    public void replaceOneWord(String from, String to) {
        //TODO: check the TheHistory interface for more information
        ListIterator<String> words = wordsLinkedList.listIterator();
        while(words.hasNext()){
            String word = words.next();
            if (word.equals(from)) {
                words.set(to);
            }
        }
    }

    @Override
    public void replaceMoreWords(String[] fromWords, String[] toWords) {
        //TODO: check the TheHistory interface for more information
        int fromLen = fromWords.length;
        String to = String.join(" ", toWords);
        String firstFromWord = fromWords[0];

        ListIterator<String> words = wordsLinkedList.listIterator();
        LinkedList<String> temp = new LinkedList<>();

        int i = 0;
        while (words.hasNext()) {
            String currentWord = words.next();
            if (currentWord.equals(firstFromWord) && i + fromLen <= wordsLinkedList.size()) {
                if (Arrays.asList(fromWords).equals(wordsLinkedList.subList(i, i + fromLen))) {
                    words = wordsLinkedList.subList(i+fromLen, wordsLinkedList.size()).listIterator();
                    i += fromLen-1;
                    currentWord = to;
                }
            }
            i++;
            temp.add(currentWord);
        }
        wordsLinkedList = temp;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (String word : wordsLinkedList) {
            sb.append(word).append(" ");
        }
        if (sb.length() > 0) sb.deleteCharAt(sb.length() - 1); // last space char
        return sb.toString();
    }

}
