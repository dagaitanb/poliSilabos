package org.api.data;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author DarkKlitos
 */
@Entity
@Table(name = "par_titulo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ParTitulo.findAll", query = "SELECT p FROM ParTitulo p"),
    @NamedQuery(name = "ParTitulo.findById", query = "SELECT p FROM ParTitulo p WHERE p.id = :id"),
    @NamedQuery(name = "ParTitulo.findByDescripcion", query = "SELECT p FROM ParTitulo p WHERE p.descripcion = :descripcion"),
    @NamedQuery(name = "ParTitulo.findByFechaCreacion", query = "SELECT p FROM ParTitulo p WHERE p.fechaCreacion = :fechaCreacion"),
    @NamedQuery(name = "ParTitulo.findByEstadoNucleo", query = "SELECT p FROM ParTitulo p WHERE p.estadoNucleo = :estadoNucleo")})
public class ParTitulo implements Serializable {

    @OneToMany(mappedBy = "idTitulo")
    private Collection<ParNucleoTitulo> parNucleoTituloCollection;
    @OneToMany(mappedBy = "idTitulo")
    private Collection<ParNucleoTematico> parNucleoTematicoCollection;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "descripcion")
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_creacion")
    @Temporal(TemporalType.DATE)
    private Date fechaCreacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "estado_nucleo")
    private boolean estadoNucleo;
    @JoinColumn(name = "cod_materia", referencedColumnName = "cod_materia")
    @ManyToOne
    private ParMaterias codMateria;

    public ParTitulo() {
    }

    public ParTitulo(Integer id) {
        this.id = id;
    }

    public ParTitulo(Integer id, String descripcion, Date fechaCreacion, boolean estadoNucleo) {
        this.id = id;
        this.descripcion = descripcion;
        this.fechaCreacion = fechaCreacion;
        this.estadoNucleo = estadoNucleo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public boolean getEstadoNucleo() {
        return estadoNucleo;
    }

    public void setEstadoNucleo(boolean estadoNucleo) {
        this.estadoNucleo = estadoNucleo;
    }

    public ParMaterias getCodMateria() {
        return codMateria;
    }

    public void setCodMateria(ParMaterias codMateria) {
        this.codMateria = codMateria;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ParTitulo)) {
            return false;
        }
        ParTitulo other = (ParTitulo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.api.data.ParTitulo[ id=" + id + " ]";
    }

    @XmlTransient
    public Collection<ParNucleoTitulo> getParNucleoTituloCollection() {
        return parNucleoTituloCollection;
    }

    public void setParNucleoTituloCollection(Collection<ParNucleoTitulo> parNucleoTituloCollection) {
        this.parNucleoTituloCollection = parNucleoTituloCollection;
    }

    @XmlTransient
    public Collection<ParNucleoTematico> getParNucleoTematicoCollection() {
        return parNucleoTematicoCollection;
    }

    public void setParNucleoTematicoCollection(Collection<ParNucleoTematico> parNucleoTematicoCollection) {
        this.parNucleoTematicoCollection = parNucleoTematicoCollection;
    }
    
}
