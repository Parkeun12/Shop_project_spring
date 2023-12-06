package com.example.testproject.Service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class FileUploadService {
//    @Value("${upload.directory}")
//    private String uploadDirectory;

    public void uploadFile(MultipartFile file) throws IOException {

        String uploadDirectory = "\\\\\\\\192.168.250.43\\\\images\\\\b\\\\";
        // 상대 경로 설정
        Path uploadPath = Paths.get(uploadDirectory).toAbsolutePath().normalize();

        System.out.println(uploadPath);

        // 업로드 디렉토리가 존재하지 않으면 생성
        if (!Files.exists(uploadPath)) {
            Files.createDirectories(uploadPath);
        }

        // 파일 저장 경로 설정
        Path targetPath = uploadPath.resolve(file.getOriginalFilename());

        // 파일을 업로드 디렉토리로 복사
        Files.copy(file.getInputStream(), targetPath, java.nio.file.StandardCopyOption.REPLACE_EXISTING);
    }
}
