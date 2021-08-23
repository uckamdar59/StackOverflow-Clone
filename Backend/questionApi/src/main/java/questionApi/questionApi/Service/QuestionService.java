package questionApi.questionApi.Service;

import java.util.List;

import questionApi.questionApi.Entities.QuestionData;
import questionApi.questionApi.Model.QuestionPostRequest;
import questionApi.questionApi.Model.QuestionPostResponse;
import questionApi.questionApi.Model.QuestionPutRequest;
import questionApi.questionApi.Model.QuestionPutResponse;

public interface QuestionService {

	public QuestionPostResponse addQuestion(QuestionPostRequest request);

	public List<QuestionData> getQuestions(Integer pageNo);

	public QuestionData getQuestionById(String id);

	public QuestionPutResponse updateQuestion(String id, QuestionPutRequest request);

}
