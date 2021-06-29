package com.company.datastrucutures.mytries;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class TrieMain {
    public static boolean isPatternPresent(String words, String pattern) {
        String[] allWords = words.split(" ");
        Trie t = new Trie();
        for(String word: allWords) {
            for(int i = 0 ; i < word.length(); i++)
            {
                for(int j = i + 1; j <= word.length(); j++)
                    t.add(word.substring(i, j));
            }
        }
        return t.search(pattern);
    }

    private static boolean isPalindrome(String string) {
        int left = 0;
        int right = string.length() - 1;
        while(left < right)
        {
            if(string.charAt(left) != string.charAt(right))
                return false;
            left++;
            right--;
        }
        return true;
    }

    private static String reverseWord(String str) {
        return new StringBuilder(str).reverse().toString();
    }

    private Set<String> findPalindromeHelper(String word, Set<String> reversedWords) {
        Set<String> palindromes = new HashSet<>();
        //check if you can find palindrome by concatanating word of same length

        if(reversedWords.contains(word)){
            String reverseWord = reverseWord(word);
            palindromes.add(word + reverseWord);
        }

        //different length by appending at back

        for(int i = 1; i< word.length() - 1; i++)
        {
            String takenOutStr = word.substring(word.length() - i);
            String remainingStr = word.substring(0, word.length() - i);

            if(isPalindrome(takenOutStr) && reversedWords.contains(remainingStr)){
                String palindrome = remainingStr + takenOutStr + reverseWord(remainingStr);
                palindromes.add(palindrome);
            }
        }
        //different length concat at front
        for(int i = 1; i< word.length() - 1; i++)
        {
            String takenOutStr = word.substring(0, i);
            String remainingStr = word.substring(i);

            if(isPalindrome(takenOutStr) && reversedWords.contains(remainingStr)){
                String palindrome =  reverseWord(remainingStr) + takenOutStr + remainingStr;
                palindromes.add(palindrome);
            }
        }

        return palindromes;
    }

    private Set<String>  palindromePair(Set<String> words) {
        Set<String> rerversedWords = new HashSet<>();
        for(String s: words) {
            rerversedWords.add(reverseWord(s));
        }

        Set<String> palindrome = new HashSet<>();
        for(String word: words) {
            Set<String> palindromePairs = findPalindromeHelper(word, rerversedWords);
            palindrome.addAll(palindromePairs);
        }

        return palindrome;
    }
    public static List<String> autoComplete(String words, String start) {
        Trie t = new Trie();
        String[] arr = words.split(" ");
        for(String s : arr){
            t.add(s);
        }
        return t.startsWith(start);
    }
    public static void main(String[] args) {
//        Trie t = new Trie();
//        t.add("this");
//        t.add("news");
//        System.out.println(t.search("this"));
//        System.out.println(t.search("news"));
//        System.out.println(t.search("new"));
//        t.remove("news");
//        System.out.println(t.search("news"));

//        System.out.println(isPatternPresent("abc def ghi cba", "gh"));
        System.out.println(autoComplete("do dont no not note notes den", "no"));
    }
}
