package fileProcessorDecorator.fileOperations;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by abhineetsharma on 7/24/17.
 */
public class InputDetails {
    List<String> storedText;
    private String inputPath;
    public InputDetails(){

    }
    public InputDetails(String inputPathIn){
        this.inputPath = inputPathIn;
    }
    public void process(InputDetails inputDetails1){

        FileProcessor fileProcessor = new FileProcessor();
        String str = fileProcessor.readText(getInputPath());
        setStoredText(new ArrayList <>());
        getStoredText().add(str);
        inputDetails1 = new ParagraphDecorator(inputDetails1);
        inputDetails1.process(inputDetails1);
    }


    public String getInputPath() {
        return inputPath;
    }



    private void printStoredText(){
        for(String str : getStoredText()){
            System.out.println(str);
        }
    }

    public List <String> getStoredText() {
        return storedText;
    }

    public void setStoredText(List <String> storedText) {
        this.storedText = storedText;
    }
}
