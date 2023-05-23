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
import mx.vinos.modelo.Venta;

/**
 *
 * @author Antonio
 */
public class VentaDAO {

    EntityManager em;

    public VentaDAO() {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Punto-ejbPU");
        em = emf.createEntityManager();
    }

    public boolean crear(Venta venta) {

        em.getTransaction().begin();
        em.persist(venta);
        em.getTransaction().commit();

        return true;

    }

    public boolean editar(Venta venta) {

        em.getTransaction().begin();
        em.merge(venta);
        em.getTransaction().commit();

        return true;

    }

    public boolean eliminar(Venta venta) {

        em.getTransaction().begin();
        em.remove(em.merge(venta));
        em.getTransaction().commit();

        return true;

    }
    
    
    public Venta getPorId(int id){
        
        Query q = em.createNamedQuery("Venta.findById");
        q.setParameter("id", id);
        if(q.getResultList()!=null){
            
            return (Venta)q.getResultList().get(0);
            
        }else{
            return null;
            
        }
    }
    
    
    public List<Venta> getTodo(){
           Query q = em.createNamedQuery("Venta.findAll");
           return q.getResultList();
        
    }
    
}
