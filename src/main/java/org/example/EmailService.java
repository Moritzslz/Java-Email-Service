package org.example;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.nio.file.*;
import java.util.Properties;

public class EmailService {

    private final JavaMailSender emailSender;

    public EmailService(JavaMailSender emailSender) {
        this.emailSender = emailSender;
    }

    public String buildEmail(String name, String subject) {
        try {
            String templatePath = "EmailTemplate.html";
            String recipientName = "John Doe";
            String recipientEmail = "john.doe@example.com";
            String liliumContract = "Test1";
            String categoryManager  = "Test2";
            String supplyChainOperationManager = "Test3";
            String supplyChainQualityManager = "Test4";

            // Read HTML file as a string
            String htmlContent = new String(Files.readAllBytes(Paths.get(templatePath)));

            // Replace placeholder with recipient's name
            String personalizedContent = htmlContent
                    .replace("[Name]", recipientName)
                    .replace("[Subject]", subject)
                    .replace("[LiliumContract]", liliumContract)
                    .replace("[CategoryManager]", categoryManager)
                    .replace("[SupplyChainOperationManager]", supplyChainOperationManager)
                    .replace("[SupplyChainQualityManager]", supplyChainQualityManager);

            // Send the email
            sendEmail(recipientEmail, subject, personalizedContent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Receiver readExcel() throws FileNotFoundException {
        // Load Excel file
        FileInputStream file = new FileInputStream(new File("Supplier info_contact list - Copy.xlsx"));

        // Create Workbook instance
        Workbook workbook = WorkbookFactory.create(file);

        // Get the first sheet
        Sheet sheet = workbook.getSheetAt(0);

        // Iterate through each row
        for (Row row : sheet) {
            // Iterate through each cell in the row
            for (Cell cell : row) {
                // Print cell value
                System.out.print(cell.toString() + "\t");
            }
            System.out.println(); // Move to the next line after printing each row
        }

        // Close the workbook
        workbook.close();
        file.close();
    } catch (FileNotFoundException e) {
        e.printStackTrace();
    } catch (IOException e) {
        e.printStackTrace();
    }
    }

    public static void sendEmail(String recipientEmail, String subject, String htmlContent) throws MessagingException {

    }
}
