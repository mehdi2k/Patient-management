package ma.mehdi.hoaspital;

import ma.mehdi.hoaspital.entities.Patient;
import ma.mehdi.hoaspital.repositories.PatientRepository;
import ma.mehdi.hoaspital.sec.service.SecurityService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Date;

@SpringBootApplication
public class HoaspitalApplication {

    public static void main(String[] args) {
        SpringApplication.run(HoaspitalApplication.class, args);
    }

    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    //@Bean
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

    //@Bean
    CommandLineRunner saveUsers(SecurityService securityService){
        return args -> {
            securityService.saveNewUser("mehdi","1234","1234");
            securityService.saveNewUser("mehdi2k","1234","1234");
            securityService.saveNewUser("hassan","1234","1234");

            securityService.saveNewRole("ADMIN","");
            securityService.saveNewRole("USER","");

            securityService.addRoleToUser("mehdi","ADMIN");
            securityService.addRoleToUser("mehdi","USER");
            securityService.addRoleToUser("mehdi2k","USER");
            securityService.addRoleToUser("hassan","USER");

        };
    }

}
