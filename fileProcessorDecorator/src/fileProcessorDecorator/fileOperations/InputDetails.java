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
        FileProcessor fileProcessor = new FileProcessor();
        String str = fileProcessor.readText(inputPathIn);
        storedText = new ArrayList <>();
        storedText.add(str);
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
