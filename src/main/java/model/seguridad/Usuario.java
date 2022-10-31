package model.seguridad;

import model.Repositorios.RepoAutorizaciones;
import model.Repositorios.RepoPersonas;
import model.db.EntidadPersistente;
import model.entities.Autorizacion;
import model.entities.Persona;

import javax.persistence.*;
import java.io.IOException;
import java.util.ArrayList;

@Entity
@Table
public class Usuario extends EntidadPersistente {
  @OneToOne(cascade = CascadeType.ALL)
  @JoinTable(name ="id_persona")
  private Persona persona;
  @Column(name ="nombreUsuario")
  private String nombreUsuario;
  @Column (name = "contrasenia")
  private String contrasenia;

  @Transient
  private String nombreUsuarioAValidar;
  @Transient
  private String contraseniaAValidar;

  @Column(name = "esAdiministrador")
  private Boolean esAdministrador;

  public Usuario(Persona persona, String nombreUsuario, String contrasenia, String nombreUsuarioAValidar, String contraseniaAValidar) {
    this.persona = persona;
    this.nombreUsuario = nombreUsuario;
    this.contrasenia = contrasenia;
    this.nombreUsuarioAValidar = nombreUsuarioAValidar;
    this.contraseniaAValidar = contraseniaAValidar;
  }



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
