package br.com.alura.titleflix.methods.stringconverter;

import br.com.alura.titleflix.methods.stringconverter.parsers.StringInDouble;
import br.com.alura.titleflix.methods.stringconverter.parsers.StringInInt;

public class NumberConverter {
    //as converções com try pra evitar erros
    public int convertInInt(String numberToBeConverted) {
        StringInInt stringInInt = new StringInInt(numberToBeConverted);
        try {
            return stringInInt.returnConvertedNumber();
        } catch (NumberFormatException exception){
            return 0;
        }

    }
    public double convertInDouble(String numberToBeConverted) {
        StringInDouble stringInDouble = new StringInDouble(numberToBeConverted);
        try {
            return stringInDouble.returnConvertedNumber();
        } catch (NumberFormatException exception){
            return 0;
        }

    }
}
