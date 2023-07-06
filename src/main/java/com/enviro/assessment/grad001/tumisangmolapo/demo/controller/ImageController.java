
import org.springframework.core.io.FileSystemResource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.enviro.assessment.grad001.tumisangmolapo.demo.service.FileParserManager;

@RestController
@RequestMapping("/v1/api/image")
public class ImageController {
    private final FileParserManager fileParserManager;

    public ImageController(FileParserManager fileParserManager)
    {
        this.fileParserManager= fileParserManager;
    }
 @GetMapping(value = "/{name}/{surname}/{imageName}")
    public FileSystemResource getHttpImageLink(
            @PathVariable String name,
            @PathVariable String surname,
            @PathVariable String imageName) {

        String filePath = "images/" + imageName;
        return new FileSystemResource(filePath);
    }

       
    

}