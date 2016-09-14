package com.andrewwhite.week_03;
import java.util.Scanner;

public class Main {


    static double fToC(double fahrenheit){
        double celsius = 5.0/9 * (fahrenheit -  32);
        return celsius;
    }

    static void displayTemp(double temperature){
        System.out.println("The temperature is " + temperature + ".");
    }

    static double userInput(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a fahrenheit temperature.");
        String input = sc.nextLine();
        double doubleInput = Double.parseDouble(input);
        return doubleInput;
    }
    public static void main(String[] args){
            double userTemperature = userInput();

        while(userTemperature >= -460){
            double celsius = fToC(userTemperature);
            displayTemp(celsius);
            userTemperature = userInput();

        }
    }
}