package com.OGCoders;

import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

/**
 * Created by Shevis Johnson on 2/27/17.
 */
public class NFA_to_DFA {

    public Integer[] nfaStates;
    public String[] alphabet;
    public Integer nfaStartState;
    public Integer[] nfaAcceptStates;
    public String[] nfaTransitions;

    public ArrayList<ArrayList<Integer>> dfaStates;
    public ArrayList<HashMap<String, String>> nfaTransitionsPrepd;


    public NFA_to_DFA(Integer[] _nfaStates, String[] _alphabet, Integer _nfaStartState, Integer[] _nfaAcceptStates, String[] _nfaTransitions) {
        this.nfaStates = _nfaStates;
        this.alphabet = _alphabet;
        this.nfaStartState = _nfaStartState;
        this.nfaAcceptStates = _nfaAcceptStates;
        this.nfaTransitions = _nfaTransitions;
    }

    public NFA_to_DFA(NFA input) {
        this.nfaStates = input.listOfStates;
        this.alphabet = input.listOfSymbols;
        this.nfaStartState = input.startState;
        this.nfaAcceptStates = input.setOfAcceptStates;
        this.nfaTransitions = input.transitions;
    }

    public NFA_to_DFA() {
        this.nfaStates = new Integer[] {};
        this.alphabet = new String[] {};
        this.nfaStartState = null;
        this.nfaAcceptStates = new Integer[] {};
        this.nfaTransitions = new String[] {};
    }

    public void convert() {
        dfaStates = buildPowerSet(nfaStates);
        nfaTransitionsPrepd = prepareTransitions(nfaTransitions);

    }

    private ArrayList<ArrayList<Integer>> buildPowerSet(Integer[] _nfaStates) {

        ArrayList<ArrayList<Integer>> output = new ArrayList<ArrayList<Integer>>();             // create empty return object

        for (int i = 1; i < Math.pow(2, _nfaStates.length); ++i) {             // iterate i over 1...2^(N)

            char[] binaryForm = Integer.toBinaryString(i).toCharArray();       // store binary string of i as char array

            ArrayList<Integer> subOutput = new ArrayList<Integer>();

            for (int j = 0; j < binaryForm.length; ++j) {                       // iterate through binaryForm,
                if (binaryForm[j] == '1') {                                     // use binary index as index hash map for power set
                    subOutput.add(_nfaStates[(_nfaStates.length - binaryForm.length) + j]);
                }
            }
            output.add(subOutput);                                              // add subset to final output
        }
        return output;
    }

    private ArrayList<HashMap<String, String>> prepareTransitions(String[] _transitions) {
        ArrayList<HashMap<String, String>> output = new ArrayList<HashMap<String, String>>();
        for (int i = 0; i < _transitions.length; ++i) {

        }
        return output;
    }
}
