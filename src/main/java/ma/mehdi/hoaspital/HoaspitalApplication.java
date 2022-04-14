package ma.mehdi.hoaspital;

import ma.mehdi.hoaspital.entities.Patient;
import ma.mehdi.hoaspital.repositories.PatientRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication
public class HoaspitalApplication {

    public static void main(String[] args) {
        SpringApplication.run(HoaspitalApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(PatientRepository patientRepository){
        return args -> {
            patientRepository.save(new Patient(null,"ramadan",new Date(),false,500));
            patientRepository.save(new Patient(null,"ed",new Date(),true,10));
            patientRepository.save(new Patient(null,"yuna",new Date(),false,450));
            patientRepository.save(new Patient(null,"tengen",new Date(),false,50));
            patientRepository.save(new Patient(null,"halland",new Date(),true,10));
            patientRepository.save(new Patient(null,"mo",new Date(),false,2));
            patientRepository.save(new Patient(null,"ric",new Date(),false,500));
            patientRepository.save(new Patient(null,"walter",new Date(),true,100));

            patientRepository.findAll().forEach(p ->{
                System.out.println(p.getNom());
            });
        };


    }


}
