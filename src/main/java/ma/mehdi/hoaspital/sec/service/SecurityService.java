package ma.mehdi.hoaspital.sec.service;

import ma.mehdi.hoaspital.sec.entities.AppRole;
import ma.mehdi.hoaspital.sec.entities.AppUser;

public interface SecurityService {
    AppUser saveNewUser(String username, String password, String passConfirm);
    AppRole saveNewRole(String roleName, String description);
    void addRoleToUser(String username, String roleName);
    void removeRoleFromUser(String username, String roleName);
    AppUser loadUserByUserName(String username);
}
