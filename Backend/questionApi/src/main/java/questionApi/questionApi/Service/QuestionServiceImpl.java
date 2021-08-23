package questionApi.questionApi.Service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


import lombok.extern.slf4j.Slf4j;
import questionApi.questionApi.Dao.QuestionDao;
import questionApi.questionApi.Entities.QuestionData;
import questionApi.questionApi.Model.QuestionPostRequest;
import questionApi.questionApi.Model.QuestionPostResponse;
import questionApi.questionApi.Model.QuestionPutRequest;
import questionApi.questionApi.Model.QuestionPutResponse;
import questionApi.questionApi.Exception.EntityNotFoundException;

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
	public List<QuestionData> getQuestions(Integer pageNo) {
		// TODO Auto-generated method stub
		log.info("getLoads service with params started");

		if (pageNo == null)
			pageNo = 0;

		//Pageable currentPage = PageRequest.of( Sort.Direction.DESC, "timestamp");
		Sort s=Sort.by( Sort.Direction.DESC, "timestamp");

		List<QuestionData> list = null;

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
