package fileProcessorDecorator.fileOperations;
/**
 * Created by abhineetsharma on 7/28/17.
 */
public class FileProcessor {


    public String readText(String input){

        fileProcessorDecorator.util.FileProcessor fPro = new fileProcessorDecorator.util.FileProcessor(input);
        String str;
        StringBuilder sbr = new StringBuilder();
        while ((str = fPro.readLine() ) != null) {
            sbr.append(str+"\n");
        }
        if(sbr.length()>0)
            return sbr.toString();
        return null;
    }
}
