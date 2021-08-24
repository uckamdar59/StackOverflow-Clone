package Api.Api.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Api.Api.Entities.AnswerData;
import org.springframework.data.domain.Sort;


@Repository
public interface AnswerDao extends JpaRepository<AnswerData, String> {
	
	 	public List<AnswerData> findByQuestionId(String questionId, Sort s);
}