package com.AWhiteExercise01;

public class Main {

    public static void main(String[] args) {
	    String city = "Columbus";
        int zipCode = 43230;
        double[] highTemp = {75, 80,80, 77, 101};
        double avgTemp = ((highTemp[0]+highTemp[1]+highTemp[2]+highTemp[3]+highTemp[4])/5);

        System.out.println("City: " + city + " Zip Code: " + zipCode + " Average High Temperature " + avgTemp);
    }
}
