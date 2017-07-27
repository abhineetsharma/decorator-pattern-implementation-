package fileProcessorDecorator.util;

import java.io.File;

/**
 * Created by abhineetsharma on 7/25/17.
 */
public class FileChecker {


    static boolean fileChecker(String filePath) {
        String path = filePath;
        File file = new File(path);

        if (file.exists() && !file.isDirectory()) {
            return true;
        } else {
            System.out.println(String.format("Error: File %s not found ", filePath));
            System.exit(1);
        }

        return false;
    }
}
