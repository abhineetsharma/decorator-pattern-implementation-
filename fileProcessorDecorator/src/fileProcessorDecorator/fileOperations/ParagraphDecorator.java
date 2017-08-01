package fileProcessorDecorator.fileOperations;

import fileProcessorDecorator.util.Results;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by abhineetsharma on 7/24/17.
 */
public class ParagraphDecorator extends FileProcessorAbstractBase {
    FileProcessorAbstractBase fileProcessor;

    public ParagraphDecorator(FileProcessorAbstractBase inputDetails1) {
        fileProcessor = inputDetails1;
    }


    @Override
    public void process(InputDetails inputDetails1, Results results) {
        results.addTextSeparator();
        results.declareTransformation(Results.DECLARATION.START, this.getClass().getSimpleName());
        results.addTextSeparator();
        List <String> stringList = inputDetails1.getStoredText();
        List <String> sli = new ArrayList <>();
        for (String st : stringList) {
            String[] starr = st.split("[\\.]\\s\\s|[\\n]");
            for (String s : starr) {
                sli.add(s);
            }
        }
        inputDetails1.setStoredText(sli);

        for (String s : sli)
            results.storeNewResult(s + "\n");

        results.addTextSeparator();
        results.declareTransformation(Results.DECLARATION.END, this.getClass().getSimpleName());
        fileProcessor.process(inputDetails1, results);
    }
}
