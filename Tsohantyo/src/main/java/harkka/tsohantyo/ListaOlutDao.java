/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package harkka.tsohantyo;

import java.util.Map;
import java.util.TreeMap;
import org.springframework.stereotype.Repository;

/**
 *
 * @author MH
 */
@Repository(value="lista")
public class ListaOlutDao implements OlutDao {

    private Map<Integer, Olut> olutMap = new TreeMap<Integer, Olut>();

    @Override
    public void persist(Olut olut) {
        olutMap.put(olut.getId(), olut);
    }

    @Override
    public void remove(Olut olut) {
        olutMap.remove(olut.getId());
    }

    @Override
    public Olut findById(int id) {
        return olutMap.get(id);
    }
}
