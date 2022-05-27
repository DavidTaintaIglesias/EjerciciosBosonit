package com.ejercicios.SA2.application.services;

import com.ejercicios.SA2.domain.entities.FilesEntity;
import com.ejercicios.SA2.infrastructure.repository.FilesRepository;
import com.ejercicios.shared.exceptions.NotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class FileService {

    @Value("${uploadDir}")
    private String uploadDir;

    @Value("${downloadDir}")
    private String downloadDir;

    @Autowired
    FilesRepository repository;

    public FilesEntity uploadFile(MultipartFile file) throws IOException {

        //Subir el fichero a la carpeta asignada en uploadDir en aplication.yml
        Path copyLocation = Paths
                .get(uploadDir + File.separator + StringUtils.cleanPath(file.getOriginalFilename()));
        Files.copy(file.getInputStream(), copyLocation, StandardCopyOption.REPLACE_EXISTING);

        //Obtener la exension del fichero
        String extension = Optional.of(file.getOriginalFilename())
                .filter(f->f.contains("."))
                .map(f->f.substring(file.getOriginalFilename().lastIndexOf(".") + 1))
                .orElse("");

        //Guardar los datos del fichero en BBDD
        FilesEntity filesEntity = new FilesEntity(file.getOriginalFilename(), LocalDateTime.now(), uploadDir, extension);
        repository.save(filesEntity);
        return filesEntity;
    }

    public void setPath(String path){

        uploadDir = path;
    }

    public void downloadByName(String name) throws Exception{

        FilesEntity fileEntity = repository.findByName(name).orElseThrow(()-> new NotFound("name not found"));

        MultipartFile file = (MultipartFile) fileEntity;

        Path copyLocation = Paths
                .get(downloadDir + File.separator + fileEntity.getName());
        Files.copy(file.getInputStream(), copyLocation, StandardCopyOption.REPLACE_EXISTING);
    }
}
