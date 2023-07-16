package com.enviro.controller;
import org.springframework.core.io.FileSystemResource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



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

       
    

}