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
    private List<String> captureGroups;


    public GroupExtraction () {
    }

    public GroupExtraction(String regularExpression) {
        this.regularExpression = regularExpression;
    }

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

    private void openFile() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(this.fileName));
        return;
    }

    public List<String> getCaptureGroups() {
        return captureGroups;
    }

    private void setCaptureGroups(BufferedReader reader) throws IOException {
        List<String> cg = new ArrayList<>();
        Pattern pattern = Pattern.compile(this.regularExpression);
        String line = reader.readLine();

        if (line == null) {
            System.out.println("Couldn't load file!");
            return;
        }

        Matcher m = pattern.matcher(line);
        int i;
        while (line != null) {
            i = 1;
            if (m.matches()) {
                while (m.find()) {
                    captureGroups.add(m.group(i));
                    i++;
                }
            }
            line = reader.readLine();
        }
        this.captureGroups = cg;

        return;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "GroupExtraction{" +
                "regularExpression='" + regularExpression + '\'' +
                ", fileName='" + fileName + '\'' +
                '}';
    }
}
