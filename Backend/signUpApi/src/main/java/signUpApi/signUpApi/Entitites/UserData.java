package signUpApi.signUpApi.Entitites;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Pattern;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Entity
public @Data class UserData {

	@Id
	private String username;

	@Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$", message = "Please enter a valid password")
	private String password;

}
