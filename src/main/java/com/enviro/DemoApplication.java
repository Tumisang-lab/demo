package com.enviro;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URI;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.enviro.controller.ImageController;
import com.enviro.model.AccountProfile;
import com.enviro.repository.AccountProfileRepository;
import com.enviro.service.FileParser;
import com.enviro.service.FileParserManager;


@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) throws FileNotFoundException {
		SpringApplication.run(DemoApplication.class, args);
		// Instantiate the FileParser implementation
        FileParser fileParser = new FileParserManager(null);

        // Provide the CSV file path
        String csvFilePath = "C:/Users/HP/Desktop/Tumi/csv_file/assessment.csv";
        File csvFile = new File(csvFilePath);

		// Call the parseCSV method
        fileParser.parseCSV(csvFile);

		 // Access the AccountProfileRepository bean
		 AccountProfileRepository accountProfileRepository = SpringApplication.run(DemoApplication.class, args)
		 .getBean(AccountProfileRepository.class);

			// Create a new AccountProfile entity
			AccountProfile accountProfile = new AccountProfile();
			accountProfile.setName("Tumisang");
			accountProfile.setSurname("Molapo");

		// Save the AccountProfile entity
		accountProfileRepository.save(accountProfile);

		// Access the ImageController bean
		ImageController imageController = SpringApplication.run(DemoApplication.class, args).getBean(ImageController.class);

		// Retrieve the HTTP image link from the ImageController
		String httpImageLink = imageController.getHttpImageLink("Tumisang", "Molapo","/image.jpg");

		// Print the HTTP image link
		System.out.println("HTTP Image Link: " + httpImageLink);
		

		
	}

}
