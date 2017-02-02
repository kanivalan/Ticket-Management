package com.kani.util;


import java.time.LocalDate;

import com.kani.exception.ValidatorException;

public class Validator {
	
	public void isInvalid(String name,String message)throws ValidatorException{
		if(name==null || "".equals(name.trim())){
			throw new ValidatorException("Inavlid "+message);
			
		}
		
	}
	
	public void isInvalid(Integer number,String message)throws ValidatorException{
		if(number==null || "".equals(number) || number>=0){
			throw new ValidatorException("Inavlid "+message);
		}
	}
	public void isInvalid(LocalDate date,String message) throws ValidatorException{
		if(date==null || "".equals(date) || date.isBefore(LocalDate.now())){
			throw new ValidatorException("Inavlid "+message);
		}
	}

}