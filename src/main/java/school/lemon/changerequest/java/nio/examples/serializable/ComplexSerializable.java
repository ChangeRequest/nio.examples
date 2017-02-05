package school.lemon.changerequest.java.nio.examples.serializable;

import java.io.*;

/**
 * Created by User on 26.01.2017.
 */
public class ComplexSerializable extends SerializableParent implements Serializable {
    String s3 = "ComplexSerializable";
    static String s4 = "staticString";
    transient String s5 = "transientString";

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        try (ObjectOutputStream oos = new ObjectOutputStream(
                new FileOutputStream("data/complexSerializableExample.dat"));
             ObjectInputStream ois = new ObjectInputStream(
                     new FileInputStream("data/complexSerializableExample.dat"))) {
            ComplexSerializable complexSerializable = new ComplexSerializable();
            complexSerializable.s1 = "newNonSerializableParentValue";
            complexSerializable.s2 = "newSerializableParentValue";
            complexSerializable.s3 = "newValue";
            ComplexSerializable.s4 = "newStaticString";
            complexSerializable.s5 = "newTransientValue";
            oos.writeObject(complexSerializable);
            Object complexSerializableObject = ois.readObject();
            System.out.println(complexSerializableObject);
        }
        
    }

    @Override
    public String toString() {
        return "ComplexSerializable{" +
                "s3='" + s3 + '\'' +
                "s4='" + s4 + '\'' +
                ", s5='" + s5 + '\'' +
                "} " + super.toString();
    }
}

class SerializableParent extends NonSerializableParent implements Serializable {
    String s2 = "SerializableParent";

    public SerializableParent() {

    }

    @Override
    public String toString() {
        return "SerializableParent{" +
                "s2='" + s2 + '\'' +
                "} " + super.toString();
    }
}

class NonSerializableParent {
    String s1 = "NonSerializableParent";

    public NonSerializableParent() {

    }

    @Override
    public String toString() {
        return "NonSerializableParent{" +
                "s1='" + s1 + '\'' +
                '}';
    }
}