package pe.isil.anpreos.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@JsonIgnoreProperties({"condenas", "handler"})
public class Delito {

    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "delito_generator")
    @SequenceGenerator(name = "delito_generator", sequenceName = "delito_seq")
    @Id
    private Integer id;
    private String nombre;
    private String descripcion;

    @OneToMany(mappedBy = "delito", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Condena> condenas;
}
