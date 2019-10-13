package ca.cmpt213.as1;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.io.FileWriter;

/**
 * Created by John on 5/31/2016.
 * Deals displays filtered files from
 * a chosen folder with the help of fileList class
 * Create a text file and store the output
 */
public class FileLister {
    private static void textGenerator(FileWriter fileWrite, List<String> fileDirectory, int begin) throws IOException {
        if(begin == fileDirectory.size()) {
            //fileWrite.close();
        } else {
            System.out.println(fileDirectory.get(begin));
            fileWrite.write(fileDirectory.get(begin));
            fileWrite.write(System.lineSeparator());
            textGenerator(fileWrite, fileDirectory, begin + 1);
        }
    }

    public static void main(String[] args) throws IOException {
        if(args.length == 0) {
            System.out.println("Usage:\n" +
                    "\tjava FileLister <source folder> <target file> <filters>");
            System.out.println("Examples:\n" +
                    "\tjava ca.cmpt213.as1.FileLister C:\\Music\\ C:\\list.txt .mp3\n" +
                    "\tjava ca.cmpt213.as1.FileLister C:\\ C:\\test\\files.txt .mp3 .jpg\n");
        } else {
            File folders = new File(args[0]);
            FileList inputargs = new FileList(folders, args);
            File outputText = new File(args[1]);
            FileWriter fileWrite = new FileWriter(outputText);
            List<String> fileDirectory = new ArrayList<>();

            if(args.length <= 1) {

            } else if (args.length == 2) {
                inputargs.fileRecursive_NoExtension(folders);
                inputargs.fileRecursive(args, folders);
            } else {
                inputargs.fileRecursive(args, folders);
            }

            fileDirectory = inputargs.getDirectories();

            System.out.println("Statistics on Files Found:");
            System.out.println("**************************");
            System.out.println("Source Path:\t" + inputargs.getSourcePath());
            System.out.println("Target Path:\t" + inputargs.getTargetPath());
            System.out.println("Extensions:\t" + inputargs.getExtensions());
            System.out.println("File Found:\t" + inputargs.getCount() + "\n");
            System.out.println("Files:");
            System.out.println("*****************");
            float byteToMib = inputargs.getFileSize() / 104857;
            System.out.printf("Total size\t,%.2f MiB (%,d bytes)\n", byteToMib, inputargs.getFileSize());

            textGenerator(fileWrite, fileDirectory, 0);
            System.out.println("\nWriting file list to output file: " + inputargs.getTargetPath());
            fileWrite.close();
        }
    }
}
