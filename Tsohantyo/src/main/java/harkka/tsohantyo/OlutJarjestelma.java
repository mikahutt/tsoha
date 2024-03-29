/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package harkka.tsohantyo;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 *
 * @author MH
 */
@Service
public class OlutJarjestelma implements OlutPalvelu{
    private List<Olut> olutLista;
    
    @Autowired
    @Qualifier("lista")
    private OlutDao olutdao;
    
    public OlutJarjestelma() {
        this.olutLista = new ArrayList<Olut>();
    }
    
    @Override
    public Olut lisaaOlut(Olut olut) {
        olutLista.add(olut);
        return olut;
    }

    @Override
    public void poistaOlut(int tunnus) {
        for (Olut olut : olutLista) {
            if (olut.getId() == tunnus) {
                olutLista.remove(olut);
            }
        }
    }

    @Override
    public Olut muokkaaTaiLisaaOlut(int tunnus, Olut olut) {
        for (Olut olut1 : olutLista) {
            if (olut1.getId() == tunnus){
                return olut1;
            }
        }
        if (!olutLista.contains(olut)) {
            olutLista.add(olut);
        }
        return olut;
    }

    @Override
    public Olut annaOlut(int tunnus) {
        for (Olut olut : olutLista) {
            if (olut.getId() == tunnus) {
                return olut;
            }
        }
        return null;
    }

    @Override
    public List<Olut> listaaOluet() {
        return olutLista;
    }
    
}
