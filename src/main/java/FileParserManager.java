
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import java.io.IOException;
import java.net.URI;
import java.util.Base64;

import org.springframework.util.Base64Utils;

public class FileParserManager implements FileParser {

    private final AccountProfileRepository accountProfileRepository;

    public FileParserManager(AccountProfileRepository accountProfileRepository)
    {
        this.accountProfileRepository = accountProfileRepository;
    }


    @Override
    public void parseCSV(File csvFile) throws FileNotFoundException  {

    }

    @Override
    public File convertCSVDataToImage(String base64ImageData, String imageFormat) throws IOException
     {
        byte[] imageData = Base64.getDecoder().decode(base64ImageData);
        File imageFile = File.createTempFile("image","," + imageFormat);
        try (FileOutputStream fo = new FileOutputStream(imageFile)){
            fo.write(imageData);
            
        } 
        return imageFile;
    
    }

    @Override
    public URI createImageLink(File fileImage) {
       
    }
    
}
