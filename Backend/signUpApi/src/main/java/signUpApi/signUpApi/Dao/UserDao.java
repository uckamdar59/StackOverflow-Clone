package signUpApi.signUpApi.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import signUpApi.signUpApi.Entitites.UserData;

@Repository
public interface UserDao extends JpaRepository<UserData, String> {

}
