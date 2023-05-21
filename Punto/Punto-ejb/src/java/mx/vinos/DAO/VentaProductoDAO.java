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
import mx.vinos.modelo.Ventaproducto;

/**
 *
 * @author Migue
 */
public class VentaProductoDAO {

    EntityManager em;

    public VentaProductoDAO() {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Punto-ejbPU");
        em = emf.createEntityManager();
    }

    public boolean crear(Ventaproducto ventaproducto) {

        em.getTransaction().begin();
        em.persist(ventaproducto);
        em.getTransaction().commit();

        return true;

    }

    public boolean editar(Ventaproducto ventaproducto) {

        em.getTransaction().begin();
        em.merge(ventaproducto);
        em.getTransaction().commit();

        return true;

    }

    public boolean eliminar(Ventaproducto ventaproducto) {

        em.getTransaction().begin();
        em.remove(em.merge(ventaproducto));
        em.getTransaction().commit();

        return true;

    }

    public Ventaproducto getPorId(int id) {

        Query q = em.createNamedQuery("Ventaproducto.findById");
        q.setParameter("id", id);
        if (q.getResultList() != null) {

            return (Ventaproducto) q.getResultList().get(0);

        } else {
            return null;

        }
    }

    public List<Ventaproducto> getTodo() {

        Query q = em.createNamedQuery("Ventaproducto.findAll");
        return q.getResultList();

    }

}
