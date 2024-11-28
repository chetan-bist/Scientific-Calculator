/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scientific_calculator2;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 *
 * @author Chetabist
 */
public class che {
     public static double formatDouble(double number, int scale) {
         // Convert the double to BigDecimal 
         BigDecimal bigDecimal = BigDecimal.valueOf(number); 
// Set the scale to the specified number of decimal places
         bigDecimal = bigDecimal.setScale(scale, RoundingMode.HALF_UP); 
// Return the double value from BigDecimal 
         return bigDecimal.doubleValue(); }
     
     public static void main(String[] args) { 
         System.out.println(Math.sqrt(10));
         che a = new che();
         System.out.println(a.isPrime((int)5.0000));
//         double number1 = 11.0;
//     double number2 = 12.0; 
//// Format the numbers to 5 decimal places 
//     double formattedNumber1 = che.formatDouble(number1, 5); 
//     double formattedNumber2 = che.formatDouble(number2, 5); 
//         System.out.println(formattedNumber1);
//// Print the formatted double values with exactly 5 decimal places 
//     System.out.println(String.format("%.5f", 12.0)); 
//     System.out.println(String.format("%.5f", formattedNumber2));
     
     } 
      public boolean isPrime(int number) {
        if (number <= 1) return false;
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) return false;
        }
        return true;
    }
}
    

 
