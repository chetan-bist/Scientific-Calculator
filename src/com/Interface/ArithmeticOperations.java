/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Interface;

/**
 *
 * @author Chetabist
 */
public interface ArithmeticOperations {
    double add(double... numbers); 
    double subtract(double... numbers);
    double multiply(double... numbers);
    double divide(double... numbers); 
    double modulus(double a, double b); 
    double absolute(double a);
}
