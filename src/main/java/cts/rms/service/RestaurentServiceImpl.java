package cts.rms.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Service;

import cts.rms.dto.Restaurent;
import cts.rms.exception.RestaurentIdNotFoundException;
import cts.rms.exception.RestaurentNameNotExistsException;
import cts.rms.exception.RestaurentNotUpdatedException;
import cts.rms.repository.RestaurentRespoitory;
@Service
public class RestaurentServiceImpl implements RestaurentService{  // SUT or CUT
	
	@Autowired
	RestaurentRespoitory restaurentRespoitory;
	
	public Restaurent createRestaurent(Restaurent restaurent) { // MUT
		Restaurent restaurent2= restaurentRespoitory.save(restaurent);
		return restaurent2;
	}
	
	public Restaurent getRestaurentById(int restaurentId) { // MUT
		Optional<Restaurent> res=restaurentRespoitory.findById(restaurentId);
		if(res.isEmpty()) {
			throw new RestaurentIdNotFoundException("restaurent ID:"+restaurentId+" is not found in the db");
		
		}
		return res.get();
	}
	
	public List<Restaurent> getAllRestaurent(){
		List<Restaurent> listOfRestaurents=restaurentRespoitory.findAll();
		return listOfRestaurents;
		
	}
	
	public Restaurent updateRestaurent(Restaurent restaurent) {
		boolean status = restaurentRespoitory.existsById(restaurent.getId());
		if(status==false) {
			throw new RestaurentNotUpdatedException("Restaurent with id you want to update is not there in the db !!! so updated is failed");
		}
		return restaurentRespoitory.save(restaurent);
		
		
	}
	
	public String deleteRestaurentById(int restaurentId) {
		boolean status = restaurentRespoitory.existsById(restaurentId);
		if(status==true) {
			restaurentRespoitory.deleteById(restaurentId);
			return "restaurent is deleted successfully";
		}
		return "restaurent is not deleted !!! check ID";
	}

	@Override
	public Restaurent findRestaurentByName(String name) {
		 Restaurent restaurent = restaurentRespoitory.findName(name);
		 if(restaurent==null) {
			 throw new RestaurentNameNotExistsException("Restaurent name: "+name+" is not exists in the db !!! Check the restaurent name") ;
		 }
		return restaurent;
	}

	@Override
	public List<Restaurent> getRestaurentByType(String type) {
		return restaurentRespoitory.findByType(type);
	}
}
