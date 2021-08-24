package Api.Api.Service;

import java.util.List;

import Api.Api.Entities.AnswerData;
import Api.Api.Model.AnswerPostRequest;
import Api.Api.Model.AnswerPostResponse;
import Api.Api.Model.AnswerPutRequest;
import Api.Api.Model.AnswerPutResponse;


public interface AnswerService {

	public List<AnswerData> getAnswers(String questionId);

	public AnswerData getAnswerById(String id);

	public AnswerPutResponse updateAnswer(String id, AnswerPutRequest request);

	public AnswerPostResponse addAnswer(AnswerPostRequest request);

}
