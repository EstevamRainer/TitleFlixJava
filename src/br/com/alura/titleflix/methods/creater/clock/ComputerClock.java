package br.com.alura.titleflix.methods.creater.clock;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ComputerClock {

    private final LocalDateTime dateFromNow = LocalDateTime.now();
    private final DateTimeFormatter beautiDateTime = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mn:ss");
    private final String formatedTime = beautiDateTime.format(dateFromNow);

    public String returnDateAndTime(){
        return formatedTime;
    }
}
