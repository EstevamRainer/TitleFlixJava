package br.com.alura.titleflix.methods.stringconverter.parsers;

public class StringInDouble extends StringInNumber{
    //Uma classe pra guardar o ParseDouble
    public StringInDouble(String number) {
        super(number);
    }
    public double returnConvertedNumber(){
        return Double.parseDouble(number);
    }
}
