package Api.Api.Service;

import java.util.List;

import Api.Api.Entities.UserData;
import Api.Api.Model.UserPostRequest;



public interface UserService {
	public void addUser(UserPostRequest request);

	public List<UserData> getUsers();

	public UserData getUserById(String id);

}
