package questionApi.questionApi.Model;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import questionApi.questionApi.Entities.QuestionData;

@NoArgsConstructor
@AllArgsConstructor
public @Data class QuestionPostResponse {

	private String questionId;
	private String title;

	private String body;
	

	private String username;
	

	private String tags;
	public Timestamp timestamp;
}
