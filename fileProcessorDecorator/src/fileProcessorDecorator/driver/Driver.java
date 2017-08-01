package fileProcessorDecorator.driver;

import fileProcessorDecorator.fileOperations.InputDetails;
import fileProcessorDecorator.fileOperations.FileProcessorAbstractBase;
import fileProcessorDecorator.fileOperations.WordFrequencyDecorator;
import fileProcessorDecorator.fileOperations.WordDecorator;
import fileProcessorDecorator.fileOperations.SentenceDecorator;
import fileProcessorDecorator.fileOperations.ParagraphDecorator;
import fileProcessorDecorator.util.Results;

/**
 * Created by abhineetsharma on 7/24/17.
 */
public class Driver {

    public static void main(String[] args) {
        if (null != args && args.length > 1) {
            String input = args[0];
            if (input.equalsIgnoreCase("${arg0}")) {
                System.out.println("Error: No input file passed");
                System.exit(1);
            }
            String output = args[1];
            if (output.equalsIgnoreCase("${arg1}")) {
                System.out.println("Error: No output file passed");
                System.exit(1);
            }

            InputDetails inp = new InputDetails(input);
            Results results = new Results(output);
            FileProcessorAbstractBase fileProcessorAbstractBase = new WordFrequencyDecorator(null);
            fileProcessorAbstractBase = new WordDecorator(fileProcessorAbstractBase);
            fileProcessorAbstractBase = new SentenceDecorator(fileProcessorAbstractBase);
            fileProcessorAbstractBase = new ParagraphDecorator(fileProcessorAbstractBase);
            fileProcessorAbstractBase.process(inp,results);
            results.writeToStdout();
            results.writeToFile(output);



        } else {
            System.out.println("Error: wrong number of argument passes");
            System.exit(1);
        }
    }


}
