package _13_FilesAndStreamsLab;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class _01_ReadFile {
    public static void main(String[] args) {
        String path = "C:\\Users\\Ordna\\Desktop\\JavaALessons\\NEW\\17.FilesAndDirectoriesLab\\TupataPapka\\Files-and-Streams\\input.txt";

        try (InputStream in = new FileInputStream(path)) {
            int oneByte = in.read();
            while (oneByte >= 0) {
                System.out.printf("%s ", 	Integer.toBinaryString(oneByte));
                oneByte = in.read();
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }

    }

}
