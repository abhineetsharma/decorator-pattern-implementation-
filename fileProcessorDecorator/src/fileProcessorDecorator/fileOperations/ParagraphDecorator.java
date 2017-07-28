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
    public List<String> process(InputDetails inputDetails) {
        List<String> stringList = inputDetails.process(inputDetails);
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
        return sli;
    }
}
