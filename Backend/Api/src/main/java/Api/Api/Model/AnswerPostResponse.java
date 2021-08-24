package Api.Api.Model;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public @Data class AnswerPostResponse {

	private String ansId;
	private String questionId;

	private String ans;

	private String username;
	private boolean correctAns;


	public Timestamp timestamp;
}
