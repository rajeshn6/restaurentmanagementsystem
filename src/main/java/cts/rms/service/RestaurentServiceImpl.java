package cts.rms.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Service;

import cts.rms.dto.Restaurent;
import cts.rms.repository.RestaurentRespoitory;
@Service
public class RestaurentServiceImpl implements RestaurentService{
	
	@Autowired
	RestaurentRespoitory restaurentRespoitory;
	
	public Restaurent createRestaurent(Restaurent restaurent) {
		Restaurent restaurent2= restaurentRespoitory.save(restaurent);
		return restaurent2;
	}
	
	public Restaurent getRestaurentById(int restaurentId) {
		Optional<Restaurent> res=restaurentRespoitory.findById(restaurentId);
		if(res.isPresent()) {
			return res.get();
		}
		return null;
		
	}
	
	public List<Restaurent> getAllRestaurent(){
		List<Restaurent> listOfRestaurents=restaurentRespoitory.findAll();
		return listOfRestaurents;
		
	}
	
	public Restaurent updateRestaurent(Restaurent restaurent) {
		boolean status = restaurentRespoitory.existsById(restaurent.getId());
		if(status==true) {
			Restaurent rest = restaurentRespoitory.save(restaurent);
			return rest;
		}
		return null;
		
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
		
		return restaurentRespoitory.findName(name);
	}

	@Override
	public List<Restaurent> getRestaurentByType(String type) {
		return restaurentRespoitory.findByType(type);
	}
}
