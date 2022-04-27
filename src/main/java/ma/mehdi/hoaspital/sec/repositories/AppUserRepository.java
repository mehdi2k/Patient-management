package ma.mehdi.hoaspital.sec.repositories;

import ma.mehdi.hoaspital.sec.entities.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppUserRepository extends JpaRepository<AppUser,String> {
    AppUser findByUsername(String username);
}
