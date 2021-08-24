package answerApi.answerApi.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import answerApi.answerApi.Entities.AnswerData;

@Repository
public interface AnswerDao extends JpaRepository<AnswerData, String> {
	// List<QuestionData> getAll(Pageable pageable);

}