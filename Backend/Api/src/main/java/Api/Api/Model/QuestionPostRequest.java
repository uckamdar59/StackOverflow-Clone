package Api.Api.Model;

import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public @Data class QuestionPostRequest {

	private String title;

	private String body;

	private String username;

	private String tags;
}
