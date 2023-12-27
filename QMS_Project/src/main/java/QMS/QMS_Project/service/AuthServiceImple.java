package QMS.QMS_Project.service;

import QMS.QMS_Project.Repository.UserRepository;
import QMS.QMS_Project.dtos.SignupRequest;
import QMS.QMS_Project.dtos.UserDTO;
import QMS.QMS_Project.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImple implements AuthService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDTO createUser(SignupRequest singnRequest) {
        User user = new User();
        user.setUsername(singnRequest.getUsername());
        user.setEmail(singnRequest.getEmail());
        user.setPassword(new BCryptPasswordEncoder().encode(singnRequest.getPassword()));
        User createdUser = userRepository.save(user);
        UserDTO userDTO = new UserDTO();
        userDTO.setId(createdUser.getId());
        userDTO.setEmail(createdUser.getEmail());
        userDTO.setUsername(createdUser.getUsername());
        return userDTO;
    }
}
