package ca.cmpt213.as1;


import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.util.*;
import java.io.IOException;

/**
 * Created by John on 5/31/2016.
 * A class that creates reads the text file to again access to the files
 * Filteres the file based on bytes
 * Contains a display function for the output
 */
public class FileCollect {
    private int numberFiles;
    private double fileSize;
    private File thisFile;
    private List<File> fileList;
    private List<FileCollectHelp> collect = new ArrayList<>();
    private FileCollectHelp extraCollect = new FileCollectHelp();

    public FileCollect(String[] args, File thisFile) {
        this.numberFiles = Integer.parseInt(args[0]);
        this.fileSize = Double.parseDouble(args[1]);
        this.thisFile = thisFile;
        this.fileList = new ArrayList<>();

        for(int i = 0; i < numberFiles; i++) {
            collect.add(new FileCollectHelp());
        }
    }

    public void displayCollections() {
        int number = 1;
        for(FileCollectHelp Collection: collect) {
            double inMib = Collection.getCollectionSize() / 104857;
            System.out.printf("Collection %d: %,.2f MiB (%,.0f bytes)\n", number, inMib, Collection.getCollectionSize());
            System.out.println("**************************************************");
            Collection.displayFiles();
            System.out.println("");
            number++;
        }

        //System.out.println(extraCollect.getCollectionSize());
        double MibAgain = extraCollect.getCollectionSize() / 104857;
        System.out.printf("Extra Files: %,.2f MiB (%,.0f bytes)\n", MibAgain, extraCollect.getCollectionSize());
        System.out.println("**************************************************");
        extraCollect.displayFiles();
    }

    public void sortCollections() {
        for(File file: fileList) {
            if(file.exists()) {
                Collections.shuffle(collect);
                boolean inserted = false;
                for(FileCollectHelp fileCollect: collect) {
                    if(fileCollect.checkCollectionSize(fileSize, file)) {
                        fileCollect.fileInput(file);
                        inserted = true;
                        break;
                    }
                }
                if(!inserted) {
                    extraCollect.fileInput(file);
                }
            } else {
                System.out.println("Warning: File does not exist (" + file.getAbsolutePath() +").");
            }
        }
    }

    public void readFile() throws IOException {
        BufferedReader read = new BufferedReader(new FileReader(thisFile.getAbsolutePath()));
        String oneLine = null;
        while((oneLine = read.readLine()) != null) {
            File checkDirectory = new File(oneLine);
            if(checkDirectory.exists()) {
                fileList.add(checkDirectory);
            } else {
                System.out.println("Warning: File does not exist (" + checkDirectory + ")");
            }
        }
    }
    public void sortFiles() {
        Comparator<File> filesorting = new Comparator<File>() {
            @Override
            public int compare(File o1, File o2) {
                if(o1.length() > o2.length()) {
                    return -1;
                } else if(o1.length() == o2.length()) {
                    return 0;
                } else {
                    return 1;
                }
            }
        };

        java.util.Collections.sort(fileList, filesorting);
    }

}
