
/*
 * Date: 2021.5.5
 * Teacher: Mr Ho
 * Authors: Carl Wang, Vincent Nguyen
 * Description: Methods assignment part 2, featuring Benford's Law
* */

import java.util.Scanner;

class BenfordsLaw{
    public static void main (String[] args){
        Scanner reader = new Scanner(System.in);
        int userMenuChoice = 0; // User selected option in the menu
        boolean exit = false;
        int[] sales = new int[0]; // --> Need a plan to get this to my method analyzeData

        double[] digitFreq = new double[10];
        /*
        [0] - digit freq of 0
        [1] - digit freq of 1
        [2] - digit freq of 2
        [3] - digit freq of 3
        [4] - digit freq of 4
        [5] - digit freq of 5
        [6] - digit freq of 6
        [7] - digit freq of 7
        [8] - digit freq of 8
        [9] - digit freq of 9
        */
        
        boolean loadedSales = false; // --> For your load method, do you think you can have it return true once the user loads data into array?

        while (!exit){
            printMenu();

            System.out.print("Type in your choice: ");
            userMenuChoice = reader.nextInt();
            System.out.println();

            if (userMenuChoice == 3){ // Read and loads sales data
                // method here
            }
            else if (userMenuChoice == 4){ // Check for fruad and generate graph
                if (!loadedSales){
                    print("Please load sales data first!");
                }
                else{
                    analyzeData(digitFreq, sales);
                }
            }
            else if (userMenuChoice == 5){ // Export digit frequency in .csv
                // method here
            }
            else if (userMenuChoice == 9){ // Exit system
                exit = true;
                print("Exiting system...");
            }
            else{
                print("Invalid input, please try again.");
            }
        }

        print("Program terminated.");
        reader.close();
    }

    /*
     * Author: Carl Wang
     * Method saves me from typing System.out.println(); because I'm lazy
     * 
     * @param String line - A string that will be printed
     * */
    public static void print (String line){
        System.out.println(line);
    }

    /*
     * Author: Carl Wang
     * Method prints out an array of values - INTEGER ARRAY -------------------------------- May get rid of -----------------------------------
     * 
     * @param int[] arr - Integer array with data
     * */
    public static void printArr (int[] arr){
        for (int i = 0; i < arr.length; i++){
            System.out.println(i);
        }
    }

    /*
     * Author: Carl Wang
     * The "main base of operations" for analyzing the sales data
     * 
     * @param double[] digitFreq - Contains the digit frequency of sales data
     * @param int[] sales - Contains the sales data
     * */
    public static void analyzeData (double[] digitFreq, int[] sales){

    }

    /*
     * Author: Carl Wang
     * Method displays a main menu for the user
     * */
    public static void printMenu(){
        print("-----------------------");
        print("Customer and Sales System");

        System.out.println(); // I'm going to use System.out.println(); for empty lines

        print("3. Read sales data (Load sales data)");
        print("4. Analze data for fraud (Generate graph and digit frequency)");
        print("5. Export digit frequency to .csv");
        print("9. Quit");
        print("-----------------------");
    }
}
