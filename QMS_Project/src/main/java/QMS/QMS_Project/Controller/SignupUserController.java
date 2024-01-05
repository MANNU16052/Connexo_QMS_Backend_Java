package QMS.QMS_Project.Controller;
import QMS.QMS_Project.dtos.SignupRequest;
import QMS.QMS_Project.dtos.UserDTO;
import QMS.QMS_Project.model.DataField;
import QMS.QMS_Project.service.AuthService;
import QMS.QMS_Project.service.DataFieldService;
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

@RestController
public class SignupUserController{
    @Autowired
    private AuthService authService;
    
    @Autowired
	private DataFieldService datafieldservice;

    @PostMapping("/register")
    public ResponseEntity<?> craeteUser(@RequestBody SignupRequest singnRequest){
        UserDTO createdUser = authService.createUser(singnRequest);
        if(createdUser == null)
            return new ResponseEntity<>("User is not Created , try again later", HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(createdUser,HttpStatus.CREATED);
    }
    
    //Create DataField
    

	@PostMapping("/adddatafield")
	public  DataField createDataField(@RequestBody DataField datafield) {
		
		
		// session.setAttribute("msg","Award Add Sucessfully");
		return datafieldservice.AddDataField(datafield);
	}

	@GetMapping("/edit/{id}")
	public DataField editDataField(@PathVariable int id, Model m) {
		DataField e = datafieldservice.getDataFieldBy(id);
		m.addAttribute("datafield", e);
		return datafieldservice.get(id);
	}

	@PostMapping("/update")
	public String updateDataField(@ModelAttribute DataField e, HttpSession session) {
		session.setAttribute("msg", "Update sucessfully");
		datafieldservice.AddDataField(e);
		return "redirect:/";
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteDataField(@PathVariable int id, HttpSession session) {
		datafieldservice.deleteDataField(id);
		session.setAttribute("msg", "Delete Sucessfully");
		return ResponseEntity.ok("Delete Successfull");
	}

}
