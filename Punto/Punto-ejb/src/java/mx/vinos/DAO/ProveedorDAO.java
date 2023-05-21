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
import mx.vinos.modelo.Proveedor;

/**
 *
 * @author Migue
 */
public class ProveedorDAO {

    EntityManager em;

    public ProveedorDAO() {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Punto-ejbPU");
        em = emf.createEntityManager();
    }

    public boolean crear(Proveedor proveedor) {

        em.getTransaction().begin();
        em.persist(proveedor);
        em.getTransaction().commit();

        return true;

    }

    public boolean editar(Proveedor proveedor) {

        em.getTransaction().begin();
        em.merge(proveedor);
        em.getTransaction().commit();

        return true;

    }

    public boolean eliminar(Proveedor proveedor) {

        em.getTransaction().begin();
        em.remove(em.merge(proveedor));
        em.getTransaction().commit();

        return true;

    }
    
    
    public Proveedor getPorId(int id){
        
        Query q = em.createNamedQuery("Proveedor.findById");
        q.setParameter("id", id);
        if(q.getResultList()!=null){
            
            return (Proveedor)q.getResultList().get(0);
            
        }else{
            return null;
            
        }
    }
    
    
    public List<Proveedor> getTodo(){
           Query q = em.createNamedQuery("Proveedor.findAll");
           return q.getResultList();
        
    }
    
}
