package com.futbolito.services.interfaces;


import com.futbolito.models.entidades.Role;

public interface IRolUsuarioServicio extends ICRUD<Role>{
	
    public void save(Role rol);

}
