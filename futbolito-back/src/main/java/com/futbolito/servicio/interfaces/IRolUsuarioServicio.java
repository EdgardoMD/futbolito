package com.futbolito.servicio.interfaces;


import com.futbolito.modelo.entidades.Rol;

public interface IRolUsuarioServicio extends ICRUD<Rol>{
	
    public void save(Rol rol);

}
