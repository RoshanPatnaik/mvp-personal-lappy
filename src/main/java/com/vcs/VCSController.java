package com.vcs;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;




@RestController
@RequestMapping("/vcs")
//@CrossOrigin(origins = "http://localhost:8080/")
public class VCSController{
	
	private int customerKey;
	
	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private MyUserDetails myUserDetails;
	
	@Autowired
	private CardService cardService;
	
	@GetMapping("/card")
	public ModelAndView homepage(ModelMap modelMap, @RequestParam("userName") String userName) {
	 
	 customerKey = customerService.getCustomerKey(userName);	
	 Card card = cardService.getCard(customerKey);
	 modelMap.put("userName", userName);
	 modelMap.put("card", card);
	 return new ModelAndView("cards");
	 //return key;
		
	}
	
	
	
	
	@GetMapping("/login")
	public ModelAndView loginPage(){
		return new ModelAndView("login1");

	}
	
	@PostMapping("/login")
	public ModelAndView addCustomer(@RequestParam("dob") String dob, @RequestParam("name") String name, @RequestParam("userName") String userName, @RequestParam("password") String password, @RequestParam("address") String address, @RequestParam("email") String email, @RequestParam("country") String country, @RequestParam("state") String state, @RequestParam("Pan") String pan, @RequestParam("phoneNo") long phoneNo, @RequestParam("accountType") String accountType) {
		Customer customer = new Customer();
		customer.setName(name);
		customer.setUserName(userName);
		customer.setPassword(password);
		customer.setAddress(address);
		customer.setEmail(email);
		customer.setCountry(country);
		customer.setState(state);
		customer.setPan(pan);
		customer.setPhoneNo(phoneNo);
		customer.setDob(LocalDate.parse(dob));
		customer.setAccountType(accountType);
		customerService.saveCustomer(customer);
		return new ModelAndView("/login1");
		
	}
	
	@GetMapping("/registration")
	public ModelAndView register() {
		return new ModelAndView("RegistrationPage");
	}
	
	
	@GetMapping("/welcome")
	public ModelAndView welcomePage(Model model, @RequestParam("username") String userName, @RequestParam("password") String password) {
		Boolean validCreds = customerService.testUser(userName,password);
		if(validCreds) {
			model.addAttribute("name", userName);
			return new ModelAndView("welcome");
		}
		return new ModelAndView("loginfailed");
	}
	
	@GetMapping("/redirectToWelcome")
	public ModelAndView welcomePage(Model model, @RequestParam("userName") String userName) {
		Boolean userExists = customerService.userExists(userName);
		if(userExists) {
			model.addAttribute("name", userName);
			return new ModelAndView("welcome");
		}
		return new ModelAndView("loginfailed");
	}
	
	
//	@GetMapping("/")
//	public ModelAndView welcomePage(Model model) {
//		System.out.println();
//		MyUserDetails details = (MyUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//		key = details.getCustomerKey();
//		String customerName = service.getAllCustomers().stream().filter(customer -> customer.getCustomerKey()==key).collect(Collectors.toList()).get(0).getName();
//		model.addAttribute("name", customerName);
//		return new ModelAndView("welcome");
//	}
//	
////	@GetMapping("/logout")
////	public String logout() {
////		SecurityContextHolder.clearContext();
////		return "Logout Successful";
////	}
//	
//	@RequestMapping(value="/logout", method=RequestMethod.GET)  
//    public String logoutPage(HttpServletRequest request, HttpServletResponse response) {  
//        Authentication auth = SecurityContextHolder.getContext().getAuthentication();  
//        if (auth != null){      
//           new SecurityContextLogoutHandler().logout(request, response, auth);  
//        }  
//         return "Logout Successful";  
//     }  
	
//	@GetMapping("/home/{key}")
//	public int afterLogin(@PathVariable("key")String key) {
//		int customerKey=Integer.parseInt(key);
//		return customerKey;
//	}
	
//	@GetMapping("/{key}")
//	public List<Customer> getAllCustomers(){
//		return service.getAllCustomers();
//	}
	
//	@RequestMapping("/vcs")
//	public String hello() {
//		return "Hello World";
//	}
//	
//    @RequestMapping("/error")
//    @ResponseBody
//    public String getErrorPath() {
//        return "No Mapping Found";
//    }
	
}
