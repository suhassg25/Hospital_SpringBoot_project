package com.ty.Hospital.HospitalBoot_prc.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.Hospital.HospitalBoot_prc.dto.Location;
import com.ty.Hospital.HospitalBoot_prc.repositery.LocationRepository;

@Repository
public class LocationDao {

	@Autowired
	LocationRepository locationRepository;

	public Location saveLocation(Location location) {
		return locationRepository.save(location);
	}

	public Location updateLocation(Location location) {
		return locationRepository.save(location);
	}

	public Location getLocationById(int id) {
		Optional<Location> optional = locationRepository.findById(id);
		if (optional.isEmpty()) {
			return null;
		}
		return optional.get();
	}

	public String deleteLocationById(int id) {
		locationRepository.deleteById(id);
		return "deleted";
	}
}
