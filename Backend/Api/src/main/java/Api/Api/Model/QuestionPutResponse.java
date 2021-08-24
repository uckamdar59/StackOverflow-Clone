package Api.Api.Model;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;

import Api.Api.Entities.QuestionData;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@NoArgsConstructor
@AllArgsConstructor
public @Data class QuestionPutResponse {

	public String questionId;
	private String title;

	private String body;
	private String username;
	
	private String tags;
	public Timestamp timestamp;
	
		// TODO Auto-generated method stub
		
	
}
