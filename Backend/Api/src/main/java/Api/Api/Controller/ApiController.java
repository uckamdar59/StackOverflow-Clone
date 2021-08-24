package Api.Api.Controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import Api.Api.Entities.AnswerData;
import Api.Api.Entities.QuestionData;
import Api.Api.Entities.UserData;
import Api.Api.Exception.EntityNotFoundException;
import Api.Api.Model.AnswerPostRequest;
import Api.Api.Model.AnswerPostResponse;
import Api.Api.Model.AnswerPutRequest;
import Api.Api.Model.AnswerPutResponse;
import Api.Api.Model.QuestionPostRequest;
import Api.Api.Model.QuestionPostResponse;
import Api.Api.Model.QuestionPutRequest;
import Api.Api.Model.QuestionPutResponse;
import Api.Api.Model.UserPostRequest;
import Api.Api.Service.AnswerService;
import Api.Api.Service.QuestionService;
import Api.Api.Service.UserService;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@CrossOrigin
public class ApiController {

	@Autowired
	private QuestionService questionService;

	@GetMapping("/questions")
	public ResponseEntity<List<QuestionData>> getQuestions(@RequestParam(value = "tags", required = false) String tags)
			throws EntityNotFoundException {
		log.info("Get with Params Controller Started");
		return new ResponseEntity<>(questionService.getQuestions(tags), HttpStatus.OK);
	}

	@GetMapping("/question/{questionId}")
	public ResponseEntity<QuestionData> getQuestionById(@PathVariable String questionId)
			throws EntityNotFoundException {
		log.info("Get Controller Started");
		return new ResponseEntity<>(questionService.getQuestionById(questionId), HttpStatus.OK);
	}

	@PostMapping("/question")
	public ResponseEntity<QuestionPostResponse> addQuestion(
			@Valid @RequestBody QuestionPostRequest questionPostRequest) {

		log.info("Post Controller Started");

		return new ResponseEntity<>(questionService.addQuestion(questionPostRequest), HttpStatus.CREATED);
	}

	@PutMapping("/question/{questionId}")
	public ResponseEntity<QuestionPutResponse> updateQuestion(@PathVariable String questionId,
			@Valid @RequestBody QuestionPutRequest questionPutRequest) {

		log.info("Put Controller Started");

		return new ResponseEntity<>(questionService.updateQuestion(questionId, questionPutRequest), HttpStatus.OK);
	}

	@Autowired
	private AnswerService answerService;

	@GetMapping("/answers")
	public ResponseEntity<List<AnswerData>> getAnswers(
			@RequestParam(value = "questionId", required = false) String questionId) throws EntityNotFoundException {
		log.info("Get with Params Controller Started");
		return new ResponseEntity<>(answerService.getAnswers(questionId), HttpStatus.OK);
	}

	@GetMapping("/answer/{ansId}")
	public ResponseEntity<AnswerData> getAnswerById(@PathVariable String ansId) throws EntityNotFoundException {
		log.info("Get Controller Started");
		return new ResponseEntity<>(answerService.getAnswerById(ansId), HttpStatus.OK);
	}

	@PostMapping("/answer")
	public ResponseEntity<AnswerPostResponse> addAnswer(@Valid @RequestBody AnswerPostRequest answerPostRequest) {

		log.info("Post Controller Started");

		return new ResponseEntity<>(answerService.addAnswer(answerPostRequest), HttpStatus.CREATED);
	}

	@PutMapping("/answer/{ansId}")
	public ResponseEntity<AnswerPutResponse> updateAnswer(@PathVariable String ansId,
			@Valid @RequestBody AnswerPutRequest answerPutRequest) {

		log.info("Put Controller Started");

		return new ResponseEntity<>(answerService.updateAnswer(ansId, answerPutRequest), HttpStatus.OK);
	}

	@Autowired
	private UserService userService;

	@GetMapping("/signup")
	public ResponseEntity<List<UserData>> getBid() throws EntityNotFoundException {
		log.info("Get with Params Controller Started");
		return new ResponseEntity<>(userService.getUsers(), HttpStatus.OK);
	}

	@GetMapping("/signup/{username}")
	public ResponseEntity<UserData> getBidById(@PathVariable String Id) throws EntityNotFoundException {
		log.info("Get Controller Started");
		return new ResponseEntity<>(userService.getUserById(Id), HttpStatus.OK);
	}

	@PostMapping("/signup")
	public ResponseEntity<Object> addBid(@RequestBody UserPostRequest userPostRequest) {

		log.info("Post Controller Started");
		userService.addUser(userPostRequest);
		return new ResponseEntity<>("Successfully Created", HttpStatus.CREATED);
	}

}
