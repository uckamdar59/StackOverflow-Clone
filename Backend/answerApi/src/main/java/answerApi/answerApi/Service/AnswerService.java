package answerApi.answerApi.Service;

import java.util.List;

import answerApi.answerApi.Entities.AnswerData;
import answerApi.answerApi.Model.AnswerPostRequest;
import answerApi.answerApi.Model.AnswerPostResponse;
import answerApi.answerApi.Model.AnswerPutRequest;
import answerApi.answerApi.Model.AnswerPutResponse;

public interface AnswerService {

	public List<AnswerData> getAnswers();

	public AnswerData getAnswerById(String id);

	public AnswerPutResponse updateAnswer(String id, AnswerPutRequest request);

	public AnswerPostResponse addAnswer(AnswerPostRequest request);

}
