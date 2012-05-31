/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package harkka.tsohantyo;

import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Kontrolleri {

    @RequestMapping("testi")
        public String heiSpring(Model model, HttpSession session) {
        System.out.println("Heippa!");

        int kaynteja = 0;
        if (session.getAttribute("kaynnit") != null) {
            kaynteja = (Integer) session.getAttribute("kaynnit");
        }

        kaynteja = kaynteja + 1;
        session.setAttribute("kaynnit", kaynteja);


        model.addAttribute("viesti", kaynteja);
        return "index.jsp";
    }
    
    @RequestMapping("summaa")
    public String summaaArvot(@RequestParam Integer eka, @RequestParam Integer toka, Model model) {
        System.out.println("Summa: " + (eka + toka));
        model.addAttribute("viesti",(eka+toka));
        return "summaaja.jsp";
    }
    
    //@RequestMapping(value="osoite", method=RequestMethod.POST)
    @RequestMapping("osoite")
    public String osallistuminen(@ModelAttribute Kayttaja kayttaja) {
        System.out.println("Henkilön nimi: " + kayttaja.getNimi());
        System.out.println("Henkilön salasana: " + kayttaja.getSalasana());
        
        return "ilmoittautuminen.jsp";
    }
    
    
}
