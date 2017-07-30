package fileProcessorDecorator.fileOperations;

import java.util.*;

/**
 * Created by abhineetsharma on 7/24/17.
 */
public class WordFrequencyDecorator extends FileProcessorAbstractBase {
    InputDetails inputDetails;

    public WordFrequencyDecorator(InputDetails inputDetails1){
        inputDetails = inputDetails1;
    }


    @Override
    public void process(InputDetails inputDetails1) {

        List<String> stringList = getStoredText();
        Map<String,Integer> map = new TreeMap<>();
        for(String st  : stringList){
            Object obj =  map.get(st);
            if(obj == null){
                map.put(st,1);
            }else{
                int value = (int)obj;
                value++;
                map.put(st,value);
            }
        }
        System.out.println("\n\nWord Frequency\n\n");

            System.out.println(map+"\n");

    }
}
