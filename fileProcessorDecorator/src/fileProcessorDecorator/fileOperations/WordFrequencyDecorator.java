package fileProcessorDecorator.fileOperations;

import fileProcessorDecorator.util.Results;

import java.util.*;

/**
 * Created by abhineetsharma on 7/24/17.
 */
public class WordFrequencyDecorator extends FileProcessorAbstractBase {
    FileProcessorAbstractBase fileProcessor;

    public WordFrequencyDecorator(FileProcessorAbstractBase fileProcessor1){
        fileProcessor = fileProcessor1;
    }


    @Override
    public void process(InputDetails inputDetails1,Results results) {

        List<String> stringList = inputDetails1.getStoredText();
        Map<String,Integer> map = new TreeMap<>();

        results.addTextSeparator();
        results.declareTransformation(Results.DECLARATION.START,this.getClass().getSimpleName());
        results.addTextSeparator();


        for(String st  : stringList){
            st =removeUnwantedCharFromString(st.trim());

            if(st.length()==0)continue;

            Object obj =  map.get(st);
            if(obj == null){
                map.put(st,1);
            }else{
                int value = (int)obj;
                value++;
                map.put(st,value);
            }
        }
        Iterator <Map.Entry <String, Integer>> it = map.entrySet().iterator();
        while(it.hasNext()){
            Map.Entry<String,Integer> m = it.next();
            String msg = String.format("Word: %-15s Count: %d",m.getKey(),m.getValue());
            results.storeNewResult(msg);
            it.remove();
        }
        results.addTextSeparator();
        results.declareTransformation(Results.DECLARATION.END,this.getClass().getSimpleName());
        results.addTextSeparator();
    }
    String removeUnwantedCharFromString(String str){
        return str.replaceAll("[^a-zA-Z0-9]","");
    }
}
