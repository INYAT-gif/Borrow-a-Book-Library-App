package se.inyat.workshop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import se.inyat.workshop.repository.AppUserRepository;
import se.inyat.workshop.repository.DetailsRepository;

@Component
public class MyCommandLineRunner implements CommandLineRunner {

    @Autowired
    AppUserRepository appUserRepository;

    @Autowired
    DetailsRepository detailsRepository;

    public void run(String...args) throws Exception {

    }
}
