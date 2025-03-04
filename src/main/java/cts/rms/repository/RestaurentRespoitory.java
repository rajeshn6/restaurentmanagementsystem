package cts.rms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.NativeQuery;
import org.springframework.data.jpa.repository.Query;

import cts.rms.dto.Restaurent;

public interface RestaurentRespoitory extends JpaRepository<Restaurent, Integer>{
		@NativeQuery(value = "select * from restaurent  where name=?1")
		public Restaurent findName(String RestaurentName);
		//This method given to the JPA 
		//And JPA is going to generate a query from this method
		// SELECT * FROM Restaurent WHERE name=xyz;
		@Query(value = "select r from Restaurent r where r.type=?1")
		public List<Restaurent> findByType(String type);
		//This method given to the JPA 
		//And JPA is going to generate a query from this method
		// SELECT * FROM Restaurent WHERE type="veg";
}
