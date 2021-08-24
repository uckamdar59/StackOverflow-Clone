package Api.Api.Service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import Api.Api.Dao.AnswerDao;
import Api.Api.Entities.AnswerData;
import Api.Api.Model.AnswerPostRequest;
import Api.Api.Model.AnswerPostResponse;
import Api.Api.Model.AnswerPutRequest;
import Api.Api.Model.AnswerPutResponse;
import Api.Api.Exception.EntityNotFoundException;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class AnswerServiceImpl implements AnswerService {

	@Autowired
	private AnswerDao answerDao;

	@Override
	public AnswerPostResponse addAnswer(AnswerPostRequest request) {

		AnswerData data = new AnswerData();
		AnswerPostResponse response = new AnswerPostResponse();

		String id = "ansId:" + UUID.randomUUID();

		data.setAnsId(id);

		data.setAns(request.getAns());
		data.setQuestionId(request.getQuestionId());
		data.setUsername(request.getUsername());

		response.setAnsId(id);
		response.setAns(data.getAns());
		response.setQuestionId(data.getQuestionId());
		response.setUsername(data.getUsername());

		try {
			answerDao.save(data);
			log.info("Answer Data is saved");
		} catch (Exception ex) {
			log.error("Answer Data is not saved -----" + String.valueOf(ex));
			throw ex;
		}

		response.setTimestamp(data.getTimestamp());

		return response;

	}

	@Override
	public List<AnswerData> getAnswers(String questionId) {
		// TODO Auto-generated method stub
		log.info("getLoads service with params started");

		Sort s = Sort.by(Sort.Direction.DESC, "timestamp");
		List<AnswerData> list = null;

		if(questionId!=null) {
			list=answerDao.findByQuestionId(questionId,s);
			return list;
		}
		
		try {

			list = answerDao.findAll(s);
			log.info("Answer Data get all returned");
			return list;
		} catch (Exception ex) {
			log.error("Answer Data get all not returned -----" + String.valueOf(ex));
			throw ex;
		}

	}

	@Override
	public AnswerData getAnswerById(String id) {
		AnswerData data = answerDao.findById(id).orElse(null);

		if (data == null) {
			EntityNotFoundException ex = new EntityNotFoundException(AnswerData.class, "ansId", id.toString());
			log.error(String.valueOf(ex));
			throw ex;

		}

		try {

			log.info("Answer Data returned");
			return data;
		} catch (Exception ex) {
			log.error("Answer Data not returned -----" + String.valueOf(ex));
			throw ex;

		}
	}

	@Override
	public AnswerPutResponse updateAnswer(String id, AnswerPutRequest request) {

		AnswerPutResponse response = new AnswerPutResponse();
		AnswerData data = answerDao.findById(id).orElse(null);

		if (data == null) {
			EntityNotFoundException ex = new EntityNotFoundException(AnswerData.class, "ansId", id.toString());
			log.error(String.valueOf(ex));
			throw ex;

		}

		if (request.getAns() != null) {
			data.setAns(request.getAns());
		}
		
		if ( request.isCorrectAns() ==  true) {
			data.setCorrectAns(request.isCorrectAns());
		}
		

		response.setAnsId(id);
		response.setAns(data.getAns());
		response.setCorrectAns(data.isCorrectAns());
		response.setQuestionId(data.getQuestionId());
		response.setUsername(data.getUsername());
		response.setTimestamp(data.getTimestamp());
		
		

		try {
			answerDao.save(data);
			log.info("Answer Data is updated");
		} catch (Exception ex) {
			log.error("Answer Data is not updated -----" + String.valueOf(ex));
			throw ex;
		}

		return response;
	}
}
