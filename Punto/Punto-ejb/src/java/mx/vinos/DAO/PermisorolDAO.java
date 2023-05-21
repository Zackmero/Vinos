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
import mx.vinos.modelo.Permisorol;


/**
 *
 * @author Migue
 */
public class PermisorolDAO {
    EntityManager em;

    public PermisorolDAO() {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Punto-ejbPU");
        em = emf.createEntityManager();
    }

    public boolean crear(Permisorol permisorol) {

        em.getTransaction().begin();
        em.persist(permisorol);
        em.getTransaction().commit();

        return true;

    }

    public boolean editar(Permisorol permisorol) {

        em.getTransaction().begin();
        em.merge(permisorol);
        em.getTransaction().commit();

        return true;

    }

    public boolean eliminar(Permisorol permisorol) {

        em.getTransaction().begin();
        em.remove(em.merge(permisorol));
        em.getTransaction().commit();

        return true;

    }
    
    
    public Permisorol getPorId(int id){
        
        Query q = em.createNamedQuery("Permisorol.findById");
        q.setParameter("id", id);
        if(q.getResultList()!=null){
            
            return (Permisorol)q.getResultList().get(0);
            
        }else{
            return null;
            
        }
    }
    
    
    public List<Permisorol> getTodo(){


           Query q = em.createNamedQuery("Permisorol.findAll");
           return q.getResultList();
        
    }
}
