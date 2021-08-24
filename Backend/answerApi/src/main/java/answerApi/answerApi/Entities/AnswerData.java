package answerApi.answerApi.Entities;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
public @Data class AnswerData {

	@Id
	private String ansId;

	@NotBlank(message = "questionId Cannot Be Empty")
	private String questionId;

	@NotBlank(message = "Answer Cannot Be Empty")
	private String ans;

	@NotBlank(message = "Username Cannot Be Empty")
	private String username;
	
	@Column(nullable = false, columnDefinition = "BOOLEAN DEFAULT FALSE")
	private boolean correctAns;

	@CreationTimestamp
	public Timestamp timestamp;
}
