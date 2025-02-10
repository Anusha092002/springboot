/**
 * 
 */
package com.example.demo;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 
* The controller will ensure that the class will control how the object will be used
* it is done using 2 parts
* 	1. get mapping
*   2. request parameters
 */
@RestController
public class GreetingContoller {
	private final static String template="Hello, %s!";
	private static AtomicLong atomicLong= new AtomicLong();
	@GetMapping("/greeting")
	public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) 
	{ 		
		return new Greeting(atomicLong.incrementAndGet(), String.format(template, name));
	
	}

}
