/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package harkka.tsohantyo;

import java.io.Serializable;
import javax.persistence.*;

/**
 * 
 * @author MH
 */
@Entity(name="OLUT")
public class Olut implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name="ID")
    private int id;
    @Column(name="NIMI", nullable=false)
    private String name;

    public Olut() {
    }
    
    public Olut(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        if(super.equals(obj)) {
            return true;
        }
        
        if(!(obj instanceof Olut)) {
            return false;
        }
        
        Olut o = (Olut) obj;
        return o.getId() == this.getId();
    }
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 43 * hash + this.id;
        return hash;
    }
}