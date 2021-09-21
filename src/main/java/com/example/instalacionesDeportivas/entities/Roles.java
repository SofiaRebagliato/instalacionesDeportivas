//package com.example.instalacionesDeportivas.entities;
//
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;
//import javax.persistence.Table;
//
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//@Data
//@NoArgsConstructor
//@AllArgsConstructor
//@Entity
//@Table(name="Roles")
//
//public class Roles {
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	 private Integer idRol;
//	private String nombre;
//	
//	 @ManyToOne
//	    @JoinColumn(name = "id_usuario")
//	    private usuarios usuarios;
//
//}
