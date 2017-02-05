package school.lemon.changerequest.java.nio.examples.serializable;

import java.io.*;

public class EmptySerializable implements Serializable {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        try (ObjectOutputStream oos = new ObjectOutputStream(
                new FileOutputStream("data/emptySerializableExample.dat"));
             ObjectInputStream ois = new ObjectInputStream(
                     new FileInputStream("data/emptySerializableExample.dat"))) {
            EmptySerializable emptySerializable = new EmptySerializable();
            oos.writeObject(emptySerializable);
            Object emptySerializableObject = ois.readObject();
            System.out.println(emptySerializableObject);
        }
    }

    @Override
    public String toString() {
        return "EmptySerializable{}";
    }
}
