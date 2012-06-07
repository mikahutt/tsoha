/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package harkka.tsohantyo;

/**
 *
 * @author MH
 */
public interface OlutDao {
    void persist(Olut olut);
    void remove(Olut olut);
    Olut findById(int id);
}
