/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package harkka.tsohantyo;

import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class Kontrolleri {

    @Autowired
    private OlutPalvelu olutPalvelu;

    @RequestMapping(method = RequestMethod.GET, value = "olut")
    public String listaaOluet(Model model) {
        model.addAttribute("oluet", olutPalvelu.listaaOluet());
        return "listaus.jsp";
    }

    @RequestMapping(method = RequestMethod.GET, value = "olut/{olutId}")
    public String naytaOlut(Model model, @PathVariable Integer olutId) {
        model.addAttribute("olut", olutPalvelu.annaOlut(olutId));
        return "olutnakyma.jsp";
    }

    @RequestMapping(method = RequestMethod.POST, value = "olut")
    public String lisaaOlut(@ModelAttribute Olut olut) {
        olut = olutPalvelu.lisaaOlut(olut);
        return "redirect:/olut/" + olut.getId(); // luotu olut
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "olut/{olutId}")
    public String poistaOlut(@PathVariable Integer olutId) {
        olutPalvelu.poistaOlut(olutId);
        return "redirect:/olut";
    }

    @RequestMapping(method = RequestMethod.PUT, value = "olut/{olutId}")
    public String muokkaaTaiLisaaOlut(@ModelAttribute Olut olut, @PathVariable Integer olutId) {
        olut = olutPalvelu.muokkaaTaiLisaaOlut(olutId, olut);
        return "redirect:/olut/" + olut.getId(); // luotu tai muokattu olut
    }

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
        model.addAttribute("viesti", (eka + toka));
        return "summaaja.jsp";
    }

    //@RequestMapping(value="osoite", method=RequestMethod.POST)
    @RequestMapping("osoite")
    public String osallistuminen(@ModelAttribute Kayttaja kayttaja) {
        System.out.println("Henkil�n nimi: " + kayttaja.getNimi());
        System.out.println("Henkil�n salasana: " + kayttaja.getSalasana());

        return "ilmoittautuminen.jsp";
    }
}
