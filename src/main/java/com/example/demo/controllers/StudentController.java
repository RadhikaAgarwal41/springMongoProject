package com.example.demo.controllers;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.exception.ApiError;
import com.example.demo.exception.InvalidAge;
import com.example.demo.exception.StudentNotFound;
import com.example.demo.model.Student;
import com.example.demo.repositories.StudentRepository;

@RestController    ///this class serves as the controller for requests
public class StudentController {
	
	public String convert (String input)
	{
		String regex="[0-9]+";
		Pattern p=Pattern.compile(regex);
		Matcher m= p.matcher(input);
		if(m.matches())
			return input;
		
		
		
	    long result = 0;
	    long finalResult = 0;
	        
	        
	    List<String> allowedStrings = Arrays.asList
	    ("zero","one","two","three","four","five","six","seven",
	    "eight","nine","ten","eleven","twelve","thirteen","fourteen",
	    "fifteen","sixteen","seventeen","eighteen","nineteen","twenty",
	    "thirty","forty","fifty","sixty","seventy","eighty","ninety",
	    "hundred","thousand","million","billion","trillion" );

	    if(input != null && input.length()> 0)
	    {
	        input = input.replaceAll("-", " ");
	        input = input.toLowerCase().replaceAll(" and", " ");
	        String[] splittedParts = input.trim().split("\\s+");

	        for(String str : splittedParts)
	        {
	            if(!allowedStrings.contains(str))
	            {
	                return " ";
	            }
	        }
	        
	            for(String str : splittedParts)
	            {
	                if(str.equalsIgnoreCase("zero")) {
	                    result += 0;
	                }
	                else if(str.equalsIgnoreCase("one")) {
	                    result += 1;
	                }
	                else if(str.equalsIgnoreCase("two")) {
	                    result += 2;
	                }
	                else if(str.equalsIgnoreCase("three")) {
	                    result += 3;
	                }
	                else if(str.equalsIgnoreCase("four")) {
	                    result += 4;
	                }
	                else if(str.equalsIgnoreCase("five")) {
	                    result += 5;
	                }
	                else if(str.equalsIgnoreCase("six")) {
	                    result += 6;
	                }
	                else if(str.equalsIgnoreCase("seven")) {
	                    result += 7;
	                }
	                else if(str.equalsIgnoreCase("eight")) {
	                    result += 8;
	                }
	                else if(str.equalsIgnoreCase("nine")) {
	                    result += 9;
	                }
	                else if(str.equalsIgnoreCase("ten")) {
	                    result += 10;
	                }
	                else if(str.equalsIgnoreCase("eleven")) {
	                    result += 11;
	                }
	                else if(str.equalsIgnoreCase("twelve")) {
	                    result += 12;
	                }
	                else if(str.equalsIgnoreCase("thirteen")) {
	                    result += 13;
	                }
	                else if(str.equalsIgnoreCase("fourteen")) {
	                    result += 14;
	                }
	                else if(str.equalsIgnoreCase("fifteen")) {
	                    result += 15;
	                }
	                else if(str.equalsIgnoreCase("sixteen")) {
	                    result += 16;
	                }
	                else if(str.equalsIgnoreCase("seventeen")) {
	                    result += 17;
	                }
	                else if(str.equalsIgnoreCase("eighteen")) {
	                    result += 18;
	                }
	                else if(str.equalsIgnoreCase("nineteen")) {
	                    result += 19;
	                }
	                else if(str.equalsIgnoreCase("twenty")) {
	                    result += 20;
	                }
	                else if(str.equalsIgnoreCase("thirty")) {
	                    result += 30;
	                }
	                else if(str.equalsIgnoreCase("forty")) {
	                    result += 40;
	                }
	                else if(str.equalsIgnoreCase("fifty")) {
	                    result += 50;
	                }
	                else if(str.equalsIgnoreCase("sixty")) {
	                    result += 60;
	                }
	                else if(str.equalsIgnoreCase("seventy")) {
	                    result += 70;
	                }
	                else if(str.equalsIgnoreCase("eighty")) {
	                    result += 80;
	                }
	                else if(str.equalsIgnoreCase("ninety")) {
	                    result += 90;
	                }
	                else if(str.equalsIgnoreCase("hundred")) {
	                    result *= 100;
	                }
	                else if(str.equalsIgnoreCase("thousand")) {
	                    result *= 1000;
	                    finalResult += result;
	                    result=0;
	                }
	                else if(str.equalsIgnoreCase("million")) {
	                    result *= 1000000;
	                    finalResult += result;
	                    result=0;
	                }
	                else if(str.equalsIgnoreCase("billion")) {
	                    result *= 1000000000;
	                    finalResult += result;
	                    result=0;
	                }
	                else if(str.equalsIgnoreCase("trillion")) {
	                    result *= 1000000000000L;
	                    finalResult += result;
	                    result=0;}
	                
	          }

	            finalResult += result;
	            result=0;
	            
	            String f=String.valueOf(finalResult);
	            
	            return(f);
	        
	    }
	    else
	    {
	        return " ";
	    }
	}
	
	
	
	
     
