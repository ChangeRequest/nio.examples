package school.lemon.changerequest.java.nio.examples.nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by User on 05.02.2017.
 */
public class FileChannelExample {
    public static void main(String[] args) throws IOException {
        try (FileOutputStream fos =
                     new FileOutputStream("data/nio/fileChannelExample.dat");
             FileInputStream fis =
                     new FileInputStream("data/nio/fileChannelExample.dat")) {
            FileChannel fosChannel = fos.getChannel();
            ByteBuffer byteBuffer = ByteBuffer
                    .wrap("Some pretty string to be written".getBytes());
            fosChannel.write(byteBuffer);
            FileChannel fisChannel = fis.getChannel();
            ByteBuffer dst = ByteBuffer.allocate(32);
            fisChannel.read(dst);
            System.out.println(new String(dst.array()));

        }
    }
}
