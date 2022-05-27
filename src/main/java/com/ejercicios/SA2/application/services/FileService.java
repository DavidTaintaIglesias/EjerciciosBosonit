package com.ejercicios.SA2.application.services;

import com.ejercicios.SA2.domain.entities.FilesEntity;
import com.ejercicios.SA2.infrastructure.repository.FilesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.LocalDate;

@Service
public class FileService {

    @Value("${uploadDir}")
    private String uploadDir;

    @Autowired
    FilesRepository repository;

    public FilesEntity uploadFile(MultipartFile file) throws IOException {

        //Subir el fichero a la carpeta asignada en uploadDir en aplication.yml
        Path copyLocation = Paths
                .get(uploadDir + File.separator + StringUtils.cleanPath(file.getOriginalFilename()));
        Files.copy(file.getInputStream(), copyLocation, StandardCopyOption.REPLACE_EXISTING);

        //Guardar los datos del fichero en BBDD
        FilesEntity filesEntity = new FilesEntity(file.getOriginalFilename(), LocalDate.now());
        repository.save(filesEntity);
        return filesEntity;
    }
}
