package com.enviro.controller;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;



@RestController
@RequestMapping("/v1/api/image")
public class ImageController {
    
    
 @GetMapping(value = "/{name}/{surname}/{imageName}")
    public String getHttpImageLink(
            @PathVariable String name,
            @PathVariable String surname,
            @PathVariable String imageName) {

        String filePath = "images/" + imageName;
        return filePath;

    }

    @PostMapping("upload")
    public ResponseEntity<?> documentapload(@RequestParam("file") MultipartFile file)
    {
        return null;
    }

 @GetMapping("upload")
    public String documentapload1()
    {
        return "upload";
    }
       
    

}