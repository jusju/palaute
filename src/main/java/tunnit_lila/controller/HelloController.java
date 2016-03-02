package tunnit_lila.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.ModelMap;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping ("hello")
public class HelloController {

	
	@RequestMapping (value="/index", method = RequestMethod.GET)
	public String index(ModelMap model){
		model.addAttribute("message", "Moro moro");
		return "hello";
}
}