package school.lemon.changerequest.java.nio.examples.additional;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;

public class FilesTreeTraversal {
    public static void main(String[] args) throws IOException {
        Files.walkFileTree(Paths.get("data"), new SimpleFileVisitor<Path>() {
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                printFileInfo(file, attrs);
                return super.visitFile(file, attrs);
            }
            @Override
            public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
                printFileInfo(dir, attrs);
                return super.preVisitDirectory(dir, attrs);
            }
            private void printFileInfo(Path path, BasicFileAttributes attrs) {
                FileTime creationTime = attrs.creationTime();
                long size = attrs.isDirectory() ? 0 : attrs.size();
                String fileName = attrs.isDirectory()
                        ? path.getFileName().toString() + '/'
                        : path.getFileName().toString();
                System.out.println(String.format("%20s | %15d | %s", creationTime.toString(), size, fileName));
            }
        });
    }
}
