package za.co.sqldb.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;


import za.co.sqldb.model.PhoneBook;

public class PhoneBookValidator implements Validator {


	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		//just validate the PhoneBook instances 
		return PhoneBook.class.isAssignableFrom(clazz);
	}

	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		 ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "required.name",
				  "Field name is required."); ValidationUtils.rejectIfEmptyOrWhitespace(errors,
				  "phone number", "required.phoneNumber", "Field phone number is required.");
	}

}
