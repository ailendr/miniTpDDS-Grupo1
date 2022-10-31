package model.seguridad;

import model.Repositorios.RepoAutorizaciones;
import model.Repositorios.RepoPersonas;
import model.entities.Autorizacion;
import model.entities.Persona;

import java.io.IOException;
import java.util.ArrayList;


public class Usuario {
  private Persona persona;
  private String nombreUsuario;
  private String contrasenia;

  public Usuario(Persona persona, String nombreUsuario, String contrasenia, String nombreUsuarioAValidar, String contraseniaAValidar) {
    this.persona = persona;
    this.nombreUsuario = nombreUsuario;
    this.contrasenia = contrasenia;
    this.nombreUsuarioAValidar = nombreUsuarioAValidar;
    this.contraseniaAValidar = contraseniaAValidar;
  }

  private String nombreUsuarioAValidar;
  private String contraseniaAValidar;
  private Boolean esAdministrador;

  private void registrarse(){
    //TODO

  }

  private void iniciarSesion(){
    //TODO
  }

  private void cerrarSesion(){
    //TODO
  }

  private ArrayList<Persona> generarReportePersonas(){
    if(esAdministrador) {
      RepoPersonas repoPersonas = new RepoPersonas();
      ArrayList <Persona> reporteDePersonas = repoPersonas.getPersonasRegistradas();
      return reporteDePersonas;
    }

    throw  new RuntimeException("no posee permiso para esta accion");
  }


  private ArrayList<Autorizacion> generarReporteAutorizaciones(){
    if (esAdministrador) {
      RepoAutorizaciones repoAutorizaciones = new RepoAutorizaciones();
      ArrayList<Autorizacion> reporteDeAutorizaciones = repoAutorizaciones.getAutorizaciones();
      return reporteDeAutorizaciones;

    }
    throw  new RuntimeException("no posee permiso para esta accion");

  }



}
