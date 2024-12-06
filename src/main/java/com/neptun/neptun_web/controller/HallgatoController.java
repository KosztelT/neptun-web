package com.neptun.neptun_web.controller;

import com.neptun.neptun_web.service.NeptunRendszer;
import com.neptun.neptun_web.model.Hallgato;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class HallgatoController {

    private final NeptunRendszer neptunRendszer;

    public HallgatoController() {
        this.neptunRendszer = new NeptunRendszer();
    }

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("hallgatok", neptunRendszer.getHallgatok());
        return "index";
    }

    @PostMapping("/ujHallgato")
    public String ujHallgato(@RequestParam String nev, @RequestParam String neptunKod) {
        neptunRendszer.ujHallgato(neptunKod, nev);
        return "redirect:/";
    }

    @GetMapping("/keresHallgato")
    public String keresHallgato(@RequestParam String neptunKod, Model model) {
        Hallgato hallgato = neptunRendszer.keresHallgato(neptunKod);
        model.addAttribute("hallgato", hallgato);
        return "kereses";
    }
}
