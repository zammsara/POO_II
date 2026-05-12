package ni.edu.uam.registro_api.repository;

import ni.edu.uam.registro_api.modelos.Carrera;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Project: registro-api
 * From: ni.edu.uam.registro_api.repository
 * Created by: Sara Zambrana
 * On: 11/05/2026 at 17:28
 * All rights reserved 2026.
 */

public interface CarreraRepo extends JpaRepository<Carrera, Long> {

    Long id(Long id);
}
