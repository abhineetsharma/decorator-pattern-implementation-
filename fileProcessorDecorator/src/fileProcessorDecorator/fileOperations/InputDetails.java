package fileProcessorDecorator.fileOperations;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by abhineetsharma on 7/24/17.
 */
public class InputDetails {
    private List<String> text;


    public List <String> getText() {
        return text;
    }

    public void setText(List <String> text) {
        this.text = text;
    }
    public void storeNewString(String str){
        if(null == text)
            text = new LinkedList <>();
        this.text.add(str);
    }
}
