package model.entities;


import model.db.EntidadPersistente;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="Localidad")
public class Localidad extends EntidadPersistente {
  @Column(name="nombre")
  private String nombre;

}
