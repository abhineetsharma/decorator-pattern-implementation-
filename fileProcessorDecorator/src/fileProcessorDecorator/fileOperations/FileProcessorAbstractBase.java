package fileProcessorDecorator.fileOperations;

import java.util.List;

/**
 * Created by abhineetsharma on 7/24/17.
 */
public abstract class FileProcessorAbstractBase extends InputDetails{



    public abstract List<String> process(InputDetails inputDetails);

}
