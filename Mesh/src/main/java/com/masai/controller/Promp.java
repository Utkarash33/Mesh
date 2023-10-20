package com.masai.controller;

public class Promp {

	
	private String prompt ;
	
	
	
	

	public Promp() {
		super();
		// TODO Auto-generated constructor stub
	}





	public String getPrompt() {
		return prompt;
	}





	public void setPrompt(String prompt) {
		this.prompt = prompt;
	}





	public Promp(String prompt) {
		super();
		this.prompt = prompt;
	}



	public String getPromptValue(String catagory)
	{
		String p = "";
		
		if(catagory.toLowerCase().equals("quote"))
		{
			return "Take a role a expert quote teller tell me a great quote around "+ prompt
					 + "only return the quote nothing else with max on 30 length like an interprator send ony the output for a code.";
		}
		else if(catagory.toLowerCase().equals("joke"))
		{
			return "Take a role a expert joke cracker tell me a funny joke around "+ prompt
					 + "only return the joke nothing else like an interprator send ony the output for a code.";
		}
		else
		{
			return "Take a role a expert shayar teller tell me a shayari around "+ prompt
					 + " in hindi only return the shayari nothing else like an interprator send ony the output for a code.";
		}
			
			
			 
	}
	
	
}
