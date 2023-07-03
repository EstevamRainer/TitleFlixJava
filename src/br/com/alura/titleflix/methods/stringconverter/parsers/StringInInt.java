package br.com.alura.titleflix.methods.stringconverter.parsers;

public class StringInInt extends StringInNumber {
    //Uma classe pra guardar o ParseInt
    public StringInInt(String number) {
        super(number);
    }
    public int returnConvertedNumber() {
        return Integer.parseInt(number);
    }
}
