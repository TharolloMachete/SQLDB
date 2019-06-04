package za.co.sqldb.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;
import za.co.sqldb.db.impl.DatabaseControl;
import za.co.sqldb.interfaces.IPhoneBook;
import za.co.sqldb.model.PhoneBook;


@Controller
@SessionAttributes("phonebook")
public class PhoneBookController implements IPhoneBook{
	

	private String formView;
	private String successView;
	private Validator[] validators;

	@RequestMapping(method = RequestMethod.GET)
	public String setupForm(Model model) {
		// TODO Auto-generated method stub
		PhoneBook  pb = new PhoneBook();
		model.addAttribute("phonebook" , pb);
		return "phoneBookEntryAddForm";
	}

	@RequestMapping(value = "/searchPhoneBookEntry", method = RequestMethod.GET)
	public String searchPhoneBookEntry(Model model) {
		// TODO Auto-generated method stub
		PhoneBook  pb = new PhoneBook();
		model.addAttribute("phonebook" , pb);
		return "searchPhoneBookEntry";
	}
	

	@RequestMapping(value="/phoneBookEntryAddForm",method = RequestMethod.POST)
    public String submitForm(@ModelAttribute("phonebook") PhoneBook pb, BindingResult result, SessionStatus status)
    {
        //Validation code start
        boolean error = false;
         
        System.out.println(pb.toString()); //Verifying if information is same as input by user
         
        if(pb.getName().isEmpty()){
            result.rejectValue("name", "error.name");
            error = true;
        }
         
        if(pb.getPhoneNumber().isEmpty()){
            result.rejectValue("phoneNumber", "error.phoneNumber");
            error = true;
        }
         
        if(error) {
            return "phoneBookEntryAddForm";
        }
        
        //add the data to the database
        DatabaseControl dbc = new DatabaseControl();
        dbc.insertData(pb);
        
        //Mark Session Complete
        status.setComplete();
        return "phoneBookAddedSuccessful";
    }
	
	 @RequestMapping(value = "/phoneBookAddedSuccessful", method = RequestMethod.GET)
	 public String success(Model model)
	 {
	     return "phoneBookAddedSuccessful";
	 }

	@RequestMapping(value = "/searchPhoneBookEntry", method = RequestMethod.POST)
	public ModelAndView viewPhoneBook(@ModelAttribute("phonebook") PhoneBook pb, BindingResult result, SessionStatus status) {
		// TODO Auto-generated method stub

        boolean error = false;
        
		if(pb.getName().isEmpty()){
            result.rejectValue("name", "error.name");
            error  = true;
        }

        if(error) {
            return new ModelAndView("searchPhoneBookEntry");
        }
        
		 //view the data to the database
        DatabaseControl dbc = new DatabaseControl();
        pb.setPhoneBookList(dbc.viewData(pb.getName()));
        
		return new ModelAndView("viewPhoneBookEntry" ,"phonebook" , pb);
	}
	

	/**
	 * Set the name of the view that should be used for form display.
	 */
	public final void setFormView(String formView) {
		this.formView = formView;
	}

	/**
	 * Return the name of the view that should be used for form display.
	 */
	public final String getFormView() {
		return this.formView;
	}

	/**
	 * Set the name of the view that should be shown on successful submit.
	 */
	public final void setSuccessView(String successView) {
		this.successView = successView;
	}

	/**
	 * Return the name of the view that should be shown on successful submit.
	 */
	public final String getSuccessView() {
		return this.successView;
	}

	public final Validator getValidator() {
		return (this.validators != null && this.validators.length > 0 ? this.validators[0] : null);
	}
	public final void setValidator(Validator validator) {
		this.validators = new Validator[] {validator};
	}

	public void setValidators(Validator[] validators) {
		this.validators = validators;
	}

	public final Validator[] getValidators() {
		return this.validators;
	}


}
