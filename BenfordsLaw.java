/*
 * Date: 2021.5.5
 * Teacher: Mr Ho
 * Authors: Carl Wang, Vincent Nguyen
 * Description: Methods assignment part 2, featuring Benford's Law
* */

import java.util.Scanner;
import org.jfree.ui.RefineryUtilities; 
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

class BenfordsLaw{
    /*
     * @Author - Carl Wang
     * Main of program
     * */
    public static void main (String[] args){
        Scanner reader = new Scanner(System.in);
        int userMenuChoice = 0; // User selected option in the menu
        boolean exit = false;
        
        ArrayList<Integer> sales;
        sales = new ArrayList<Integer>(); // Please fill this array up with the data from the csv!

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
              loadData(sales);
              loadedSales = true;
            }
            else if (userMenuChoice == 4){ // Check for fruad and generate graph
                if (!loadedSales){
                    print("Please load sales data first!");
                }
                else{
                    analyzeData(digitFreq, sales, reader);
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
     * @Author: Carl Wang
     * Method saves me from typing System.out.println(); because I'm lazy
     * 
     * @param String line - A string that will be printed
     * */
    public static void print (String line){
        System.out.println(line);
    }

    /*
     * @Author: Carl Wang
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

    /*
     * @Author: Carl Wang
     * The "main base of operations" for analyzing the sales data
     * 
     * @param int[] sales - an int array containg all the sales information
     * @param double[] digitFreq - The digit frequency
     * @param Scanner reader - Reader from main
     * */
    public static void analyzeData (double[] digitFreq, ArrayList<Integer> sales, Scanner reader){
        int userChoice = 0;

        populateFreq(digitFreq, sales);
        print("-----------------------");
        displayPercentages(digitFreq);
        print("-----------------------");

        if (29 < digitFreq[1] && digitFreq[1] < 32){ // If the number 1 occurs 29-32%, there is no fraud
            print("Potential fraud is unlikely.");
        }
        else{ // Potential fraud
            print("Warning: Potential fraud.");
        }

        print("1. Display graph and return to main menu");
        print("2. Return to main menu");
        System.out.println();
        
        System.out.print("Enter 1 or 2: ");

        while(true){
            userChoice = reader.nextInt();
            if (userChoice == 1){ // Display graph and return to main menu
                displayGraph(digitFreq);
                break;
            }
            else if (userChoice == 2){ // Return to main menu
                break;
            }
            else{ // Invalid entry
                print("Invalid entry, please try again.");
            }
        }
        System.out.println();
    }

    /*
     * @Author: Carl Wang
     * Extracts and returns the first digit of a string
     * 
     * @param int[] sales - an int array containg all the sales information
     * */
    public static int extractFirstNum (int num){
        String digit = Integer.toString(num); // Converts parameter received to string
        digit = digit.substring(0,1); // Extracts the first character from the string
        int firstDigit = Integer.parseInt(digit); // Converts the 1 character (number) string to an integer

        return firstDigit;
    }

    /*
     * @Author: Carl Wang
     * Method fills the digit freq array with data based on the sales
     * Method converts the digit freq into percents, rounded to the nearest whole number
     * 
     * @param int[] sales - an int array containg all the sales information
     * @paramd double[] digitFreq - The digit frequency
     * */
    public static void populateFreq (double[] digitFreq, ArrayList<Integer> sales){
        for (int  i = 0; i < sales.size(); i++){
            int digit = extractFirstNum(sales.get(i)); // Takes the first digit from the sales array index
            
            for (int j = 0; j < 10; j++){ // Adds 1 to the the digitFreq index, following legend
                
                // Ex. if digit == 1, add 1 to digitFreq[0], which is the index for 1
                
                if (digit == j){
                    digitFreq[j]++;
                }
            }
        }

        for (int i = 0; i < digitFreq.length; i++){ // Converts the indexes into precents
            digitFreq[i] /= sales.size();
            digitFreq[i] *= 100;
            digitFreq[i] = Math.rint(digitFreq[i]); // Rounds to nearest whole number
        }
    }

    /*
     * @Author: Carl Wang
     * Method displays the digit frequency precentages
     * 
     * @paramd double[] digitFreq - The digit frequency
     * */
    public static void displayPercentages (double[] digitFreq){
        for (int i = 0; i < digitFreq.length; i++){
            System.out.print("Frequency of " + i + ": ");
            System.out.print(digitFreq[i]);
            System.out.print(" %");
            System.out.println();
        }
    }

    /*
     * @Author: Carl Wang
     * Method displays the bar chart of digit frequency
     * 
     * @paramd double[] digitFreq - The digit frequency
     * */
    public static void displayGraph(double[] digitFreq){
        BarChart chart = new BarChart(
            "Bar Graph Generator",
            digitFreq
        );

        chart.pack(); // Establishes content-scaling
        RefineryUtilities.centerFrameOnScreen(chart); // The GUI window will be centered when initalized
        chart.setVisible(true);
    }
    /*
     * Author: Vincent Nguyen
     * Description: Method that loads the sales data into an array
     * @param sales: the array that saves all the data
     * */
    
    public static void loadData (ArrayList<Integer> salesData) throws IOException {
      int value = 0;
      int lineCounter = 0;
      String fileName = "sales.csv";
      BufferedReader reader = new BufferedReader(new FileReader(fileName));
      String lineNum = reader.readLine();
      //skipping the first line of the file
      lineNum = reader.readLine();
      int counter = 1;
      while(lineNum != null) {
        //making it save in array
        if (lineNum.contains(",")) {
          //getting only the numbers and not the postal code
          
          value = Integer.parseInt(lineNum.substring(4));
          salesData.add(new Integer(value));
        }
        lineNum = reader.readLine();
      }
      reader.close();
    }
}

      


