package Api.Api.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public @Data class AnswerPutRequest {

	private String ans;
	private boolean correctAns;
}