	@Autowired
	public StudentRepository studentRepository;
	
	
	
	@GetMapping("/read")
	public List<Student> getAllStudents()
	{
		List<Student> l= studentRepository.findAll();
		if(l.isEmpty())
			  throw new StudentNotFound("Student does not exist");
		else
		   return l;
		
	}
	
	
		
	/* @GetMapping("/read")
	  public ResponseEntity<?> getAllStudents()
	{
	
			
			List<Student> l= studentRepository.findAll();
		   if(l.size()<=0)
		     {
		    	 return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Students does not exist ");
		    	 
		     }
		     else
		     {
		    	 return ResponseEntity.of(Optional.of(l));
		    	
		     }
				
	}
	*/
	@GetMapping("/read/{id}")
	public Student read(@PathVariable Long id)
	{
	return studentRepository.findById(id).orElseThrow(()-> new StudentNotFound("Student does not found with id "+id ));
	}
    
	
	/*("/read/{id}")
	public ResponseEntity<?> read(@PathVariable Long id) {  //@Pathvariable annotation is used to extract the template part of the url
	
		Optional<Student> Obj = studentRepository.findById(id);
		if(Obj.isPresent()) 
		{
			return ResponseEntity.of(Optional.of(Obj));
		}
		else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body( "Student does not exist with given id");
		}
		
		
		
	}*/
	
	
	@PostMapping("/create")
	public String createStudents(@Valid @RequestBody Student s)   //maps the http request body to domain object
	{	
		
		  String a = convert(s.getAge());
		  if(a==" ")   
			  throw new InvalidAge("Invalid Age.Enter age correctly.");
				//return "invalid age";
		  else
		 {	  
				  s.setAge(a);
			      studentRepository.insert(s);
			      return "Added Student";
		 }
		 
		
	}
	
	
	/*@PutMapping("/update")
  	public ResponseEntity<String> update (@RequestBody Student s) {
		try 
		{  
		   
		    {
			    String a = convert(s.getAge());
			    if(a==" ")   
				  return "invalid age";
			    else
			  	  s.setAge(a);
             }
		      studentRepository.save(s);
		      return "Updated Student for id " + s.getID();
		}
		catch(Exception e)
		{
			return new ResponseEntity<> (HttpStatus.INTERNAL_SERVER_ERROR) ;
		}
	}*/
	
	
	@PutMapping("/update/{id}")
	public ResponseEntity<?> updateStudent(@RequestBody Student student, @PathVariable long id) {
		
		
		String b = convert(student.getAge());
		if(b!="")
		{
			String a = convert(b);
			  if(a==" ")   
				  throw new InvalidAge("Invalid Age.Enter age correctly.");
					//return "invalid age";
			   student.setAge(a);
			
		}
		

		Optional<Student> studentOptional = studentRepository.findById(id);

		if (!studentOptional.isPresent())
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Students does not exist with given id");

		student.setID(id);
		studentRepository.save(student);
        return ResponseEntity.status(HttpStatus.OK).body("Students Updated");
	
	}

	@DeleteMapping("/delete/{id}")
	public  ResponseEntity<?> delete(@PathVariable Long id) {
		try {
		
			Optional<Student> studentobj = studentRepository.findById(id);
		
			if(studentobj.isPresent()) {
			studentRepository.delete(studentobj.get());
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Student deleted");
		
			}
			else 
			{
			
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Students does not exist with given id");
				
		    }
		}
		catch(Exception e) {
			return new ResponseEntity<> (HttpStatus.INTERNAL_SERVER_ERROR) ;
		}
	}
	
		 
}
