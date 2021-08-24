package Api.Api.Service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import Api.Api.Dao.QuestionDao;
import Api.Api.Entities.QuestionData;
import Api.Api.Exception.EntityNotFoundException;
import Api.Api.Model.QuestionPostRequest;
import Api.Api.Model.QuestionPostResponse;
import Api.Api.Model.QuestionPutRequest;
import Api.Api.Model.QuestionPutResponse;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class QuestionServiceImpl  implements QuestionService{
	
	@Autowired
	private QuestionDao questionDao;
	
	@Override
	public QuestionPostResponse addQuestion(QuestionPostRequest request) {

		QuestionData data = new QuestionData();
		QuestionPostResponse response=new QuestionPostResponse();

		String id = "questionId:" + UUID.randomUUID();

		data.setQuestionId(id);

		data.setTitle(request.getTitle());
		data.setBody(request.getBody());
		data.setUsername(request.getUsername());
		
		if (request.getTags()!= null) {
			data.setTags(request.getTags());
		}
		
		
		response.setQuestionId(id);
		response.setBody(data.getBody());
		response.setTitle(data.getTitle());
		response.setUsername(data.getUsername());
		response.setTags(data.getTags());
		

		try {
			questionDao.save(data);
			log.info("Question Data is saved");
		} catch (Exception ex) {
			log.error("Question Data is not saved -----" + String.valueOf(ex));
			throw ex;
		}
		
		response.setTimestamp(data.getTimestamp());
		
		return response;

	}


	@Override
	public List<QuestionData> getQuestions(String tags) {
		// TODO Auto-generated method stub
		log.info("getLoads service with params started");
		Sort s=Sort.by( Sort.Direction.DESC, "timestamp");

		List<QuestionData> list = null;

		if(tags!=null) {
			list=questionDao.findByTags(tags);
			return list;
		}
		//Pageable currentPage = PageRequest.of( Sort.Direction.DESC, "timestamp");
		

		try {

			list = questionDao.findAll(s);
			log.info("User Data get all returned");
			return list;
		} catch (Exception ex) {
			log.error("User Data get all not returned -----" + String.valueOf(ex));
			throw ex;
		}

	}

	
	@Override
	public QuestionData getQuestionById(String id) {
		QuestionData data = questionDao.findById(id).orElse(null);

		if (data == null) {
			EntityNotFoundException ex = new EntityNotFoundException(QuestionData.class, "questionId", id.toString());
			log.error(String.valueOf(ex));
			throw ex;

		}
		
		try {

			log.info("Question Data returned");
			return data;
		} catch (Exception ex) {
			log.error("Question Data not returned -----" + String.valueOf(ex));
			throw ex;

		}
	}
	

	@Override
	public QuestionPutResponse updateQuestion(String id,QuestionPutRequest request) {
		
		QuestionPutResponse response = new QuestionPutResponse();
		QuestionData data = questionDao.findById(id).orElse(null);

		if (data == null) {
			EntityNotFoundException ex = new EntityNotFoundException(QuestionData.class, "questionId", id.toString());
			log.error(String.valueOf(ex));
			throw ex;

		}
		
		if(request.getBody()!=null) {
			data.setBody(request.getBody());
		}
		
		if(request.getTitle()!=null) {
			data.setTitle(request.getTitle());
		}
		
		if(request.getTags()!=null) {
			data.setTags(request.getTags());
		}
		
		
		response.setQuestionId(id);
		response.setBody(data.getBody());
		response.setTitle(data.getTitle());
		response.setUsername(data.getUsername());
		response.setTags(data.getTags());
		response.setTimestamp(data.getTimestamp());
		
		try {
			questionDao.save(data);
			log.info("Question Data is updated");
		} catch (Exception ex) {
			log.error("Question Data is not updated -----" + String.valueOf(ex));
			throw ex;
		}
	
		return response;
	}
}
