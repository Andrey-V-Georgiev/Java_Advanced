package _13_FilesAndStreamsLab;

import java.io.*;

public class _09_SerializeCustumObject {
    public static void main(String[] args) {

        final String objectPath = "E:\\object.ser";
        Cube cube = new Cube();
        cube.color = "green";
        cube.depth = 13;
        cube.width = 14;
        cube.height = 5;

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(objectPath))) {
            oos.writeObject(cube);
        } catch (IOException e) {
            e.printStackTrace();
        }


        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(objectPath))) {
                Cube loadedCube = (Cube)ois.readObject();
            System.out.println(loadedCube.color);
            System.out.println(loadedCube.depth);
            System.out.println(loadedCube.width);
            System.out.println(loadedCube.height);
        } catch (IOException e) {
            e.printStackTrace();
        }catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}


