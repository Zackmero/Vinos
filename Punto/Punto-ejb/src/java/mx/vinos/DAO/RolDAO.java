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
import mx.vinos.modelo.Rol;


/**
 *
 * @author Migue
 */
public class RolDAO {
    
    
       EntityManager em;

    public RolDAO() {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Punto-ejbPU");
        em = emf.createEntityManager();
    }

    public boolean crear(Rol rol) {

        em.getTransaction().begin();
        em.persist(rol);
        em.getTransaction().commit();

        return true;

    }

    public boolean editar(Rol rol) {

        em.getTransaction().begin();
        em.merge(rol);
        em.getTransaction().commit();

        return true;

    }

    public boolean eliminar(Rol rol) {

        em.getTransaction().begin();
        em.remove(em.merge(rol));
        em.getTransaction().commit();

        return true;

    }
    
    
    public Rol getPorId(int id){
        
        Query q = em.createNamedQuery("Rol.findById");
        q.setParameter("id", id);
        if(q.getResultList()!=null){
            
            return (Rol)q.getResultList().get(0);
            
        }else{
            return null;
            
        }
    }
    
    
    public List<Rol> getTodo(){


           Query q = em.createNamedQuery("Rol.findAll");
           return q.getResultList();
        
    }
    
    
    
}
