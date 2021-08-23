package questionApi.questionApi.Controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import questionApi.questionApi.Entities.QuestionData;
import questionApi.questionApi.Exception.EntityNotFoundException;
import questionApi.questionApi.Model.QuestionPostRequest;
import questionApi.questionApi.Model.QuestionPostResponse;
import questionApi.questionApi.Model.QuestionPutRequest;
import questionApi.questionApi.Model.QuestionPutResponse;
import questionApi.questionApi.Service.QuestionService;

@RestController
@Slf4j
public class QuestionController {

	@Autowired
	private QuestionService questionService;

	@GetMapping("/questions")
	public ResponseEntity<List<QuestionData>> getQuestions(Integer pageNo) throws EntityNotFoundException {
		log.info("Get with Params Controller Started");
		return new ResponseEntity<>(questionService.getQuestions(pageNo), HttpStatus.OK);
	}

	@GetMapping("/question/{questionId}")
	public ResponseEntity<QuestionData> getQuestionById(@PathVariable String questionId) throws EntityNotFoundException {
		log.info("Get Controller Started");
		return new ResponseEntity<>(questionService.getQuestionById(questionId), HttpStatus.OK);
	}

	@PostMapping("/question")
	public ResponseEntity<QuestionPostResponse> addQuestion(@Valid @RequestBody QuestionPostRequest questionPostRequest) {

		log.info("Post Controller Started");
		
		return new ResponseEntity<>(questionService.addQuestion(questionPostRequest), HttpStatus.CREATED);
	}

	
	@PutMapping("/question/{questionId}")
	public ResponseEntity<QuestionPutResponse> updateQuestion(@PathVariable String questionId,@Valid @RequestBody QuestionPutRequest questionPutRequest) {

		log.info("Put Controller Started");
		
		return new ResponseEntity<>(questionService.updateQuestion(questionId,questionPutRequest), HttpStatus.OK);
	}

}
