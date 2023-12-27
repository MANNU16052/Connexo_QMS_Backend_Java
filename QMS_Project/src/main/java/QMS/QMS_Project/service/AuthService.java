package QMS.QMS_Project.service;

import QMS.QMS_Project.dtos.SignupRequest;
import QMS.QMS_Project.dtos.UserDTO;

public interface AuthService {
    UserDTO createUser(SignupRequest singnRequest);
}
