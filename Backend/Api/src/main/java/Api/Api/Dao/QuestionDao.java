package Api.Api.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import Api.Api.Entities.QuestionData;

@Repository
public interface QuestionDao extends JpaRepository<QuestionData, String> {
	// List<QuestionData> getAll(Pageable pageable);

	@Query("SELECT u FROM QuestionData u WHERE u.body LIKE %:tags% or u.title LIKE %:tags% ")
	public List<QuestionData> findByTags(@Param("tags") String tags);
	
}