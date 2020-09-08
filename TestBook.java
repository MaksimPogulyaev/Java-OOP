package Prac1;

import java.lang.*;
public class TestBook {
    public static void main(String[] args) {
        Book b1 = new Book("Tolstoy", 20);
        Book b2 = new Book("Lermontov", 70);
        Book b3 = new Book("Pushkin");
        b3.setStranitsa(1);
        System.out.println(b1);
        b1.intoHumanAge();
        b2.intoHumanAge();
        b3.intoHumanAge();
    }
}
