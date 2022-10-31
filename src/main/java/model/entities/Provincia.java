package model.entities;

import model.db.EntidadPersistente;

import javax.persistence.*;
import java.util.ArrayList;

@Entity
@Table
public class Provincia extends EntidadPersistente {
  @Column(name = "nombre")
  private String nombre;
 // @OneToMany(mappedBy = "provincia", cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
  @Transient
  private ArrayList<Ciudad> ciudades;
//  @OneToMany(mappedBy = "provincia", cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
  @Transient
  private ArrayList<Localidad> localidades;
}
