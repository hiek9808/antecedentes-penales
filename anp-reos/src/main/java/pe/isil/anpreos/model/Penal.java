package pe.isil.anpreos.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@JsonIgnoreProperties({"condenas", "hibernateLazyInitializer", "handler"})
public class Penal {

    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "penal_generator")
    @SequenceGenerator(name = "penal_generator", sequenceName = "penal_seq")
    @Id
    private Integer id;
    private String nombre;
    private String direccion;
    private String telefono;

    @OneToMany(mappedBy = "penal", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Condena> condenas;
}
