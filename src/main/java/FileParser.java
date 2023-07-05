import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URI;

public interface FileParser {

    void parseCSV(File csvFile) throws FileNotFoundException;
    File convertCSVDataToImage(String base64ImageData, String imageFormat) throws IOException;
     URI createImageLink(File fileImage);
    
}
