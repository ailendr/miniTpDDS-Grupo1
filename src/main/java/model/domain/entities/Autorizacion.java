package model.domain.entities;

import model.db.EntidadPersistente;

import javax.persistence.*;

@Entity
@Table(name = "autorizacion")
public class Autorizacion extends EntidadPersistente {

  @ManyToOne
  @JoinColumn(name="persona_id", referencedColumnName = "id")
  private Persona persona;
  //private Estado estado; -> ver si nos conviene eso o el booleano y que valide.
  @Column(name = "aceptado")
  private Boolean aceptado;

  @ManyToOne
  @JoinColumn(name="personaAutorizada_id", referencedColumnName = "id")
  private Persona personaAutorizada;

  public Autorizacion(Persona persona, Boolean aceptado, Persona personaAutorizada) {
    this.persona = persona;
    this.aceptado = aceptado;
    this.personaAutorizada = personaAutorizada;
  }

    public void aceptarse() {
    aceptado = true;
    }
}
