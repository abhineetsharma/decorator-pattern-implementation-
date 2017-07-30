package fileProcessorDecorator.fileOperations;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by abhineetsharma on 7/25/17.
 */
public class WordDecorator extends FileProcessorAbstractBase {
    InputDetails inputDetails;

    public WordDecorator(InputDetails inputDetails1){
        inputDetails = inputDetails1;
    }


    @Override
    public void process(InputDetails inputDetails1) {
        List<String> stringList = getStoredText();
        List<String> sli = new ArrayList<>();
        for(String st  : stringList){
            String [] starr = st.split(" ");
            for(String s : starr){
                if(s!=null || !s.equals(" ") || !s.isEmpty())
                sli.add(s);
            }
        }
        System.out.println("\n\nWord\n\n");
        for(String s : sli)
            System.out.println(s+"\n");
        setStoredText(sli);
        inputDetails1 = new WordFrequencyDecorator(inputDetails1);
        inputDetails1.process(inputDetails1);

    }
}
