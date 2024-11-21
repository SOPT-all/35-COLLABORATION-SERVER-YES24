package sopt.yes24.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Configuration
public class FileStorageConfig {
    @Value("${file.upload-dir}")
    private String uploadDir;

    @Bean
    public Path uploadPath() {
        Path path = Paths.get(uploadDir);
        if (!Files.exists(path)) {
            try {
                Files.createDirectories(path); // 디렉토리 생성
            } catch (IOException e) {
                throw new RuntimeException("Could not create upload directory!", e);
            }
        }
        return path;
    }
}

