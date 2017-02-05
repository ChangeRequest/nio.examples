package school.lemon.changerequest.java.nio.examples.additional;

import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomAccessFileExample {
    public static void main(String[] args) throws IOException {
        try (RandomAccessFile wFile = new RandomAccessFile(
                "data/additional/randomAccessFileExample", "rw");
             RandomAccessFile rFile = new RandomAccessFile(
                     "data/additional/randomAccessFileExample", "r");) {
            wFile.writeBytes("Some long string");
            System.out.println(rFile.readLine());
            wFile.seek(0);
            wFile.writeBytes("re-written");
            rFile.seek(0);
            System.out.println(rFile.readLine());
        }
    }
}
