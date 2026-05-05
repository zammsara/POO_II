package ni.edu.ejemplo_api.controllers;

import ni.edu.ejemplo_api.models.Persona;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestController.*;

import java.util.HashMap;
import java.util.Map;

/**
 * Project: ejemplo_api
 * From: ni.edu.ejemplo_api.controllers
 * Created by: Sara Zambrana
 * On: 04/05/2026 at 18:07
 * All rights reserved 2026.
 */
@RestController
@RequestMapping("/api/personas")
public class PersonaController {

    @PostMapping
    public Map<String, String> validacionEdad(@RequestBody Persona persona) {
        Map<String, String> respuesta = new HashMap<>();

        respuesta.put("Nombre", persona.getNombre());
        if (persona.getEdad() >= 18) {
            respuesta.put("mensaje", "Es edad es mayor a 18");
        }
        else {
            respuesta.put("mensaje","Es menor de edad");
        }

        return respuesta;
    }

}
