import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/api/image")
public class ImageController {
    private final FileParserManager fileParserManager;

    public ImageController(FileParserManager fileParserManager)
    {
        this.fileParserManager= fileParserManager;
    }

    @GetMapping(value = "/{name}/{surname}")
    public FileSystemResource getHttpImage(@PathVariable String name @PathVariable String surname){
        
    }

       
    

}