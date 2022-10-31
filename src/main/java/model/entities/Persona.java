package model.entities;

import model.db.EntidadPersistente;
import org.hibernate.engine.transaction.jta.platform.internal.JOnASJtaPlatform;

import javax.persistence.*;
import java.awt.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Entity
@Table(name = "persona")
public class Persona  extends EntidadPersistente {

  @Column(name="nombre")
  private String nombre;
  @Column(name="apellido")
  private String apellido;

  @Column(name="dni")
  private String dni;

  @Column(name= "fechaNacimiento", columnDefinition = "DATE")
  private LocalDate fechaNacimiento;


  @OneToMany(mappedBy = "persona", cascade = {CascadeType.ALL}, fetch= FetchType.LAZY )
  @Transient
  private List<Autorizacion> autorizaciones;

  @ManyToOne
  @JoinColumn(name="ciudad_id", referencedColumnName = "id")
  private Ciudad ciudad;

  @ManyToOne
  @JoinColumn(name="localidad_id", referencedColumnName = "id")

  private Localidad localidad;

  @Transient
  private Image foto;

  public Persona(String nombre, String apellido, String dni, LocalDate fechaNacimiento, ArrayList<Autorizacion> autorizaciones, Ciudad ciudad, Localidad localidad, Image foto) {
    this.nombre = nombre;
    this.apellido = apellido;
    this.dni = dni;
    this.fechaNacimiento = fechaNacimiento;
    this.autorizaciones = autorizaciones;
    this.ciudad = ciudad;
    this.localidad = localidad;
    this.foto = foto;
  }

  public void setFechaNacimiento(LocalDate fechaNacimiento) {
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

  public void agregarAutorizacion(Autorizacion autorizacion){
    autorizaciones.add(autorizacion);
  }

  public void delegar(Persona persona){
    Autorizacion autorizacion = new Autorizacion(persona, false, this);
    persona.agregarAutorizacion(autorizacion);
    this.agregarAutorizacion(autorizacion);
  }

  public void aceptarDelegacion( Autorizacion autorizacion){
    autorizacion.aceptarse();
  }


}
