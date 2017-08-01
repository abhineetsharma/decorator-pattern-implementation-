package fileProcessorDecorator.fileOperations;

import fileProcessorDecorator.util.Results;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by abhineetsharma on 7/25/17.
 */
public class WordDecorator extends FileProcessorAbstractBase {
    FileProcessorAbstractBase fileProcessor;

    public WordDecorator(FileProcessorAbstractBase fileProcessor1){
        fileProcessor = fileProcessor1;
    }


    @Override
    public void process(InputDetails inputDetails1, Results results) {

        results.addTextSeparator();
        results.declareTransformation(Results.DECLARATION.START,this.getClass().getSimpleName());
        results.addTextSeparator();

        List<String> stringList = inputDetails1.getStoredText();
        List<String> sli = new ArrayList<>();
        for(String st  : stringList){
            String [] starr = st.split(" ");
            for(String s : starr){
                if(s!=null && !s.trim().isEmpty()){
                    sli.add(s);
                    results.storeNewResult(s);
                }

            }
        }



        inputDetails1.setStoredText(sli);
        results.addTextSeparator();
        results.declareTransformation(Results.DECLARATION.END,this.getClass().getSimpleName());

        fileProcessor.process(inputDetails1,results);

    }
}
