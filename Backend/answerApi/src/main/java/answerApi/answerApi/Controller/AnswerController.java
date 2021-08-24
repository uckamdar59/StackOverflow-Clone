package answerApi.answerApi.Controller;

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

import answerApi.answerApi.Entities.AnswerData;
import answerApi.answerApi.Exception.EntityNotFoundException;
import answerApi.answerApi.Model.AnswerPostRequest;
import answerApi.answerApi.Model.AnswerPostResponse;
import answerApi.answerApi.Model.AnswerPutRequest;
import answerApi.answerApi.Model.AnswerPutResponse;
import answerApi.answerApi.Service.AnswerService;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class AnswerController {

	@Autowired
	private AnswerService answerService;

	@GetMapping("/answers")
	public ResponseEntity<List<AnswerData>> getAnswers() throws EntityNotFoundException {
		log.info("Get with Params Controller Started");
		return new ResponseEntity<>(answerService.getAnswers(), HttpStatus.OK);
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

}
