package Api.Api.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public @Data class AnswerPostRequest {

	private String questionId;
	private String ans;
	private String username;
}
