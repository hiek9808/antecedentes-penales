package pe.isil.anpreos.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@JsonIgnoreProperties({"reo", "handler"})
public class Condena {

    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "condena_generator")
    @SequenceGenerator(name = "condena_generator", sequenceName = "condena_seq")
    @Id
    private Integer id;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private Boolean cumplioCondena;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_reo")
    private Reo reo;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_penal")
    private Penal penal;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_delito")
    private Delito delito;

}
