package edu.acc.java2.imagefinder;

import java.util.List;
import java.util.ArrayList;
import edu.acc.java2.imagefinder.GroupExtraction;

/**
 *  @author alexanderelman
 */

public class Main {
    public static void main (String[] args) {
        final String USAGE = "Usage: java -jar images.jar {path-to-html-file.html}";

        if (args.length != 1) {
            System.out.println(USAGE);
            return;
        }
        String imageHunter = "";
        GroupExtraction ge = new GroupExtraction(imageHunter, args[1]);
        // Print out image names
        List<String> captureGroups = ge.getCaptureGroups();
        for (String group : captureGroups) {
            System.out.println(group);
        }
    }
}