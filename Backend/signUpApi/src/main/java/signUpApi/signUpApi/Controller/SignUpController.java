package signUpApi.signUpApi.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import signUpApi.signUpApi.Entitites.UserData;
import signUpApi.signUpApi.Exception.EntityNotFoundException;
import signUpApi.signUpApi.Model.UserPostRequest;
import signUpApi.signUpApi.Service.UserService;

@RestController
@Slf4j
public class SignUpController {

	@Autowired
	private UserService userService;

	@GetMapping("/signup")
	public ResponseEntity<List<UserData>> getBid() throws EntityNotFoundException {
		log.info("Get with Params Controller Started");
		return new ResponseEntity<>(userService.getUsers(), HttpStatus.OK);
	}

	@GetMapping("/signup/{username}")
	public ResponseEntity<UserData> getBidById(@PathVariable String Id) throws EntityNotFoundException {
		log.info("Get Controller Started");
		return new ResponseEntity<>(userService.getUserById(Id), HttpStatus.OK);
	}

	@PostMapping("/signup")
	public ResponseEntity<Object> addBid(@RequestBody UserPostRequest userPostRequest) {

		log.info("Post Controller Started");
		userService.addUser(userPostRequest);
		return new ResponseEntity<>("Successfully Created", HttpStatus.CREATED);
	}

}
