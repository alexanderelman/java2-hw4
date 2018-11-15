package edu.acc.java2.imagefinder;

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

    }
}