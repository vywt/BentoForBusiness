import java.io.*;
import java.util.*;
import java.lang.*;

/*
 * Bento for Business - Full Stack Engineer Intern Programming Exercise:File Reader
 * Author: Yeo Wei Teck Victor
 * Portfolio: http://www.victoryeo.com
 * Github Repo: http://www.github.com/vywt
 */

//Concept: Take in directory, recursively find all files in directory & subdirectory, add all files to arraylist, 
//sort arraylist using comparator, then display arraylist

class FirstSolution {
  
  //Initialise a global variable allFiles to contain all files in a given directory
  ArrayList<File> allFiles = new ArrayList<File> ();
  
  public static void main(String[] args) {

    Scanner sc = new Scanner (System.in);
    FirstSolution firstSolution = new FirstSolution();
    firstSolution.run(sc);

  } //end main
  
  //Method to escape static context
  public void run(Scanner sc){

    System.out.println("Please enter directory: (e.g. /Users/Victor/Desktop)");
    String pathName = sc.nextLine();  
    readContent(pathName);

  } //end run
  
  //Input: Path Name of type String
  //Output: Nil
  //Recursive method reads contents of directory into arraylist allFiles, sort allFiles, and displays contents sorted in order of file size to System.out, from smallest to largest
  public void readContent(String pathName){

    File directory = new File(pathName);

    try{
      listAllFiles(directory);
    } catch (NullPointerException e){
      System.out.println("Directory " + pathName + " does not exist!");
    }
    
    Collections.sort(allFiles, new Sortbysize());
    
    int numbering = 0;

    for (File file : allFiles){
      numbering++;
      System.out.println("\nFile " + numbering +": \n" + "Full Path: " + file.getAbsolutePath() + "\nFile Name: " + file.getName() + "\nFile Size: " + file.length() + "bytes");
    }

  } //end readContent
  
  
  //Input: A directory of file type
  //Output: Nil
  //Method adds all files in a given directory to the arraylist allFiles in global environment
  public void listAllFiles(File directory){

    for (File fileEntry : directory.listFiles()) {
        if (fileEntry.isDirectory()) {
            listAllFiles(fileEntry);
        } else {
            allFiles.add(fileEntry);
        }
    }
  }//end listAllFiles
  
} //end class Solution

//Comparator set up for comparisons of 2 files
class Sortbysize implements Comparator<File>{
  
  public int compare(File fileA, File fileB){
    
    Long sizeA = fileA.length();
    Long sizeB = fileB.length();
    
    return sizeA.compareTo(sizeB);
    
  }//end compare

}//end class Sortbysize
