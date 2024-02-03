package QMS.QMS_Project.service;

import QMS.QMS_Project.dtos.AuthRequest;
import QMS.QMS_Project.dtos.UserDTO;

public interface AuthService {
    UserDTO createUser(AuthRequest signupReq);
    Pair<Boolean,UserDTO> authenticateForLogin(String username, String password);
}
