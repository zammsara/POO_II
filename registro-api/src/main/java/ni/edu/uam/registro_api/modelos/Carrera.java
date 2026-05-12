package ni.edu.uam.registro_api.modelos;

import jakarta.persistence.*;
import lombok.*;

/**
 * Project: registro-api
 * From: ni.edu.uam.registro_api.modelos
 * Created by: Sara Zambrana
 * On: 11/05/2026 at 17:20
 * All rights reserved 2026.
 */

@Entity
@Table(name="carreras")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Carrera {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id_carrera")
    private Long id;

    @Column(name="nombre_carrera",
            nullable=false,
            length = 100)
    private String nombre;

    @Column(name="descipcion_carrera",
            nullable=false,
            length = 255)
    private String descripcion;

    @Column(name="costo_carrera",
            nullable = false)
    private double costo;

}
