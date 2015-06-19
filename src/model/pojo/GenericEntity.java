/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.pojo;

import java.io.Serializable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 *
 * @author Fabiano
 */
@MappedSuperclass
public abstract class GenericEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public Long getId() {
        return id;
    }

    public GenericEntity() {
    }

//    public void salva(){
//        EntityManagerFactory factory = JPAUtil.getEntityManagerFactory();
//        EntityManager manager = JPAUtil.getEntityManager();
//        EntityTransaction tran = manager.getTransaction();
//        tran.begin();
//        manager.persist(this);
//        tran.commit();
//        manager.close();
//    }
    public void setId(Long id) {
        this.id = id;
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
        if (!(object instanceof GenericEntity)) {
            return false;
        }
        GenericEntity other = (GenericEntity) object;
        return !((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)));
    }

    @Override
    public String toString() {
        return "model.pojo.PojoBase[ id=" + id + " ]";
    }

}
