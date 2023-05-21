/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.vinos.DAO;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import mx.vinos.modelo.Permiso;

/**
 *
 * @author Migue
 */
public class PermisoDAO {

    EntityManager em;

    public PermisoDAO() {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Punto-ejbPU");
        em = emf.createEntityManager();
    }

    public boolean crear(Permiso permiso) {

        em.getTransaction().begin();
        em.persist(permiso);
        em.getTransaction().commit();

        return true;

    }

    public boolean editar(Permiso permiso) {

        em.getTransaction().begin();
        em.merge(permiso);
        em.getTransaction().commit();

        return true;

    }

    public boolean eliminar(Permiso permiso) {

        em.getTransaction().begin();
        em.remove(em.merge(permiso));
        em.getTransaction().commit();

        return true;

    }
    
    
    public Permiso getPorId(int id){
        
        Query q = em.createNamedQuery("Permiso.findById");
        q.setParameter("id", id);
        if(q.getResultList()!=null){
            
            return (Permiso)q.getResultList().get(0);
            
        }else{
            return null;
            
        }
    }
    
    
    public List<Permiso> getTodo(){

      Query q = em.createNamedQuery("Permiso.findAll");
      
      return q.getResultList();

        
        
    }
    
}
