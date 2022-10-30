package model.entities;

import java.awt.*;
import java.util.ArrayList;
import java.util.Date;


public class Persona {
  private String nombre;
  private String apellido;
  private String dni;
  private Date fechaNacimiento;
  private ArrayList <Autorizacion> autorizaciones;
  private Ciudad ciudad;
  private Localidad localidad;
  private Image foto;

  public Persona(String nombre, String apellido, String dni, Date fechaNacimiento, ArrayList<Autorizacion> autorizaciones, Ciudad ciudad, Localidad localidad, Image foto) {
    this.nombre = nombre;
    this.apellido = apellido;
    this.dni = dni;
    this.fechaNacimiento = fechaNacimiento;
    this.autorizaciones = autorizaciones;
    this.ciudad = ciudad;
    this.localidad = localidad;
    this.foto = foto;
  }

  public void setFechaNacimiento(Date fechaNacimiento) {
    this.fechaNacimiento = fechaNacimiento;
  }

  public void setCiudad(Ciudad ciudad) {
    this.ciudad = ciudad;
  }

  public void setLocalidad(Localidad localidad) {
    this.localidad = localidad;
  }

  public void setFoto(Image foto) {
    this.foto = foto;
  }

  public void delegar(Persona persona){
    Autorizacion autorizacion = new Autorizacion(persona, false, this);
    persona.agregarAutorizacion(autorizacion);
  }
}
