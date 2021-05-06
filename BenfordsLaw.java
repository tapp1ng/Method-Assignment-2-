
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

        while (!exit){
            printMenu();
            userMenuChoice = reader.nextInt();

            if (userMenuChoice == 3){ // read sales data
                // method here
            }
            else if (userMenuChoice == 4){ // check for fruad
                analyzeData();
            }
            else if (userMenuChoice == 9){ // exit system
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
     * Method prints out an array of values - INTEGER ARRAY
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
     * @param ------------------------------------------------------------
     * */
    public static void analyzeData (){

    }

    /*
     * Author: Carl Wang
     * Method displays a main menu for the user
     * */
    public static void printMenu(){
        print("-----------------------");
        print("Customer and Sales System");

        System.out.println(); // I'm going to use System.out.println(); for empty lines

        print("3. Read sales data (Report on total sales data)");
        print("4. Analze data for fraud (Check for fruad in sales data)");
        print("9. Quit");
        print("-----------------------");
    }
}
