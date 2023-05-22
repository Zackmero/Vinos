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
import mx.vinos.modelo.Usuario;

/**
 *
 * @author Migue
 */
public class UsuarioDAO {

    EntityManager em;

    public UsuarioDAO() {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Punto-ejbPU");
        em = emf.createEntityManager();
    }

    public boolean crear(Usuario vendedor) {

        em.getTransaction().begin();
        em.persist(vendedor);
        em.getTransaction().commit();

        return true;

    }

    public boolean editar(Usuario vendedor) {

        em.getTransaction().begin();
        em.merge(vendedor);
        em.getTransaction().commit();

        return true;

    }

    public boolean eliminar(Usuario vendedor) {

        em.getTransaction().begin();
        em.remove(em.merge(vendedor));
        em.getTransaction().commit();

        return true;

    }
    
    
    public Usuario getPorId(int id){
        
        Query q = em.createNamedQuery("Usuario.findById");
        q.setParameter("id", id);
        if(q.getResultList()!=null){
            
            return (Usuario)q.getResultList().get(0);
            
        }else{
            return null;
            
        }
    }
    
    
    public List<Usuario> getTodo(){


           Query q = em.createNamedQuery("Usuario.findAll");
           return q.getResultList();
        
    }
    
}
