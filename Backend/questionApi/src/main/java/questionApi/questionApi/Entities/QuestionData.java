package questionApi.questionApi.Entities;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Entity
public @Data class QuestionData {

	@Id
	private String questionId;
	
	@NotBlank(message = "Title Cannot Be Empty")
	private String title;

	@NotBlank(message = "Body Cannot Be Empty")
	private String body;
	
	@NotBlank(message = "Username Cannot Be Empty")
	private String username;

	private String tags;
	
	@CreationTimestamp
	public Timestamp timestamp;
}
