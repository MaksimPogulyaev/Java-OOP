package Prac1;

import java.lang.*;
public class TestBall {
    public static void main(String[] args) {
        Ball b1 = new Ball("Yellow", 2.0);
        Ball b2 = new Ball("Black", 3.0);
        Ball b3 = new Ball("Red");
        b3.setRadius(1);
        System.out.println(b1);
        b1.intoHumanAge();
        b2.intoHumanAge();
        b3.intoHumanAge();
    }
}
