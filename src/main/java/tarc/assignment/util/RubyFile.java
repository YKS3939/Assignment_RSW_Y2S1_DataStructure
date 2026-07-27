package tarc.assignment.util;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class RubyFile {
    public static void append(Path path, String content) {
        try (BufferedWriter writer = Files.newBufferedWriter(path, StandardCharsets.UTF_8,
                StandardOpenOption.CREATE,
                StandardOpenOption.APPEND)) {
            writer.write(content + System.lineSeparator());
        } catch (IOException e) {
            throw new RuntimeException("Failed to execute file append", e);
        }
    }
}
