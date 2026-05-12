package ni.edu.uam.registro_api.controladores;

import ni.edu.uam.registro_api.modelos.Carrera;
import ni.edu.uam.registro_api.repository.CarreraRepo;
import ni.edu.uam.registro_api.servicios.CarreraService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Project: registro-api
 * From: ni.edu.uam.registro_api.controladores
 * Created by: Sara Zambrana
 * On: 11/05/2026 at 17:42
 * All rights reserved 2026.
 */

@RestController
@RequestMapping("/api/carreras")
public class CarreraController {

    private final CarreraService carreraService;

    public CarreraController(CarreraService carreraService) {
        this.carreraService = carreraService;
    }

    @GetMapping
    public List<Carrera> getAllCarrera(){
        return carreraService.getAllCarreras();
    }

    @GetMapping("/{id}")
    public Carrera getCarreraById(@PathVariable Long id){
        return carreraService.getCarreraById(id);
    }

    @PostMapping
    public Carrera save(@RequestBody Carrera carrera){
        return carreraService.saveCarrera(carrera);
    }

    @PutMapping("/{id}")
    public Carrera updateCarrera(@PathVariable Long id, @RequestBody Carrera carrera){
        carrera.setId(id);
        return carreraService.saveCarrera(carrera);
    }

    @DeleteMapping
    public void deleteCarrera(@PathVariable Long id){
        carreraService.deleteCarrera(id);
    }
}
