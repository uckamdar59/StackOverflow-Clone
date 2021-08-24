package Api.Api.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import Api.Api.Dao.UserDao;
import Api.Api.Entities.UserData;
import Api.Api.Exception.EntityNotFoundException;
import Api.Api.Model.UserPostRequest;
import Api.Api.Model.UserPostResponse;

@Service
@Slf4j
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userDao;

	@Override
	public UserPostResponse addUser(UserPostRequest request) {

		UserData data = new UserData();
		UserPostResponse response = new UserPostResponse();
		
		data.setUsername(request.getUsername());
		data.setPassword(request.getPassword());

		if( String.valueOf(userDao.findById(request.getUsername())) != "Optional.empty") {
			System.err.println(userDao.findById(request.getUsername()));
			response.setStatus("Already exist");
			response.setUsername(data.getUsername());
			return response;
		}
		
		try {
			userDao.save(data);
			log.info("User Data is saved");
		} catch (Exception ex) {
			log.error("User Data is not saved -----" + String.valueOf(ex));
			throw ex;
		}
		response.setStatus("Successfully Created");
		response.setUsername(data.getUsername());
		
		return response;
	}

	@Override
	public List<UserData> getUsers() {
		// TODO Auto-generated method stub

		List<UserData> list = null;

		try {

			list = userDao.findAll();
			log.info("User Data get all returned");
			return list;
		} catch (Exception ex) {
			log.error("User Data get all not returned -----" + String.valueOf(ex));
			throw ex;
		}

	}

	@Override
	public UserData getUserById(String id) {
		UserData data = userDao.findById(id).orElse(null);

		if (data == null) {
			EntityNotFoundException ex = new EntityNotFoundException(UserData.class, "username", id.toString());
			log.error(String.valueOf(ex));
			throw ex;

		}
		try {

			log.info("User Data returned");
			return data;
		} catch (Exception ex) {
			log.error("User Data not returned -----" + String.valueOf(ex));
			throw ex;

		}
	}

}
