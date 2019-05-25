package pe.isil.anpreos.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Reo {

    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "reo_generator")
    @SequenceGenerator(name = "reo_generator", sequenceName = "reo_seq")
    @Id
    private Integer id;
    private String dni;
    private String nombre;
    private String primerApellido;
    private String segundoApellido;
    private String direccion;
    private String telefono;
    private LocalDate fechaNacimiento;

    @OneToMany(mappedBy = "reo", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Condena> condenas;

}
