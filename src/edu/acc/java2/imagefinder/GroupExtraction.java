package edu.acc.java2.imagefinder;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

/**
 *  @author alexanderelman
 */

public class GroupExtraction {
    private String regularExpression;
    private String fileName;

    public GroupExtraction(String regularExpression, String fileName) {
        this.regularExpression = regularExpression;
        this.fileName = fileName;

    }


    public String getRegularExpression() {
        return regularExpression;
    }

    public void setRegularExpression(String regularExpression) {
        this.regularExpression = regularExpression;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    private BufferedReader openFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(this.fileName))) {
            return reader;
        } catch FileNotFoundException fileNotFoundException {
            System.out.printf("File %s could not be found. \n\n%s\n", fileName, filenotfoundexception);
        }
        catch(IOException ioexception){
            System.out.printf("IOException trying to access file %s" +
                    "\n\n %s\n", fileName, ioexception);
        }
    }

    private List<String> generateCaptureGroups(BufferedReader reader) {
        List<String> captureGroups = new ArrayList<>();
        Pattern pattern = Pattern.compile(this.regularExpression);
        BufferedReader reader = this.openFile();

        line = reader.readLine();

        if (line == null) {
            System.out.println("Couldn't load file!");
            return captureGroups;
        }

        Matcher m = pattern.matcher(line);

        while (line != null) {
            
            line = reader.readLine();
        }

        return captureGroups;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "GroupExtraction{" +
                "regularExpression='" + regularExpression + '\'' +
                ", fileName='" + fileName + '\'' +
                '}';
    }
}
