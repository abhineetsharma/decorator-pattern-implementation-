package fileProcessorDecorator.fileOperations;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by abhineetsharma on 7/24/17.
 */
public class ParagraphDecorator extends FileProcessorAbstractBase{
    InputDetails inputDetails;

    public ParagraphDecorator(InputDetails inputDetails1){
        inputDetails = inputDetails1;
    }




    @Override
    public void process(InputDetails inputDetails1) {
        List<String> stringList = getStoredText();
        List<String> sli = new ArrayList <>();
        for(String st  : stringList){
            String [] starr = st.split("[\\.]\\s\\s|[\\n]");
            for(String s : starr){
               sli.add(s);
            }
        }
        System.out.println("\n\nParagraph\n\n");
        for(String s : sli)
            System.out.println(s+"\n");
        setStoredText( sli);
        inputDetails1 = new SentenceDecorator(inputDetails1);
        inputDetails1.process(inputDetails1);

    }
}
