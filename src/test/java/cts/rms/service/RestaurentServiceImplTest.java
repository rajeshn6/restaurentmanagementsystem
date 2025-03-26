package cts.rms.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import cts.rms.dto.Restaurent;
import cts.rms.exception.RestaurentIdNotFoundException;
import cts.rms.repository.RestaurentRespoitory;

@ExtendWith(MockitoExtension.class)
class RestaurentServiceImplTest {

	@Mock
	RestaurentRespoitory restaurentRespoitory;

	@InjectMocks
	RestaurentServiceImpl restaurentService;
	
	@Test
	void testCreateRestaurent() {
	Restaurent restaurent=new Restaurent(100,"a2b","coimabtore","veg");
		Mockito.when(restaurentRespoitory.save(restaurent)).thenReturn(restaurent);
		Restaurent actuals=restaurentService.createRestaurent(restaurent);
		assertEquals(restaurent, actuals);
		assertEquals(100, actuals.getId());
	}

	@Test
	void testGetRestaurentById() {
		Restaurent restaurent=new Restaurent(1,"a2b","coimabtore","veg");
		Mockito.when(restaurentRespoitory.findById(1)).thenReturn(Optional.of(restaurent));
		Restaurent actuals=restaurentService.getRestaurentById(1);
		assertEquals(restaurent, actuals);
	}
	@Test
	void testGetRestaurentByIdThrowsException() {
		Mockito.when(restaurentRespoitory.findById(1)).thenReturn(Optional.empty());
		assertThrows(RestaurentIdNotFoundException.class, ()->{
			restaurentService.getRestaurentById(1);
		});
	}

	@Test
	void testGetAllRestaurent() {
		List<Restaurent> list=new ArrayList<>();
		list.add(new Restaurent(100, "abc", "chennai", "non veg"));
		list.add(new Restaurent(343,"bcd", "cbe", "Veg"));
		
		Mockito.when(restaurentRespoitory.findAll()).thenReturn(list);
		List<Restaurent> actuals=restaurentService.getAllRestaurent();
		assertEquals(2, actuals.size());
	}
//
//	@Test
//	void testUpdateRestaurent() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testDeleteRestaurentById() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testFindRestaurentByName() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testGetRestaurentByType() {
//		fail("Not yet implemented");
//	}

}
