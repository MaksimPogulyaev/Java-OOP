package Prac1;

import java.lang.*;
public class Book {
    private String author;
    private int stranitsa;

    public Book(String a, int s) {
        author = a;
        stranitsa = s;
    }
    public Book(String a) {
        author = a;
        stranitsa = 0;
    }
    public Book(){
        author = "Tolstoy";
        stranitsa = 0;
    }
    public void  setStranitsa(int radius){
        this.stranitsa = radius;
    }
    public void  setAuthor(String author){
        this.author = author;
    }
    public String getAuthor(String author){
        return author;
    }
    public double getStranitsa(){
        return stranitsa;
    }
    public String toString(){
        return this.author+",radius"+this.stranitsa;
    }
    public void intoHumanAge(){
        System.out.println(author+" - writer,  "+stranitsa+" - page number");
    }
}
