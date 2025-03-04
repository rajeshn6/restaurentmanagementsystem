package cts.rms.service;

import java.util.List;

import cts.rms.dto.Restaurent;

public interface RestaurentService {
	public Restaurent createRestaurent(Restaurent restaurent);
	public Restaurent getRestaurentById(int restaurentId);
	public List<Restaurent> getAllRestaurent();
	public Restaurent updateRestaurent(Restaurent restaurent);
	public String deleteRestaurentById(int restaurentId);
	public Restaurent findRestaurentByName(String name);
	public List<Restaurent> getRestaurentByType(String type);
}
