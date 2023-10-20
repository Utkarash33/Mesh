package com.masai.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.masai.service.UserService;
import com.theokanning.openai.completion.chat.ChatCompletionRequest;
import com.theokanning.openai.completion.chat.ChatMessage;
import com.theokanning.openai.service.OpenAiService;

@RestController
public class OutputController {

	
	  @Value("${openai.api.chat.default.role}")
	  private String defaultRole;
	
	
	@Autowired
	private UserService userService;
	
	
	
	@PostMapping("/hi/{output}")
	public ResponseEntity<String> chatResponse(@PathVariable String output , @RequestBody Promp pg)
	{
		
		   String prompt = pg.getPromptValue(output);
		   
		  final OpenAiService service = userService.getOpenAiService();
	      final ChatCompletionRequest chatRequest = userService.getChatCompletionRequest(List.of(new ChatMessage(defaultRole, prompt)));
	     String s = service.createChatCompletion(chatRequest).getChoices().get(0).getMessage().getContent();
	    
		return new ResponseEntity<>(s,HttpStatus.OK);
	}
	
}
