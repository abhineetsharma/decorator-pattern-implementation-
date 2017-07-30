package fileProcessorDecorator.fileOperations;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by abhineetsharma on 7/24/17.
 */
public class ParagraphDecorator extends FileProcessorAbstractBase{
    FileProcessorAbstractBase fileProcessor;

    public ParagraphDecorator(FileProcessorAbstractBase inputDetails1){
        fileProcessor = inputDetails1;
    }




    @Override
    public void process(InputDetails inputDetails1) {
        List<String> stringList = inputDetails1.getStoredText();
        List<String> sli = new ArrayList <>();
        for(String st  : stringList){
            String [] starr = st.split("[\\.]\\s\\s|[\\n]");
            for(String s : starr){
               sli.add(s);
            }
        }
        inputDetails1.setStoredText(sli);
        System.out.println("\n\nParagraph\n\n");
        for(String s : sli)
            System.out.println(s+"\n");
        fileProcessor.process(inputDetails1);
    }
}
