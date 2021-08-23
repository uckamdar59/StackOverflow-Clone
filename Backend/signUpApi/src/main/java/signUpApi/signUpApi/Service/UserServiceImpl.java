package signUpApi.signUpApi.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import signUpApi.signUpApi.Dao.UserDao;
import signUpApi.signUpApi.Entitites.UserData;
import signUpApi.signUpApi.Exception.EntityNotFoundException;
import signUpApi.signUpApi.Model.UserPostRequest;

@Service
@Slf4j
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userDao;

	@Override
	public void addUser(UserPostRequest request) {

		UserData data = new UserData();

		data.setUsername(request.getUsername());
		data.setPassword(request.getPassword());

		try {
			userDao.save(data);
			log.info("User Data is saved");
		} catch (Exception ex) {
			log.error("User Data is not saved -----" + String.valueOf(ex));
			throw ex;
		}

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
