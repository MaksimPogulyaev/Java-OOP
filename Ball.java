package Prac1;

import java.lang.*;
public class Ball {
    private String color;
    private double radius;

    public Ball(String c, double r) {
        color = c;
        radius = r;
    }
    public Ball(String c) {
        color = c;
        radius = 0;
    }
    public Ball(){
        color = "Green";
        radius = 0;
    }
    public void  setRadius(int radius){
        this.radius = radius;
    }
    public void  setColor(String color){
        this.color = color;
    }
    public String getColor(String color){
        return color;
    }
    public double getRadius(){
        return radius;
    }
    public String toString(){
        return this.color+",radius"+this.radius;
    }
    public void intoHumanAge(){
        System.out.println(color+" - the color of the ball,  "+radius+" - the radius of the ball");
    }
}

