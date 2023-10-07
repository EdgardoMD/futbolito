package com.futbolito.services.implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.futbolito.models.entities.Region;
import com.futbolito.repository.IRegionRepository;
import com.futbolito.services.interfaces.IRegionService;

@Service
public class RegionServiceImpl implements IRegionService {
	
	@Autowired
	private IRegionRepository regionRepository;

	@Override
	public Region save(Region obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Region update(Region obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Region> toList() {
		
		return regionRepository.findAll();
	}

	@Override
	public Region getById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(Long id) {
		// TODO Auto-generated method stub
		return false;
	}

}
