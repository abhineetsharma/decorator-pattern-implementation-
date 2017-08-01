package fileProcessorDecorator.fileOperations;

import fileProcessorDecorator.util.Results;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by abhineetsharma on 7/24/17.
 */
public class SentenceDecorator extends FileProcessorAbstractBase {
    FileProcessorAbstractBase fileProcessor;

    public SentenceDecorator(FileProcessorAbstractBase fileProcessorI) {
        fileProcessor = fileProcessorI;
    }


    @Override
    public void process(InputDetails inputDetails1, Results results) {

        results.addTextSeparator();
        results.declareTransformation(Results.DECLARATION.START,this.getClass().getSimpleName());
        results.addTextSeparator();

        List <String> stringList = inputDetails1.getStoredText();
        List <String> sli = new ArrayList <>();
        for (String st : stringList) {
            String[] starr = st.split("[\\.]");
            for (String s : starr) {
                sli.add(s.trim());
            }
        }

        for (String s : sli)
            results.storeNewResult(s + "\n");

        inputDetails1.setStoredText(sli);

        results.addTextSeparator();
        results.declareTransformation(Results.DECLARATION.END,this.getClass().getSimpleName());

        fileProcessor.process(inputDetails1, results);


    }
}
