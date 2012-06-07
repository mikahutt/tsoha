/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package harkka.tsohantyo;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

/**
 *
 * @author MH
 */
@Repository("db")
public class DbOlutDao implements OlutDao {
    
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void persist(Olut olut) {
        entityManager.persist(olut);
    }

    @Override
    public void remove(Olut olut) {
        entityManager.remove(olut);
    }

    @Override
    public Olut findById(int id) {
        return entityManager.find(Olut.class, id);
    }    
}
