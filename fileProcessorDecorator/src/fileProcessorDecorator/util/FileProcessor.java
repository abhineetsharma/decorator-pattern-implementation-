package fileProcessorDecorator.util;

import java.io.*;

public class FileProcessor {

    private String filePath;
    private File file;
    private BufferedReader br;

    Logger.DebugLevel INFO = Logger.DebugLevel.INFO;
    Logger.DebugLevel CONSTRUCTOR = Logger.DebugLevel.CONSTRUCTOR;
    Logger.DebugLevel FILE_PROCESSOR = Logger.DebugLevel.FILE_PROCESSOR;

    //constructor
    public FileProcessor(String path) {
        this.filePath = path;
        getInitializedFileObject();
        Logger.writeMessage(String.format("FileProcessor Constructor: Object Crested with  file path set to : %s", filePath), CONSTRUCTOR);
        Logger.addTextSeparator(CONSTRUCTOR);
    }

    public FileProcessor() {
        Logger.addTextSeparator(CONSTRUCTOR);
        Logger.writeMessage(String.format("FileProcessor Constructor: Object Crested "), CONSTRUCTOR);
        Logger.addTextSeparator(CONSTRUCTOR);
    }

    private BufferedReader getInitializedBufferedReaderObject(FileInputStream fStream) {
        return new BufferedReader(new InputStreamReader(fStream));
    }

    private void getInitializedFileObject() {
        br = null;
        String path = filePath;
        file = new File(path);
        if (FileChecker.fileChecker(path)) {
            try {
                br = getInitializedBufferedReaderObject(new FileInputStream(file));
            } catch (IOException ex) {
                if (br != null) try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    Logger.writeMessage(e.getMessage(), FILE_PROCESSOR);
                    System.exit(1);
                }
            }
        }
    }

    //get the one at a time from the input file
    public String readLine() {
        String strLine;
        try {
            if ((strLine = br.readLine()) != null) {
                return strLine.trim();
            } else {
                br.close();
                return null;
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error in readLine, check log for information");
            System.exit(1);
        }
        return null;
    }


    @Override
    public String toString() {
        String className = this.getClass().getName();
        String description = "This class has a method String readLine(...), which returns one line at a time from a file.";
        String str = String.format("Class : %s\nMethod toString()\nDescription : %s\nPrivate variable inputPath value is : %s\n", className, description, filePath);
        System.out.println(str);
        return str;
    }
}