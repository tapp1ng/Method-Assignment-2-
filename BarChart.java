
/*
 * Date: 2021.5.8
 * Teacher: Mr Ho
 * Author: Cark Wang
 * Description: Creates the bar graph that will be used to display to the user using JFreeChart
* */

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel; 
import org.jfree.chart.JFreeChart; 
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset; 
import org.jfree.ui.ApplicationFrame; 

public class BarChart extends ApplicationFrame{
   /*
    * @Author: Carl Wang
    * Generates the bar chart
    *
    * @param String title - Title of GUI window
    * @param double[] digitFreq - The digit frequency of sales data in %s
    * */
   public BarChart(String title, double[] digitFreq){ // Calls stuff from another .java file
      super(title); // Calls whatever that is needed from another java file

      JFreeChart barChart = ChartFactory.createBarChart(
         "Digit Frequency in Sales Data", // Graph title
         "Digit", // x-axis
         "Frequency (%)", // y-axis
         generateDataset(digitFreq), // Generates the dataset to be used in the bar chart
         PlotOrientation.VERTICAL, // Vertical Chart
         false, // No legend
         false, // No tooltips
         false // No URLs
      );

      ChartPanel chartPanel = new ChartPanel(barChart); // Creates GUI to display
      chartPanel.setPreferredSize(new java.awt.Dimension(1280, 720)); // Launches GUI to specified dimensions
      setContentPane(chartPanel); // Sets the "space" for the chart to be displayed
   }

   /*
    * Author: Carl Wang
    * Method creates a dataset for the bar graph
    *
    * @param double[] digitFreq - The digit frequency (%)
    * @return DefaultCategoryDataset dataset - The dataset for the bar chart
    * */
   public static DefaultCategoryDataset generateDataset(double[] digitFreq){
      DefaultCategoryDataset dataset = new DefaultCategoryDataset();

      for (int i = 0; i < digitFreq.length; i++){
         dataset.addValue(digitFreq[i], "Frequency %", Integer.toString(i));
      }

      return dataset;
   }
}