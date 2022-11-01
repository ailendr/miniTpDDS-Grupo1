package model.domain.entities;


import model.db.EntidadPersistente;

import javax.persistence.*;

@Entity
@Table(name="Localidad")
public class Localidad extends EntidadPersistente {
  @Column(name="nombre")
  private String nombre;
  @ManyToOne
  @JoinColumn(name="provincia_id", referencedColumnName = "id")
  private Provincia provincia;

}
