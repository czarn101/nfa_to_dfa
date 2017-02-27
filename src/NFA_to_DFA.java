
import java.util.ArrayList;

/**
 * Created by Shevis Johnson on 2/27/17.
 */
public class NFA_to_DFA {

    private Integer[] nfaStates;
    private String[] alphabet;
    private Integer nfaStartState;
    private Integer[] nfaAcceptStates;
    private String[] nfaTransitions;

    private ArrayList<ArrayList<Integer>> dfaStates;


    public NFA_to_DFA(Integer[] _nfaStates, String[] _alphabet, Integer _nfaStartState, Integer[] _nfaAcceptStates, String[] _nfaTransitions;) {
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

    public void convert() {
        dfaStates = buildPowerSet(nfaStates);

    }

    private ArrayList<ArrayList<Integer>> buildPowerSet(Integer[] _nfaStates) {

        ArrayList<ArrayList<Integer>> output = new ArrayList<ArrayList<Integer>>();

        for (int i = 1; i < 2**(_nfaStates.length); ++i) {

            char[] binaryForm = Integer.toBinaryString(i).toCharArray();

            System.out.println(Integer.toBinaryString(i));

            ArrayList<Integer> subOutput = new ArrayList<Integer>();

            for (int i = 0; i < binaryString.length; ++i) {
                if (binaryForm[i] == '1') {
                    subOutput.add(_nfaStates[i]);
                }
            }
            output.add(subOutput);
        }
        return output;
    }

}
