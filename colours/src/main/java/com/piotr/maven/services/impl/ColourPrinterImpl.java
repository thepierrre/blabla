package com.piotr.maven.services.impl;

import com.piotr.maven.services.BluePrinter;
import com.piotr.maven.services.ColourPrinter;
import com.piotr.maven.services.GreenPrinter;
import com.piotr.maven.services.RedPrinter;
import org.springframework.stereotype.Component;

@Component // @Component - another way of declaring Beans
public class ColourPrinterImpl implements ColourPrinter {
    private RedPrinter redPrinter;
    private BluePrinter bluePrinter;
    private GreenPrinter greenPrinter;

    // If you want to use Spanish names instead of English ones,
    // you delete '@Components' from the English ones and add it to the Spanish one.

//    public ColourPrinterImpl() {
//        this.redPrinter = new EnglishRedPrinter();
//        this.bluePrinter = new EnglishBluePrinter();
//        this.greenPrinter = new EnglishGreenPrinter();
//    }

    public ColourPrinterImpl(RedPrinter redPrinter, BluePrinter bluePrinter, GreenPrinter greenPrinter) {
        this.redPrinter = redPrinter;
        this.bluePrinter = bluePrinter;
        this.greenPrinter = greenPrinter;

    }

    @Override
    public String print() {
        return String.join(", ", redPrinter.print(), bluePrinter.print(), greenPrinter.print());
    }
}