package model.entities;

public class Autorizacion {
  private Persona persona;
  //private Estado estado; -> ver si nos conviene eso o el booleano y que valide.
  private Boolean aceptado;
  private Persona personaAutorizada;

  public Autorizacion(Persona persona, Boolean aceptado, Persona personaAutorizada) {
    this.persona = persona;
    this.aceptado = aceptado;
    this.personaAutorizada = personaAutorizada;
  }
}
