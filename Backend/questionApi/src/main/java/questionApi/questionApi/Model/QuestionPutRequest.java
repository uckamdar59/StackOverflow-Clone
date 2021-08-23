package questionApi.questionApi.Model;

import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@NoArgsConstructor
@AllArgsConstructor
public @Data class QuestionPutRequest {


	private String title;

	private String body;

	private String tags;
}
