package com.ejercicios.SA2.infrastructure.controllers;

import com.ejercicios.SA2.application.services.FileService;
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
    public String uploadFile(@RequestParam("file")MultipartFile file, RedirectAttributes redirectAttributes) throws IOException {

        fileService.uploadFile(file);
        redirectAttributes.addFlashAttribute("message", "You successfully uploaded " + file.getOriginalFilename()+"!");

        return "redirect:/";
    }
}
