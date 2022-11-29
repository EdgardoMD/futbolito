package com.futbolito.models.DTOs;

import com.futbolito.models.entities.Athlete;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AthleteDto {
	
	private String athleteLevel;
	private String city;
	private float height;
	private int weight;
	private String position;
	private String skillfulFoot;
	private String birthDate;
	private String nick;
	private String profilePhoto;
	private String phone;
	private String name;
	private String mail;
	
	public AthleteDto(Athlete athlete) {
		
		 height = athlete.getHeight()  ;
		 weight = athlete.getWeight()  ;
		 position = athlete.getPosition()  ;
		 skillfulFoot = athlete.getSkillfulFoot()  ;
		 birthDate = athlete.getBirthDate()  ;
		 nick = athlete.getUser().getNickName()  ;
		 profilePhoto = athlete.getProfilePhoto()  ;
		 phone = athlete.getUser().getPhone()  ;
		 name = athlete.getUser().getName()  ;
		 mail = athlete.getUser().getMail()  ;
		 if(athlete.getAthleteLevel() != null )
			 athleteLevel = athlete.getAthleteLevel().getLevel();
		 if (athlete.getCity() != null)
		 city = athlete.getCity().getCity();
	}
	
	

}
