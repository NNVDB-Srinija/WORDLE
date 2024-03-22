import java.util.Arrays;
import java.util.*;
import java.io.*;
import java.lang.*;

public class WordleGame 
{
    public int search(String word1,char s)
    {
        int c=0;
        for(int i=0;i<5;i++)
        {
            if(word1.charAt(i)==s)
               c++;
        }
        return c;
    }
   
   public static String getRandom(String words[])
   {
      return words[(int)(Math.random()*words.length)];
   }

    public static void main(String[] args) {
        WordleGame obj=new WordleGame();
        int i=0;
        int count=0;
        char arr[]= new char[5]; 
        // original words
        final String words[]={"pause","legal","plate","error","trade","start","audio","ready","arise","paint","excel","power","point","early","count",
                        "floor","enemy","issue","joint","rural","urban","brick","tired","punch","valid","stone","frame","swing","first","beach"};
                             
        String word1=getRandom(words);
	System.out.println();
        System.out.println("\u001B[31m" + "Red colour means the letter is not present in the word" + "\u001B[0m");
	System.out.println("\u001B[34m" + "Blue colour means the letter is present in the word but at different position" + "\u001B[0m");
	System.out.println( "\u001B[32m" + "Green colour means the letter is present in the word at the correct position" + "\u001B[0m");
	System.out.println();
        System.out.println("You have 5 chances to guess the word"); 
        Scanner sc=new Scanner(System.in);
        for(int j=0;j<5;j++)
        {
            System.out.println("Enter a five letter word as your guess");
            String word2=sc.next();
            word2=word2.toLowerCase();
            int len=word2.length();
            if(len!=5){
                System.out.println("Error enter only 5 letter word");
                
            }
            else
            {
                for(i=0;i<5;i++)
                {
                    arr[i]=word2.charAt(i);
                }
            }
            for(i=0;i<5;i++)
             {
               char s=arr[i];
               int c= obj.search(word1,s);
               if(word1.charAt(i)==s)
               {
                   System.out.print( "\u001B[32m" + arr[i] + "\u001B[0m");
               }
               else
               {
                    if(c!=0)
                    {
                        System.out.print( "\u001B[34m" + arr[i] + "\u001B[0m");
                    }
                    else
                    {
                        System.out.print( "\u001B[31m" + arr[i] + "\u001B[0m");
                    }
                    
               }
               
            }
         System.out.println();
         if(word1.equalsIgnoreCase(word2))
            {
                   System.out.println("Congratulations   You have guessed correct");
                   count++;
                   break;
            }
	System.out.println();
        }
        if(count==0)
        {
            System.out.println("Sorry! Your guesses are over");
            System.out.println("The correct word is "+word1);
        }
    }
}