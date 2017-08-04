package com.github.shmvanhouten.practice.fizzbuzz;

public class FizzBuzz {
    public static void main(String[] args) {
        FizzBuzz fizzBuzz = new FizzBuzz();
        fizzBuzz.printUpTo(100);
    }

    private void printUpTo(int lastNumber) {
        for (int i = 1; i <= lastNumber; i++) {
            System.out.println(getPhraseToPrint(i));
        }
    }

    private String getPhraseToPrint(int i) {
        if (i % 3 == 0 && i % 5 == 0) {
            System.out.println("fizzbuzz");
        } else if (i % 3 == 0) {
            System.out.println("fizz");
        } else if (i % 5 == 0) {
            System.out.println("buzz");
        }else{
            System.out.println(i);
        }
        return null;
    }

}
