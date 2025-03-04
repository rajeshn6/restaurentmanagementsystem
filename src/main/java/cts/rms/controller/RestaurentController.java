package cts.rms.controller;

import java.util.List;

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

import cts.rms.dto.Restaurent;
import cts.rms.service.RestaurentService;

@RestController   //@Contoller + @ResponseBody
public class RestaurentController {
	@Autowired
	RestaurentService restaurentService;
	
	@PostMapping("/restaurent-api/restaurent")//Request Packet - header / body
	public ResponseEntity<Restaurent> createRestaurent(@RequestBody Restaurent restaurent) {
		System.out.println("create method called");
		System.out.println(restaurent);
		Restaurent restaurent2=restaurentService.createRestaurent(restaurent);
		ResponseEntity<Restaurent> responseEntity = 
				new ResponseEntity<Restaurent>(restaurent2,HttpStatus.CREATED);
		return responseEntity; // Response packet - header / body
	}
	@GetMapping("/restaurent-api/restaurent/{id}")
	public ResponseEntity<Restaurent> getRestaurentById(@PathVariable("id") int restaurentId) {
		System.out.println("get restaurent by id is called"+restaurentId);
		Restaurent restaurent =restaurentService.getRestaurentById(restaurentId);
		ResponseEntity<Restaurent> response;
		if(restaurent==null) {
			response=new ResponseEntity<Restaurent>(restaurent, HttpStatus.NOT_FOUND);
			return response;
		}
		response=new ResponseEntity<Restaurent>(restaurent, HttpStatus.FOUND);
		return response;
		
	}
	@GetMapping("/restaurent-api/restaurent/name/{rname}")
	public Restaurent findRestaurentByName(@PathVariable("rname") String name) {
		return restaurentService.findRestaurentByName(name);
		
	}
	@GetMapping("/restaurent-api/restaurent/type/{type}")
	public List<Restaurent> getRestaurentByType(@PathVariable String type){
		
		return restaurentService.getRestaurentByType(type);
		
	}
	
	
	@GetMapping("/restaurent-api/restaurent")
	public List<Restaurent> getAllRestaurent(){
		List<Restaurent> listOfRestaurents=restaurentService.getAllRestaurent();
		return listOfRestaurents;
		
	}
	@PutMapping("/restaurent-api/restaurent")
	public ResponseEntity<Restaurent> updateRestaurent(@RequestBody Restaurent restaurent) {
		ResponseEntity<Restaurent> response=
				new ResponseEntity<Restaurent>(restaurent, HttpStatus.GONE);
		return response;
		
	}
	@DeleteMapping("/restaurent-api/restaurent/{id}")
	public String deleteRestaurentById(@PathVariable("id") int restaurentId) {
		String result=restaurentService.deleteRestaurentById(restaurentId);
		return result;
	}
}
