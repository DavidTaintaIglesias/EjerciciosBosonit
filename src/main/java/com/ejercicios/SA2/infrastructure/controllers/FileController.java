package com.ejercicios.SA2.infrastructure.controllers;

import com.ejercicios.SA2.application.services.FileService;
import com.ejercicios.SA2.domain.entities.FilesEntity;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;

@RestController
@Api(tags = "SA2")
@RequestMapping("SA2")
public class FileController {

    @Autowired
    FileService fileService;

    @GetMapping("/")
    public String index(){

        return "upload";
    }

    @PostMapping("/uploadFile")
    public FilesEntity uploadFile(@RequestParam("file")MultipartFile file) throws IOException {

        return fileService.uploadFile(file);
    }
}
