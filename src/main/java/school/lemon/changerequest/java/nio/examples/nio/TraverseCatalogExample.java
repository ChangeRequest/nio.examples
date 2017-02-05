package school.lemon.changerequest.java.nio.examples.nio;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class TraverseCatalogExample {
    private static final int WHITESPACES_PER_LEVEL = 2;
    private static final char WHITESPACE = ' ';
    public static void main(String[] args) throws IOException {
        Path path = Paths.get("data");
        traverse(path, 0);
    }
    private static void traverse(Path path, int level) throws IOException {
        System.out.println(prependedName(path, level));
        if (Files.isDirectory(path)) {
            try (DirectoryStream<Path> stream = Files.newDirectoryStream(path);) {
                for (Path p : stream) {
                    traverse(p, level + 1);
                }
            }
        }
    }
    private static String prependedName(Path path, int level) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < level * WHITESPACES_PER_LEVEL; i++) {
            sb.append(WHITESPACE);
        }
        sb.append(path.getFileName());
        if (Files.isDirectory(path)) {
            sb.append('/');
        }
        return sb.toString();
    }
}
