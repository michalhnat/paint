package com.paint;

import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
/**
 * The Serializer class provides methods to serialize and deserialize an ArrayList of IShape objects.
 */
public class Serializer {
    /**
     * Serializes the given ArrayList of IShape objects to a file.
     *
     * @param shapes   the ArrayList of IShape objects to be serialized
     * @param filename the name of the file to which the ArrayList should be serialized
     */
    public static void serializeArray(ArrayList<IShape> shapes, String filename) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filename))) {
            System.out.println(shapes);
            out.writeObject(shapes);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Deserializes an ArrayList of IShape objects from a file.
     *
     * @param filename the name of the file from which the ArrayList should be deserialized
     * @return the deserialized ArrayList of IShape objects
     */
    public static ArrayList<IShape> deserializeArray(String filename) {
        ArrayList<IShape> shapes = new ArrayList<IShape>();
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename))) {
            shapes = (ArrayList<IShape>) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return shapes;
    }
}
