package QMS.QMS_Project.Controller;
import QMS.QMS_Project.dtos.AuthRequest;
import QMS.QMS_Project.dtos.UserDTO;

import QMS.QMS_Project.model.response.auth.LoginData;
import QMS.QMS_Project.model.response.auth.LoginResponse;
import QMS.QMS_Project.service.AuthService;
import QMS.QMS_Project.service.Pair;
import QMS.QMS_Project.util.JwtUtil;
import org.apache.commons.logging.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class AuthenticationController {
    @Autowired
    private AuthService authService;

    @Autowired
    private JwtUtil jwtUtil;

  

    @PostMapping("/register")
    public ResponseEntity<?> createUser(@RequestBody AuthRequest singnRequest){
        UserDTO createdUser = authService.createUser(singnRequest);
        if(createdUser == null)
            return new ResponseEntity<>("User is not Created , try again later", HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(createdUser,HttpStatus.CREATED);
    }

    @PostMapping("/authenticate")
    public ResponseEntity<String> login(@RequestBody AuthRequest loginReq) {
        String username = loginReq.getUsername();
        String password = loginReq.getPassword();
        // Validate user credentials

        Pair<Boolean,UserDTO> data = authService.authenticateForLogin(username, password);
        if (data.first) {
            String token = jwtUtil.generateToken(username);
            LoginData loginData = new LoginData(token,String.valueOf(jwtUtil.getExpiration()),data.second.getUsername(),data.second.getEmail());
            LoginResponse response = new LoginResponse( true ,"200", loginData);
            return ResponseEntity.ok(response.toString());
        } else {
            LoginResponse response = new LoginResponse( false ,"401", null);
            return ResponseEntity.ok(response.toString());
           // return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }


}
