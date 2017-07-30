package fileProcessorDecorator.driver;

import fileProcessorDecorator.fileOperations.*;
import fileProcessorDecorator.util.FileProcessor;
import org.omg.PortableInterceptor.INACTIVE;

/**
 * Created by abhineetsharma on 7/24/17.
 */
public class Driver {

    public static void main(String[] args) {
        if (null != args && args.length > 1) {
            String input = args[0];
            if (input.equalsIgnoreCase("arg0")) {
                System.out.println(String.format("Error:No %s file passed", input));
                System.exit(1);
            }
            String output = args[1];
            if (input.equalsIgnoreCase("arg1")) {
                System.out.println(String.format("Error:No %s file passed", output));
                System.exit(1);
            }

            InputDetails inp = new InputDetails(input);

            FileProcessorAbstractBase fileProcessorAbstractBase = new WordFrequencyDecorator(null);
            fileProcessorAbstractBase = new WordDecorator(fileProcessorAbstractBase);
            fileProcessorAbstractBase = new SentenceDecorator(fileProcessorAbstractBase);
            fileProcessorAbstractBase = new ParagraphDecorator(fileProcessorAbstractBase);
            fileProcessorAbstractBase.process(inp);




        } else {
            System.out.println("Error: wrong number of argument passes");
            System.exit(1);
        }
    }


}
