package com.OGCoders;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the nfa file to convert: ");

        String fileName = input.nextLine();

        FileHandler handler = new FileHandler(fileName);
        NFA nfa = handler.getContents();

        NFA_to_DFA converter = new NFA_to_DFA(nfa);

        converter.convert();
    }
}
