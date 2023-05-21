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
import mx.vinos.modelo.Vendedor;

/**
 *
 * @author Migue
 */
public class VendedorDAO {

    EntityManager em;

    public VendedorDAO() {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Punto-ejbPU");
        em = emf.createEntityManager();
    }

    public boolean crear(Vendedor vendedor) {

        em.getTransaction().begin();
        em.persist(vendedor);
        em.getTransaction().commit();

        return true;

    }

    public boolean editar(Vendedor vendedor) {

        em.getTransaction().begin();
        em.merge(vendedor);
        em.getTransaction().commit();

        return true;

    }

    public boolean eliminar(Vendedor vendedor) {

        em.getTransaction().begin();
        em.remove(em.merge(vendedor));
        em.getTransaction().commit();

        return true;

    }
    
    
    public Vendedor getPorId(int id){
        
        Query q = em.createNamedQuery("Vendedor.findById");
        q.setParameter("id", id);
        if(q.getResultList()!=null){
            
            return (Vendedor)q.getResultList().get(0);
            
        }else{
            return null;
            
        }
    }
    
    
    public List<Vendedor> getTodo(){


           Query q = em.createNamedQuery("Vendedor.findAll");
           return q.getResultList();
        
    }
    
}
