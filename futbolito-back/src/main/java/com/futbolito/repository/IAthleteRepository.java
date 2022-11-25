package com.futbolito.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.futbolito.models.entities.Athlete;

public interface IAthleteRepository extends JpaRepository<Athlete, Long> {
	
	
	@Query(value = "select * from athletes where id_user = :id_user", 
			  nativeQuery = true)
	Optional<Athlete> findByUserId(@Param("id_user")Long idUser);

	

}
