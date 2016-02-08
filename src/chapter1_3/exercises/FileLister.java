package chapter1_3.exercises;

import java.io.File;

public class FileLister {

    public void printContents(File file, int depth) {
        File[] files = file.listFiles();
        for (int i=0; i < files.length; i++) {
            if (files[i].isDirectory()) {
                printFilename(files[i], depth);
                printContents(files[i], depth + 1);
            } else {
                printFilename(files[i], depth);
            }
        }
    }

    private void printFilename(File filename, int depth) {
        String whitespace = tabs(depth);
        System.out.println(whitespace + filename.getName());
    }

    private String tabs(int depth) {
        String tabs = "";
        for (int i = 0; i < depth; i++) {
            tabs += "\t";
        }
        return tabs;
    }
    public static void main(String[] args) {
        System.out.println(System.getProperty("user.dir"));
        String filename = args[0];
        FileLister filelister = new FileLister();
        filelister.printContents(new File(filename), 0);
    }
}


/*

printContents(dirname, depth) {
    files = dirname.listfiles
    for file in files:
        if file is directory:
            printContents(dirname, depth +1)
        else
            printFile(filename, depth)
}

printFilename(filename, depth) {

}
*/