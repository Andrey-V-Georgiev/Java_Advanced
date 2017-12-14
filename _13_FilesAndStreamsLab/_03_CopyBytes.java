package _13_FilesAndStreamsLab;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class _03_CopyBytes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String inputPath = "C:\\Users\\Ordna\\Desktop\\JavaALessons\\NEW\\17.FilesAndDirectoriesLab\\TupataPapka\\Files-and-Streams\\input.txt";
        String outputPath = "C:\\Users\\Ordna\\Desktop\\JavaALessons\\NEW\\17.FilesAndDirectoriesLab\\TupataPapka\\Files-and-Streams\\output.txt";

        try (FileInputStream fis = new FileInputStream(inputPath);
             FileOutputStream fos = new FileOutputStream(outputPath)) {

            int oneByte= fis.read();
            while(oneByte>=0){
                if(oneByte==' ' || oneByte=='\n'){
                    fos.write(oneByte);
                }else{
                    String decimal = String.valueOf(oneByte);
                    for (char c : decimal.toCharArray()) {
                        fos.write(c);
                    }
                }
                oneByte = fis.read();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
