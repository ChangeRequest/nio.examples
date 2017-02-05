package school.lemon.changerequest.java.nio.examples.serializable;

import java.io.*;

public class SerializableWithFields implements Serializable {
    int i;
    String s = "Hello World!";
    Double d;
    boolean b = true;

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        try (ObjectOutputStream oos = new ObjectOutputStream(
                new FileOutputStream("data/serializableWithFieldsExample.dat"));
             ObjectInputStream ois = new ObjectInputStream(
                     new FileInputStream("data/serializableWithFieldsExample.dat"))) {
            SerializableWithFields serializableWithFields = new SerializableWithFields();
            oos.writeObject(serializableWithFields);
            Object serializableWithFieldsObject = ois.readObject();
            System.out.println(serializableWithFieldsObject);
        }
    }

    @Override
    public String toString() {
        return "SerializableWithFields{" +
                "i=" + i +
                ", s='" + s + '\'' +
                ", d=" + d +
                ", b=" + b +
                '}';
    }
}
