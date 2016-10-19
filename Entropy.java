import java.util.*;

/**
 * Created by PAS43 (Paul Spedding)
 * 18/10/2016
 * String Entropy Calculator
 */
public class Entropy {
    private double logBaseTwo(double input){
        return (Math.log(input) / Math.log(2.0));
    }

    //This method not really needed, but I did include it for code readability for my dyslexic brain...
    private ArrayList sortList(ArrayList input){
        Collections.sort(input);
        return input;
    }

    //Finds frequency of Strings
    private HashMap<String, Integer> countDuplicateStrings(ArrayList<String> input){
        HashMap<String, Integer> duplicates = new HashMap<>();
        //Value init loop, sets all values to 0;
        for (String s : input){
            Integer valueInitVar = 0;
            duplicates.put(s, valueInitVar);
        }
        //Increases the value by 1  each time the same key is encountered;
        for (String s : input){
            Integer tempDuplicateAmount = duplicates.get(s);
            //I could use the '++' operator but I feel ' var += 1' is much nicer to read;
            tempDuplicateAmount += 1;
            duplicates.put(s, tempDuplicateAmount);
        }
        return duplicates;
    }

    //This finds the amount fo classifications we have
    private HashMap<Integer, Integer> classification(HashMap<String,Integer> in){
        HashMap<Integer, Integer> tempValueStorage = new HashMap<>();

        int classificationFrequency = 0;
        for(Map.Entry<String, Integer> eachKV: in.entrySet()){
            classificationFrequency = Collections.frequency(in.values(), eachKV.getValue());
            tempValueStorage.put(eachKV.getValue(), classificationFrequency);
        }
         return tempValueStorage;
    }


    public double entropy(ArrayList input) {
        ArrayList sortedList = sortList(input);
        HashMap<String, Integer> frequency = countDuplicateStrings(sortedList);
        HashMap<Integer, Integer> classifcations = classification(frequency);

        double result = 0.0;
        for(Map.Entry<Integer, Integer> sum: classifcations.entrySet()){
            result += ((double)-sum.getValue() / (double)frequency.size()) * logBaseTwo((double)sum.getValue() / (double)frequency.size());
        }

        return result;
    }
}
