package fileProcessorDecorator.fileOperations;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by abhineetsharma on 7/24/17.
 */
public class InputDetails {
    private List<String> storedText;
    private String inputPath;
    public InputDetails(){

    }
    public InputDetails(String inputPathIn){
        this.inputPath = inputPathIn;
        process(this);
    }
    public List<String> process(InputDetails inputDetails1){
        FileProcessor fileProcessor = new FileProcessor();
        String str = fileProcessor.readText(inputDetails1.getInputPath());
        storedText = new ArrayList <>();
        storedText.add(str);
        return storedText;
    }


    public String getInputPath() {
        return inputPath;
    }

    public InputDetails getParagraph(InputDetails inputDetails){
        inputDetails = new ParagraphDecorator(inputDetails);
        printStoredText();
        return inputDetails;
    }

    public List<String> getSentence(InputDetails inputDetails){

        return null;
    }

    public List<String> getWord(InputDetails inputDetails){return null;}

    public List<String> getWordFrequency(InputDetails inputDetails){return null;}

    private void printStoredText(){
        for(String str : storedText){
            System.out.println(str);
        }
    }
}
