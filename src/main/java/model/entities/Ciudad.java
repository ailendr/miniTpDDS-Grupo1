package model.entities;


import model.db.EntidadPersistente;

import javax.persistence.*;

@Entity
@Table(name="ciudad")
public class Ciudad extends EntidadPersistente {
  @Column(name="nombre")
  private String nombre;
  @ManyToOne
  @JoinColumn(name="provincia_id", referencedColumnName = "id")
  private Provincia provincia;
}
