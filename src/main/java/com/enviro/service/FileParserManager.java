package com.enviro.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.Base64;

import com.enviro.model.AccountProfile;
import com.enviro.repository.AccountProfileRepository;



public class FileParserManager<accountProfileRepository> implements FileParser {

    private final AccountProfileRepository accountProfileRepository;
    File csvFile = new File("C:/Users/HP/Desktop/Tumi/csv_file/assessment.csv");

    public FileParserManager(AccountProfileRepository accountProfileRepository)
    {
        this.accountProfileRepository = accountProfileRepository;
    }


    @Override
    public void parseCSV(File csvFile) throws FileNotFoundException  {
        try (BufferedReader reader = new BufferedReader(new FileReader(csvFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] fields = line.split(",");
                if (fields.length >= 4) {
                    String name = fields[0];
                    String surname = fields[1];
                    String imageFormat = fields[2];
                    String imageData = fields[3];


                    // Convert base64 image data to a physical image file
                    File imageFile = convertCSVDataToImage(imageData);

                    // Create the HTTP image link
                    URI httpImageLink = createImageLink(imageFile);

                    // Create and save the AccountProfile entity
                    AccountProfile accountProfile = new AccountProfile();
                    accountProfile.setName(name);
                    accountProfile.setSurname(surname);
                    accountProfile.setHttpImageLink(httpImageLink.toString());

                    accountProfileRepository.save(accountProfile);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("Failed to parse the CSV file.", e);
        }
    }

    

    @Override
    public File convertCSVDataToImage(String base64ImageData) throws IOException
     {
       try {
            // Convert base64 image data to a physical file
            byte[] imageData = Base64.getDecoder().decode(base64ImageData);
            File imageFile = File.createTempFile("image", ".jpg");
            try (FileOutputStream fos = new FileOutputStream(imageFile)) {
                fos.write(imageData);
            }
            return imageFile;
        } catch (IOException e) {
            throw new RuntimeException("Failed to convert CSV data to image file.", e);
        }
    
    }

    @Override
    public URI createImageLink(File fileImage) {
        try {
            // Move the image file to a directory accessible by the REST endpoint
            File destinationDir = new File("images");
            if (!destinationDir.exists()) {
                destinationDir.mkdirs();
            }
            File destinationFile = new File(destinationDir, fileImage.getName());
            Path destinationPath = (Path) destinationFile.toPath();

            Files.move(fileImage.toPath(), destinationPath, StandardCopyOption.REPLACE_EXISTING);
           
            return ((java.nio.file.Path) destinationPath).toUri();
        } catch (IOException e) {
            throw new RuntimeException("Failed to create image link.", e);
        }
    }
}
    

