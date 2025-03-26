package cts.rms.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import cts.rms.dto.Restaurent;
import cts.rms.service.RestaurentService;

@WebMvcTest(controllers = RestaurentController.class) // allow us to test only the controller layer - mock http server
@WithMockUser
@ContextConfiguration
class RestaurentControllerTest {

	@MockBean
	RestaurentService restaurentService;

	@Autowired
	private MockMvc mockMvc;


	@BeforeEach
	public void setup() {
//		mockMvc = MockMvcBuilders.webAppContextSetup(context)
//				.defaultRequest(get("/").with(user("rajesh.kit@gmail.com").password("rajesh@123").roles("ADMIN"))).apply(springSecurityFilterChain)
//				.build();
	}

//	@Test
//	void testCreateRestaurent() throws Exception {
//			//execute the logic of restaurent controller createrestaurent
//		mockMvc.perform(post("/restaurent-api/restaurent)"));
//	}

	@Test
	
	void testGetRestaurentById() throws Exception {
		Restaurent restaurent = new Restaurent(1, "a2b", "coimabtore", "veg");
		Mockito.when(restaurentService.getRestaurentById(1)).thenReturn(restaurent);
		mockMvc.perform(get("/restaurent-api/restaurent/1")).andDo(print()).andExpect(jsonPath("$.id").value("1"))
				.andExpect(jsonPath("$.name").value("a2b")).andExpect(jsonPath("$.location").value("coimabtore"));
	}

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
//
	@Test
	void testGetAllRestaurent() throws Exception {
		List<Restaurent> list = new ArrayList<>();
		list.add(new Restaurent(100, "abc", "chennai", "non veg"));
		list.add(new Restaurent(343, "bcd", "cbe", "Veg"));
		Mockito.when(restaurentService.getAllRestaurent()).thenReturn(list);
		mockMvc.perform(get("/restaurent-api/restaurent")).andExpect(jsonPath("$[0].id").value("100"))
				.andExpect(jsonPath("$[1].id").value("343"));
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

}
