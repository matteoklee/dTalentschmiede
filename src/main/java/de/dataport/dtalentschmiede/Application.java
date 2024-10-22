package de.dataport.dtalentschmiede;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "de.dataport.dtalentschmiede.**")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
        System.out.println("      _ _____     _            _            _               _          _      \n" +
                "   __| |_   _|_ _| | ___ _ __ | |_ ___  ___| |__  _ __ ___ (_) ___  __| | ___ \n" +
                "  / _` | | |/ _` | |/ _ \\ '_ \\| __/ __|/ __| '_ \\| '_ ` _ \\| |/ _ \\/ _` |/ _ \\\n" +
                " | (_| | | | (_| | |  __/ | | | |_\\__ \\ (__| | | | | | | | | |  __/ (_| |  __/\n" +
                "  \\__,_| |_|\\__,_|_|\\___|_| |_|\\__|___/\\___|_| |_|_| |_| |_|_|\\___|\\__,_|\\___|\n" +
                "                                                                              ");
    }

}
