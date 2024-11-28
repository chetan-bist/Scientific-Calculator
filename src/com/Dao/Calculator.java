
package com.Dao;

import com.Interface.*;

public class Calculator implements ArithmeticOperations, GeometricOperations, ExponentialOperation, PrimePermCombOperations {

    @Override
    public double add(double... numbers) {
        double sum = 0;
        for (double number : numbers) {
            sum += number;
        }
        return sum;
    }

    @Override
    public double subtract(double... numbers) {
        double result = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            result -= numbers[i];
        }
        return result;
    }

    @Override
    public double multiply(double... numbers) {
        double result = 1;
        for (double number : numbers) {
            result *= number;
        }
        return result;
    }

    @Override
    public double divide(double... numbers) {
        System.out.println("chetan"+numbers);
        double result = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            result /= numbers[i];
        }
        return result;
    }

    @Override
    public double modulus(double a, double b) {
        return (a % b);
    }

    @Override
    public double absolute(double a) {
        return Math.abs(a);
    }

    @Override
    public double sine(double angle, boolean inDegrees) {
        System.out.println("sin");
        System.out.println(angle);
        return inDegrees ? Math.sin(angle) : Math.sin(angle);
    }

    @Override
    public double cosine(double angle, boolean inDegrees) {
        return inDegrees ? Math.cos(angle) : Math.cos(angle);
    }

    @Override
    public double tangent(double angle, boolean inDegrees) {
        return inDegrees ? Math.tan(angle) : Math.tan(angle);
    }

    @Override
    public double sinh(double angle) {
        return Math.sinh(angle);
    }

    @Override
    public double cosh(double angle) {
        return Math.cosh(angle);
    }

    @Override
    public double tanh(double angle) {
        return Math.tanh(angle);
    }

    @Override
    public double square(double a) {
        return Math.pow(a, 2);
    }

    @Override
    public double squareRoot(double a) {
        return Math.sqrt(a);
    }

    @Override
    public double cube(double a) {
        return Math.pow(a, 3);
    }

    @Override
    public double power(double base, double exponent) {
        return Math.pow(base, exponent);
    }

    @Override
    public double log(double a) {
        return Math.log(a);
    }

    @Override
    public double log10(double a) {
        return Math.log10(a);
    }

    @Override
    public double exp(double a) {
        return Math.exp(a);
    }

    @Override
    public boolean isPrime(int number) {
        if (number <= 1) return false;
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) return false;
        }
        return true;
    }

    @Override
    public long permutation(int n, int r) {
        return factorial(n) / factorial(n - r);
    }

    @Override
    public long combination(int n, int r) {
        return factorial(n) / (factorial(r) * factorial(n - r));
    }

    public long factorial(int number) {
        if (number == 0) return 1;
        long fact = 1;
        for (int i = 1; i <= number; i++) {
            fact *= i;
        }
        return fact;
    }
    // Natural Logarithm (ln(x)) 
    public  double ln(double x) 
    { 
        return Math.log1p(x);
    }
}

