/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package harkka.tsohantyo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Kontrolleri {

    @RequestMapping("testi")
    public String heiSpring() {
        System.out.println("Heippa!");
        return "index.jsp";
    }
}