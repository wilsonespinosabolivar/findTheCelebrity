package com.Globant.controller;

import java.io.FileNotFoundException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.Globant.beans.Celebrity;
import com.Globant.model.GetDataSize;
import com.Globant.model.PopulateData;
import com.Globant.operation.FindCelebrity;

@Controller
public class loadController {

	@RequestMapping("findCelebrity")
	public ModelAndView redirectTo() {
		ModelAndView mv = new ModelAndView("findCelebrity","message", "A celebrity is sitting at a place on the table, discover who is ?");
		return mv;
	}
	
	@RequestMapping(value = "/aftermath", method= { RequestMethod.GET, RequestMethod.POST})
	public String find(Celebrity celb, ModelMap model) throws FileNotFoundException {
//		ApplicationContext appContext = new AnnotationConfigApplicationContext(AppConfig.class);
//		Celebrity celb = (Celebrity) appContext.getBean("celebrity");
		
		GetDataSize getDataSize = new GetDataSize();
		getDataSize.dataSize();
		
		PopulateData data = new PopulateData(getDataSize.getRows(),getDataSize.getColums());

		celb.setCelebrityis(new FindCelebrity().findCelebrity(data.payload()));
		
		switch(celb.getCelebrityis()) {
		   case -1 :
			   model.addAttribute("message", "There is no celebrity!!");
		      break;		   
		   case 0 :
			   model.addAttribute("message", "They are all celebrities!!");
		      break;		  
		   default : 
			   model.addAttribute("message", "The celebrity is sitting in the place number?");
		}
				
		model.addAttribute("celebrityis", celb.getCelebrityis());
		return "aftermath";
	}
}
