package ca.cmpt213.as1;

import java.io.FileFilter;
import java.util.ArrayList;
import java.util.List;
import java.io.File;

/**
 * Created by John on 5/31/2016.
 * Filtered the file based on the extensions
 * Gives total bytes  and number of the filtered files
 */
public class FileList {
    private File folder;
    private int filenumber;
    private long fileSize;
    private String[] args;
    private List<String> filteredDirectories = new ArrayList<>();

    public FileList(File folder, String[] args) {
        this.folder = folder;
        this.filenumber = 0;
        this.fileSize = 0;
        this.args = args;
    }

    private boolean filter(String[] args, File file) {
        FileFilter filterF = new FileFilter() {
            @Override
            public boolean accept(File file) {
                for(int i = 2; i < args.length; i++) {
                    if(file.getName().endsWith(args[i]))  {
                        return true;
                    }
                }
                return false;
            }
        };

        return filterF.accept(file);
    }

    public void fileRecursive_NoExtension(File folder) {
        for(File file: folder.listFiles()) {
            if(file.isDirectory()) {
                fileRecursive_NoExtension(file);
            } else {
                filteredDirectories.add(file.getAbsolutePath());
                filenumber++;
                fileSize += file.length();
            }
        }
    }

    public void fileRecursive(String[] args ,File folder) {
        for(File file: folder.listFiles()) {
            if(file.isDirectory()) {
                fileRecursive(args ,file);
            } else {
                if(filter(args, file)) {
                    filteredDirectories.add(file.getAbsolutePath());
                    filenumber++;
                    fileSize += file.length();
                }
            }
        }
    }

    public int getCount() {
        return filenumber;
    }

    public String getSourcePath() {
        return args[0];
    }

    public String getTargetPath() {
        return args[1];
    }

    public String getExtensions() {
        if(args.length <= 2) {
            return "";
        } else if(args.length == 3) {
            return args[2];
        } else {
            String listExtensions = "";
            for(int i = 2; i < args.length; i++) {
                listExtensions += (args[i] + " ");
            }
            return listExtensions;
        }
    }

    public List<String> getDirectories() {
        return filteredDirectories;
    }

    public long getFileSize() {
        return fileSize;
    }

}
