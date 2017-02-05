package school.lemon.changerequest.java.nio.examples.serializable;


import java.io.*;

public class SerializableWithSerialVersion implements Serializable {
    private static final long serialVersionUID = -3536974916609510237L;

    String s = "s";
    Integer i = 1;
    Long l = 2L;
    boolean b = false;


    public static void main(String[] args) throws IOException, ClassNotFoundException {
        try (ObjectOutputStream oos = new ObjectOutputStream(
                new FileOutputStream("data/serializableWithSerialVersion.dat"));
             ObjectInputStream ois = new ObjectInputStream(
                     new FileInputStream("data/serializableWithSerialVersion.dat"))) {
            SerializableWithSerialVersion serializableWithFields =
                    new SerializableWithSerialVersion();
            oos.writeObject(serializableWithFields);
            Object serializableWithFieldsObject = ois.readObject();
            System.out.println(serializableWithFieldsObject);
        }
    }

    @Override
    public String toString() {
        return "SerializableWithSerialVersion{" +
                "s='" + s + '\'' +
                ", i=" + i +
                ", l=" + l +
                ", b=" + b +
                '}';
    }
}
