package za.co.sqldb.interfaces;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import za.co.sqldb.model.PhoneBook;

public interface IPhoneBook {
	
    public String setupForm(Model model);
    
    public String searchPhoneBookEntry(Model model);

	public String submitForm(@ModelAttribute("phonebook") PhoneBook pb,BindingResult result, SessionStatus status);
	
	public ModelAndView viewPhoneBook(@ModelAttribute("phonebook") PhoneBook pb, BindingResult result, SessionStatus status);
	
}
