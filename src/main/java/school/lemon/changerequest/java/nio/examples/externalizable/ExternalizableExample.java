package school.lemon.changerequest.java.nio.examples.externalizable;

import java.io.*;
import java.nio.charset.StandardCharsets;

/**
 * Created by User on 05.02.2017.
 */
public class ExternalizableExample implements Externalizable {
    private static final char SEPARATOR = '+';
    String title = "title";
    String name = "n@me";
    long count = 213L;
    int id = 1;

    public ExternalizableExample() {
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeChar(SEPARATOR);
        out.writeUTF(title);
        out.writeChar(SEPARATOR);
        byte[] bytes = name.getBytes(StandardCharsets.ISO_8859_1);
        out.writeInt(bytes.length);
        for (byte b : bytes) {
            out.writeByte(b);
        }
        out.writeChar(SEPARATOR);
        out.writeLong(count);
        out.writeChar(SEPARATOR);
        out.writeInt(id);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        char c = in.readChar();
        if (c == SEPARATOR) {
            this.title = in.readUTF();
        }
        if ((c = in.readChar()) == SEPARATOR) {
            int nameBytesAmount = in.readInt();
            byte[] bytes = new byte[nameBytesAmount];
            for (int i = 0; i < bytes.length; i++) {
                bytes[i] = in.readByte();
            }
            this.name = new String(bytes, StandardCharsets.ISO_8859_1);
        }
        if ((c = in.readChar()) == SEPARATOR) {
            this.count = in.readLong();
        }
        if ((c = in.readChar()) == SEPARATOR) {
            this.id = in.readInt();
        }
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        try (ObjectOutputStream oos = new ObjectOutputStream(
                new FileOutputStream("data/externalizableExample.dat"));
             ObjectInputStream ois = new ObjectInputStream(
                     new FileInputStream("data/externalizableExample.dat"))) {
            ExternalizableExample externalizableExample = new ExternalizableExample();
            oos.writeObject(externalizableExample);
            Object externalizableExampleObject = ois.readObject();
            System.out.println(externalizableExampleObject);
        }
    }

    @Override
    public String toString() {
        return "ExternalizableExample{" +
                "title='" + title + '\'' +
                ", name='" + name + '\'' +
                ", count=" + count +
                ", id=" + id +
                '}';
    }
}
