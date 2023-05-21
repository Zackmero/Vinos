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
import mx.vinos.modelo.Producto;

/**
 *
 * @author Migue
 */
public class ProductoDAO {

    EntityManager em;

    public ProductoDAO() {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Punto-ejbPU");
        em = emf.createEntityManager();
    }

    public boolean crear(Producto producto) {

        em.getTransaction().begin();
        em.persist(producto);
        em.getTransaction().commit();

        return true;

    }

    public boolean editar(Producto producto) {

        em.getTransaction().begin();
        em.merge(producto);
        em.getTransaction().commit();

        return true;

    }

    public boolean eliminar(Producto producto) {

     em.getTransaction().begin();
        em.remove(em.merge(producto));
      em.getTransaction().commit();

        return true;

    }
    
    
    public Producto getPorId(int id){
        
        Query q = em.createNamedQuery("Producto.findById");
        q.setParameter("id", id);
        if(q.getResultList()!=null){
            
            return (Producto)q.getResultList().get(0);
            
        }else{
            return null;
            
        }
    }
    
    
    public List<Producto> getTodo(){
           Query q = em.createNamedQuery("Producto.findAll");
           return q.getResultList();
        
    }
    
}
