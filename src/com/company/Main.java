package com.company;

import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static final String blueMountainFile = "blueMountain.txt";
    public static final String namesFile = "names.txt";
    public static final String outputfile = "output.txt";
    public static void main(String[] args) throws java.io.FileNotFoundException{
	    Scanner sc = new Scanner(new File(blueMountainFile));
        ArrayList<String[]> tripNames = new ArrayList<>();
        while(sc.hasNextLine()){
            tripNames.add(getNameBlueMountain(sc));
        }
        Scanner sc2 = new Scanner(new File(namesFile));
        ArrayList<String[]> clubNames = new ArrayList<>();
        while(sc2.hasNextLine()){
            clubNames.add(getName(sc2));
        }
        PrintWriter pw = new PrintWriter(new File(outputfile));
        for (int i = 0; i < clubNames.size(); i++) {
            boolean onTrip = false;
            String[] clubFirstAndLast = clubNames.get(i);
            for (int j = 0; j < tripNames.size(); j++) {

                String[] tripFirstAndLast = tripNames.get(j);
                if(clubFirstAndLast[0].equals(tripFirstAndLast[0]) && clubFirstAndLast[1].equals(tripFirstAndLast[1])){
                    onTrip = true;
                }
            }
            pw.println(clubFirstAndLast[0] + ", " + clubFirstAndLast[1] + ", " + (onTrip ? "Y" : "N"));
        }
        pw.close();
    }
    public static String[] getNameBlueMountain(Scanner sc){
        try {
            String line = sc.nextLine();
            String[] args = line.split(",");
            String[] lastNameArgs = args[2].split(" ");
            String lastName = lastNameArgs[lastNameArgs.length - 1];
            String[] firstNameArgs = args[3].split(" ");
            String firstName = firstNameArgs[1];
            String[] firstAndLast = new String[2];
            firstAndLast[0] = firstName.toUpperCase();
            firstAndLast[1] = lastName.toUpperCase();
            return firstAndLast;
        }
        catch(Exception e) {
            return new String[] {"",""};
        }
    }
    public static String[] getName(Scanner sc){
        String line = sc.nextLine();
        String[] args = line.split("\t");
        String[] firstAndLast = new String[2];
        firstAndLast[0] = args[0].toUpperCase();
        firstAndLast[1] = args[1].toUpperCase();
        return firstAndLast;
    }
}
