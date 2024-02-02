package com.example.demo;


public class NamingConventions {                                             /* Class name should start with uppercase
                                                                                 Local variables, instance variables, and
                                                                                 class variables are also written in lowerCamelCase.
                                                                                 Variable names should not start with underscore (_)
                                                                                  or dollar sign ($) */
    private static final int MAX_VALUE = 100;                                /*Constant variables should be in Upper case,Constants
                                                                               characters was separated by underscores. */
    private static int sCounter = 0;                                        // Static variables should be in lowerCamelCase with prefix 's'
    private String instanceVariable;                                        // Instance variables should be in lowerCamelCase
    public NamingConventions(String instanceVariable)                        // Constructor should be same as the class name
    {
        this.instanceVariable = instanceVariable;
    }
    public void printMessage()                                                /*Methods should be verbs, in mixed case with the
                                                                                first letter lowercase, with the first letter of
                                                                                each internal word capitalized. */
    {
        String localVariable = "Hello";                                       /// Local variables should be in lowerCamelCase
        System.out.println(localVariable + " " + instanceVariable);
    }
    public static void main(String[] args) {
        NamingConventions example = new NamingConventions("World");   // Method calls should be in lowerCamelCase
        example.printMessage();
        System.out.println("Max value: " + MAX_VALUE);
        System.out.println("Counter: " + sCounter);

    }
}
