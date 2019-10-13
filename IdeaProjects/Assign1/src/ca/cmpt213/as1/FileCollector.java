package ca.cmpt213.as1;

import java.io.File;
import java.io.IOException;

/**
 * Created by John on 5/31/2016.
 * A class which determines the filtering information, number of collections
 * , and directory of the accessed text file with the help of FileCollect class
 * and FileCollectHelp class
 */
public class FileCollector {
    public static void main(String[] args) throws IOException {
        if (args.length < 3) {
            System.out.println("Usage:");
            System.out.println("\tjava ca.cmpt213.as1.FileCollector <# collections> <bytes per collection>" +
                    " <input list file>\n");
            System.out.println("Examples:");
            System.out.println("\tjava ca.cmpt213.as1.FileCollector 3 1024 daFiles.txt");
            System.out.println("\tjava ca.cmpt213.as1.FileCollector 10 1048576 c:\\files\\input.txt");
        } else {
            File listFiles = new File(args[2]);
            if(listFiles.exists()) {
                System.out.println("Now building collection:");
                System.out.println("**************************");
                System.out.println("# Collections:\t\t" + args[0]);
                System.out.println("Size per Collections:\t" + args[1]);
                System.out.println("Source file list:\t" + args[2] + "\n");

                FileCollect filecollect = new FileCollect(args, listFiles);
                filecollect.readFile();
                filecollect.sortFiles();
                filecollect.sortCollections();
                filecollect.displayCollections();

            } else {
                System.out.println("No such file exists");
            }
        }
    }
}
