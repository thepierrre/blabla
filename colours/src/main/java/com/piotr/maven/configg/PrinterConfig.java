//package com.piotr.maven.configg;
//
//import com.piotr.maven.services.BluePrinter;
//import com.piotr.maven.services.ColourPrinter;
//import com.piotr.maven.services.GreenPrinter;
//import com.piotr.maven.services.RedPrinter;
//import com.piotr.maven.services.impl.*;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//public class PrinterConfig {
//
//    @Bean
//    public BluePrinter bluePrinter() {
//        return new EnglishBluePrinter();
//    }
//    @Bean
//        public RedPrinter redPrinter() {
//            return new EnglishRedPrinter();
//        }
//
//    @Bean
//    public GreenPrinter greenPrinter() {
//        return new EnglishGreenPrinter();
//    }
//
//    @Bean
//    public ColourPrinter colourPrinter(BluePrinter bluePrinter, RedPrinter redPrinter, GreenPrinter greenPrinter) {
//        return new ColourPrinterImpl(redPrinter, bluePrinter, greenPrinter);
//    }
//}

// When the app is started, it looks for the configuration file (PrinterConfig.java)
// It creates the beans for bluePrinter, redPrinter, and greenPrinter
// When it gets the colourPrinter, it's going to look in the app context for blue, red- and greenPrinter,
    // which it already has, inject them into the 'public ColourPrinter' bean declaration
    // and then in the application, we're going to have the 'public ColourPrinter' bean
    // then the colourPrinter bean is injected into the ColoursApplications class in ColoursApplication.java,
    // and we use it inside our run to print it.
