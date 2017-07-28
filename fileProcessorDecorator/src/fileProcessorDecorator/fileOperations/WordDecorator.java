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
    public List<String> process(InputDetails inputDetails1) {
        List<String> stringList = inputDetails.process(inputDetails1 );
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

        return sli;
    }
}
