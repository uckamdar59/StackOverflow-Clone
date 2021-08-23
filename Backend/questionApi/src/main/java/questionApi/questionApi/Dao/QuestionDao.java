package questionApi.questionApi.Dao;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import questionApi.questionApi.Entities.QuestionData;

@Repository
public interface QuestionDao extends JpaRepository< QuestionData, String> {
	//List<QuestionData> getAll(Pageable pageable);

}