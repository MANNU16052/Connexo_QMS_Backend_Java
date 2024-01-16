package QMS.QMS_Project.Controller;
import QMS.QMS_Project.dtos.SignupRequest;
import QMS.QMS_Project.dtos.UserDTO;
import QMS.QMS_Project.model.User;
import QMS.QMS_Project.service.AuthService;

import jakarta.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

 import org.springframework.web.bind.annotation.RestController;
public class SignupUserController{
    @Autowired
    private AuthService authService;
    

    @PostMapping("/register")
    public ResponseEntity<?> craeteUser(@RequestBody SignupRequest singnRequest){
        UserDTO createdUser = authService.createUser(singnRequest);
        if(createdUser == null)
            return new ResponseEntity<>("User is not Created , try again later", HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(createdUser,HttpStatus.CREATED);
    }
}
    

