package Api.Api.Service;

import java.util.List;

import Api.Api.Entities.QuestionData;
import Api.Api.Model.QuestionPostRequest;
import Api.Api.Model.QuestionPostResponse;
import Api.Api.Model.QuestionPutRequest;
import Api.Api.Model.QuestionPutResponse;

public interface QuestionService {

	public QuestionPostResponse addQuestion(QuestionPostRequest request);

	public List<QuestionData> getQuestions(String tags);

	public QuestionData getQuestionById(String id);

	public QuestionPutResponse updateQuestion(String id, QuestionPutRequest request);

}
