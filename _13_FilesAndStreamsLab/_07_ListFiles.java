package _13_FilesAndStreamsLab;

import java.io.File;

public class _07_ListFiles {
    public static void main(String[] args) {

        final String stringPath = "C:\\Users\\Ordna\\Desktop\\JavaALessons\\NEW\\17.FilesAndDirectoriesLab\\TupataPapka\\Files-and-Streams";
        File file = new File(stringPath);
        if(file.isDirectory()){
            File[] files = file.listFiles();
            for (File f : files) {
                if(!f.isDirectory()){
                    System.out.printf("%s: %s%n",f.getName(), f.length());
                }
            }
        }

    }
}
