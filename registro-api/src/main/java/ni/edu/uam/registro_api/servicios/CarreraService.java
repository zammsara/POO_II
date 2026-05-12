package ni.edu.uam.registro_api.servicios;

import ni.edu.uam.registro_api.modelos.Carrera;
import ni.edu.uam.registro_api.repository.CarreraRepo;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Project: registro-api
 * From: ni.edu.uam.registro_api.servicios
 * Created by: Sara Zambrana
 * On: 11/05/2026 at 17:31
 * All rights reserved 2026.
 */

@Service
public class CarreraService {

    private final CarreraRepo carreraRepo;

    public CarreraService(CarreraRepo carreraRepo) {
        this.carreraRepo = carreraRepo;
    }

    public List<Carrera> getAllCarreras() {
        return carreraRepo.findAll();
    }

    public Carrera getCarreraById(Long id) {
        return carreraRepo.findById(id).orElse(null);
    }

    public Carrera saveCarrera(Carrera carrera) {
        return carreraRepo.save(carrera);
    }

    public void deleteCarrera(Long id) {
        carreraRepo.findById(id);
    }
}
