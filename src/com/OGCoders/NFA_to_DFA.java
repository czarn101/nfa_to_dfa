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
    public ArrayList<HashMap<String, ArrayList>> dfaTransitions;
    public Integer[] dfaStartStates;


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
        dfaStartStates = epsilonClose(nfaStartState, nfaTransitionsPrepd);
        
    }

    private ArrayList<ArrayList<Integer>> buildPowerSet(Integer[] _nfaStates) {

        ArrayList<ArrayList<Integer>> output = new ArrayList<ArrayList<Integer>>();             // create empty return object

        for (int i = 1; i < Math.pow(2, _nfaStates.length); ++i) {             // iterate i over 1...2^(N)

            char[] binaryForm = Integer.toBinaryString(i).toCharArray();       // store binary string of i as char array

            ArrayList<Integer> subOutput = new ArrayList<Integer>();

            for (int j = 0; j < binaryForm.length; ++j) {                       // iterate through binaryForm,
                if (binaryForm[j] == '1') {                                     // use binary string as index map for creating power set
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
            String curr = _transitions[i];
            String[] split = curr.split("\\s");
            String state = split[0].replaceAll("[^0-9]","");
            String value = split[1];
            String destination = split[3].replaceAll("[^0-9]","");
            HashMap<String, String> temp = new HashMap<String, String>(3);
            temp.put("state", state);
            temp.put("value", value);
            temp.put("destination", destination);
            output.add(temp);
        }
        return output;
    }

    private Integer[] epsilonClose(Integer _nfaState, ArrayList<HashMap<String, String>> _nfaTransitions) {
        ArrayList<Integer> output = new ArrayList<Integer>();
        for (int i = 0; i < _nfaTransitions.size(); ++i) {
            if (_nfaTransitions.get(i).get("value") == "EPS") {
                output.add(i);
            } else if (_nfaTransitions.get(i).get("value") == _nfaState.toString()) {
                output.add(i);
            }
        }
        Integer[] stockArr = new Integer[output.size()];
        stockArr = output.toArray(stockArr);
        return stockArr;
    }

}
