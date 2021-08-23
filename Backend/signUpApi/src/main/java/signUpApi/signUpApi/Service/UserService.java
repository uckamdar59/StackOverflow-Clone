package signUpApi.signUpApi.Service;

import java.util.List;

import signUpApi.signUpApi.Entitites.UserData;
import signUpApi.signUpApi.Model.UserPostRequest;

public interface UserService {
	public void addUser(UserPostRequest request);

	public List<UserData> getUsers();

	public UserData getUserById(String id);

}
