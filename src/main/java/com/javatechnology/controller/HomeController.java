package com.javatechnology.controller;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.javatechnology.controller.dao.Login;
import com.javatechnology.controller.dao.Register;

@SuppressWarnings("unused")
@Controller
public class HomeController {
	
	@Autowired
	private HomeService homeService;
	
	@RequestMapping(value= "/")
	public String showHomePage() {
		return "home";
	}
	@RequestMapping("/login")
	public String showLoginPage(@ModelAttribute("login") Login login) {
		return "login";
	}
	@RequestMapping("/loginProcess")
	public ModelAndView processUserPassword(@ModelAttribute("login") Login login) {
		System.out.println("called loginProcess method");
		String message=homeService.validateUserPassword(login);
		ModelAndView view=new ModelAndView("home");
		view.addObject("result", message);
		return view;
		
	}
	@RequestMapping("/register")
	public String registerUserInformation(@ModelAttribute("register") Register register) {
		
		return "register";
	}
	@RequestMapping(method=RequestMethod.POST,value="/registerProcess")
	public ModelAndView registerProcess(@Valid @ModelAttribute("register") 
	Register register,BindingResult bindingResult,MultipartHttpServletRequest request,@RequestParam("data") MultipartFile[] file){
		System.out.println("called register method");
		ModelAndView view=new ModelAndView("home");
		/*if(bindingResult.hasErrors())
			return view;*/
		/*if(file.length>0) {
			try {
				for (MultipartFile multipartFile : file) {
					validateFile(multipartFile);
					register.setData(multipartFile.getBytes());
					homeService.insertUserInfo(register);
				}
				
				
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}*/
		homeService.insertUserInfo(register);
		return view;
	}
	//GET, POST, PUT, DELETE
	/*@SuppressWarnings("unused")
	@RequestMapping(value="/getRegisters",method=RequestMethod.GET)
	public @ResponseBody List<Register> getRegisters() {
		return homeService.getRegisters();
		
	}*/
	@RequestMapping(value="/getRegisters/{id}",method=RequestMethod.PUT)
	public @ResponseBody Register getRegisters(@PathVariable("id") long id) {
		
		Register register=homeService.updateRegiser(id);
		register.setEmail("put@gmail.com");
		homeService.insertUserInfo(register);
		return register;
	}
	@RequestMapping(value="/insertRegister",method=RequestMethod.POST)
	public String insertRegister(@RequestBody Register register) {
		homeService.insertUserInfo(register);
		return "home";
	}
	@RequestMapping(value="/deleteRegister/{id}",method=RequestMethod.DELETE)
	public String deleteRegister(@PathVariable("id") long id) {
		homeService.deleteRegister(id);
		return "home";
	}
	
	
	
	
	
	private void validateFile(MultipartFile file) {
		if(!file.getContentType().equals("image/png"))
			throw new RuntimeException("try to add .png.extension");
		
	}
	@RequestMapping(method=RequestMethod.POST,value="/savefile")
	public ModelAndView saveFile(@RequestParam MultipartFile file,HttpSession session) {
		String path=session.getServletContext().getRealPath("/");  
        String filename=((MultipartFile) file).getOriginalFilename();  
        ModelAndView view=new ModelAndView("home");
        System.out.println(path+" "+filename);  
        try{  
        byte barr[]=((MultipartFile) file).getBytes();  
          
        BufferedOutputStream bout=new BufferedOutputStream(  
                 new FileOutputStream(path+"/"+filename));  
        bout.write(barr);  
        bout.flush();  
        bout.close();  
		view.addObject("result", "message");
		
	}catch(Exception e){
		System.out.println(e);
	}  
        return view;
	}
		
}
