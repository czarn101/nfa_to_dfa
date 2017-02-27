/**
 * Created by Albert on 2/26/17.
 */

import jdk.nashorn.internal.runtime.regexp.joni.ScanEnvironment;

import java.util.Scanner;
public class main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Enter the nfa file to convert: ");

        String fileName = input.nextLine();

        FileHandler handler = new FileHandler(fileName);
        NFA nfa = handler.getContents();

        NVA_to_DFA converter = new NFA_to_DFA(nfa);

        converter.convert();
    }
}