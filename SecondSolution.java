import java.io.*;
import java.util.*;
import java.lang.*;

/*
 * Bento for Business - Full Stack Engineer Intern Programming Exercise: Anagram
 * Author: Yeo Wei Teck Victor
 * Portfolio: http://www.victoryeo.com
 * Github Repo: http://www.github.com/vywt
 */

 //Concept: Iterate through list of words, sort each word using Collections.sort() and add into a HashMap<String, String>
 //While iterating, check if HashMap contains an equivalent sorted string. If yes, remove that word and print both. 
 //Else, continue iterating.

//Assume: All inputs are ASCII-256 set of characters, must show ALL possible pairings e.g.(spare, parse, spear) => 6 pairings


class SecondSolution {

  public static void main(String[] args){

    SecondSolution secondSolution = new SecondSolution();
    secondSolution.run(new Scanner(System.in));

  }//end main

  //Input: (By Keyboard) a String
  //Output: Nil
  //Method will take in list of strings, and make comparisons to display ALL anagram pairs
  public void run(Scanner sc){

    String input = sc.nextLine();
    input.trim();

    String[] listWords = input.split(" ");

    if (listWords.length == 0 || input == ""){
      System.out.println("No string entered!");
      return;
    }
    
    //HashMap<nonSortedString, sortedString>
    HashMap<String, String> allWords = new HashMap<String, String>();
    int counter = 0;

    for (String word : listWords){
      
      //Char arr to hold sorted string
      char[] wordArr = word.toCharArray();
      Arrays.sort(wordArr);

      //Storing sorted word
      String sortedWord = new String(wordArr);
      
      //check if map contains the sorted word - if yes, print it - else, add to map
      if (allWords.containsValue(sortedWord)){
        
        //To ensure that ALL possible anagrams are fetched
        for (String key : allWords.keySet()){
          
          if (allWords.get(key).equals(sortedWord)){
            System.out.println("\n" + ++counter + ". Pair Found:");
            System.out.println("1: " + key + " 2: " + word + "\n");
          } 
        }
        allWords.put(word, sortedWord);

      } else {
        allWords.put(word, sortedWord);
      }

    } //end for

  } //end run

}//end SecondSolution