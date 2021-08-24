package kr.ac.mlec.method;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/method/method.do")
public class MethodController {
	
//	@RequestMapping(value="/method/method.do", method=RequestMethod.GET)
	@RequestMapping(method=RequestMethod.GET)
	public String callGet() {
		return "method/methodForm";
	}

//	@RequestMapping(value = "/method/method.do", method = RequestMethod.POST)
	@RequestMapping(method = RequestMethod.POST)
	public String callPost() {
		return "method/methodProcess";
	}
}
