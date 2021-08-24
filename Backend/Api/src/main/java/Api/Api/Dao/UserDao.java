package Api.Api.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Api.Api.Entities.UserData;



@Repository
public interface UserDao extends JpaRepository<UserData, String> {

}
