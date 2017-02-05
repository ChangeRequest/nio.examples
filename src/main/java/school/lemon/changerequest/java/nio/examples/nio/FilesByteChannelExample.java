package school.lemon.changerequest.java.nio.examples.nio;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SeekableByteChannel;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class FilesByteChannelExample {
    public static void main(String[] args) throws IOException {
        SeekableByteChannel channel = Files.newByteChannel(
                Paths.get("data/nio/filesByteChannelExample.dat"),
                StandardOpenOption.CREATE, StandardOpenOption.READ,
                StandardOpenOption.WRITE);
        channel.write(ByteBuffer.wrap("files bytes channel example".getBytes()));
        channel.position(0);
        ByteBuffer byteBuffer = ByteBuffer.allocate(32);
        channel.read(byteBuffer);
        System.out.println(new String(byteBuffer.array()));
        channel.close();
    }
}
