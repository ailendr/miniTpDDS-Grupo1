package model.domain.entities;

import model.db.EntidadPersistente;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class Provincia extends EntidadPersistente {
  @Column(name = "nombre")
  private String nombre;
  @OneToMany(mappedBy = "provincia", cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
  private List<Ciudad> ciudades;
  @OneToMany(mappedBy = "provincia", cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
  private List<Localidad> localidades;
}
