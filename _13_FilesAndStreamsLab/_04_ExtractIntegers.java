package _13_FilesAndStreamsLab;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class _04_ExtractIntegers {
    public static void main(String[] args) {

        String inputPath = "C:\\Users\\Ordna\\Desktop\\JavaALessons\\NEW\\17.FilesAndDirectoriesLab\\TupataPapka\\Files-and-Streams\\input.txt";
        String outputPath = "C:\\Users\\Ordna\\Desktop\\JavaALessons\\NEW\\17.FilesAndDirectoriesLab\\TupataPapka\\Files-and-Streams\\output.txt";

        try (Scanner scanner = new Scanner(new FileInputStream(inputPath));
             PrintWriter writer = new PrintWriter(outputPath)) {

            while(scanner.hasNext()){
                if(scanner.hasNextInt()){
                    writer.println(scanner.nextInt());
                }
                scanner.next();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
