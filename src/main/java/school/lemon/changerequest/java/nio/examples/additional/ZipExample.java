package school.lemon.changerequest.java.nio.examples.additional;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public class ZipExample {
    public static void main(String[] args) throws IOException {
        try (ZipOutputStream zipOutputStream =
                     new ZipOutputStream(
                             new FileOutputStream("data/additional/zipExample.zip"));
             ZipInputStream zipInputStream =
                     new ZipInputStream(new FileInputStream("data/additional/zipExample.zip"))) {
            for (int i = 0; i < 100; i++) {
                String str = "String #" + i + "\n";
                zipOutputStream.putNextEntry(new ZipEntry(String.valueOf(i)));
                zipOutputStream.write(str.getBytes());
                zipOutputStream.closeEntry();
            }
            zipOutputStream.flush();
            zipOutputStream.close();
            ZipEntry e;
            byte[] bytes = new byte[64];
            while ((e = zipInputStream.getNextEntry()) != null) {
                zipInputStream.read(bytes);
                System.out.print(new String(bytes));
            }
        }
    }
}
