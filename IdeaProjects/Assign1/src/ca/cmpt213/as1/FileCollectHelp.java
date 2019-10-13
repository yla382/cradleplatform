package ca.cmpt213.as1;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
/**
 * Created by John on 5/31/2016.
 * A class that are used as a collections
 * Used by the FileCollect class for adding the file and and get total bytes
 */
public class FileCollectHelp {
    private double collectionSize;
    private List<File> fileLists = new ArrayList<>();

    FileCollectHelp() {
        collectionSize = 0.0;
    }

    public void fileInput(File file) {
        fileLists.add(file);
        collectionSize += file.length();
    }

    public double getCollectionSize() {
        return collectionSize;
    }

    public void displayFiles() {
        for(File file: fileLists) {
            System.out.println(file.getAbsolutePath());
        }
    }

    public boolean checkCollectionSize(double bytes, File file) {
        if(collectionSize + file.length() <= bytes) {
            return true;
        }
        return false;
    }
}
