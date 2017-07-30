package fileProcessorDecorator.fileOperations;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by abhineetsharma on 7/24/17.
 */
public class SentenceDecorator extends FileProcessorAbstractBase {
    FileProcessorAbstractBase fileProcessor;

    public SentenceDecorator(FileProcessorAbstractBase fileProcessorI){
        fileProcessor = fileProcessorI;
    }


    @Override
    public void process(InputDetails inputDetails1) {
        List<String> stringList = inputDetails1.getStoredText();
        List<String> sli = new ArrayList<>();
        for(String st  : stringList){
            String [] starr = st.split("[\\.]");
            for(String s : starr){
                sli.add(s);
            }
        }
        System.out.println("\n\nSentence\n\n");
        for(String s : sli)
            System.out.println(s+"\n");
         inputDetails1.setStoredText(sli);
        fileProcessor.process(inputDetails1);


    }
}
