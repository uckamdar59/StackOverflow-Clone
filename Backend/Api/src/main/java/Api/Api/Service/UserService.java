package Api.Api.Service;

import java.util.List;

import Api.Api.Entities.UserData;
import Api.Api.Model.UserPostRequest;
import Api.Api.Model.UserPostResponse;



public interface UserService {
	
	public UserPostResponse addUser(UserPostRequest request);

	public List<UserData> getUsers();

	public UserData getUserById(String id);

}
