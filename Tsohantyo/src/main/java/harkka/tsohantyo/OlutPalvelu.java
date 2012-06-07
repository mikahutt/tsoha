/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package harkka.tsohantyo;

import java.util.List;

public interface OlutPalvelu {
    Olut lisaaOlut(Olut olut);
    void poistaOlut(int tunnus);
    Olut muokkaaTaiLisaaOlut(int tunnus, Olut olut);
    Olut annaOlut(int tunnus);
    List<Olut> listaaOluet();
}