package org.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws IOException {
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
                .replace("[Subject]", "Test subject")
                .replace("[LiliumContract]", liliumContract)
                .replace("[CategoryManager]", categoryManager)
                .replace("[SupplyChainOperationManager]", supplyChainOperationManager)
                .replace("[SupplyChainQualityManager]", supplyChainQualityManager);

        System.out.println(personalizedContent);
    }
}