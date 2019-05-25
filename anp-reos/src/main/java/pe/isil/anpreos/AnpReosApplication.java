package pe.isil.anpreos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pe.isil.anpreos.model.Condena;
import pe.isil.anpreos.model.Delito;
import pe.isil.anpreos.model.Penal;
import pe.isil.anpreos.model.Reo;
import pe.isil.anpreos.repository.PenalRepository;
import pe.isil.anpreos.service.DelitoService;
import pe.isil.anpreos.service.PenalService;
import pe.isil.anpreos.service.ReoService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class AnpReosApplication implements CommandLineRunner {

    @Autowired
    ReoService reoService;

    @Autowired
    PenalService penalService;

    @Autowired
    DelitoService delitoService;

    public static void main(String[] args) {
        SpringApplication.run(AnpReosApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        Penal penal = new Penal();
        penal.setNombre("EP Tumbes");
        penal.setDireccion("Km 09 Carretera a Puerto Pizarro - Tumbes");
        penal.setTelefono("073-473270");

        Penal penal2 = new Penal();
        penal2.setNombre("EP Trujillo varones");
        penal2.setDireccion("Centro Poblado El Milagro - Trujillo altura Km. 56 de la Panamericana Norte");
        penal2.setTelefono("044-273624");

        Delito delito = new Delito();
        delito.setNombre("Robo Agravado");
        delito.setDescripcion("descripcion");

        Reo reo = new Reo();
        reo.setDni("87654321");
        reo.setNombre("Pedro");
        reo.setPrimerApellido("Lopez");
        reo.setSegundoApellido("Ramirez");
        reo.setDireccion("Av. Isaguirre 123, Lima");
        reo.setTelefono("234-2312");
        reo.setFechaNacimiento(LocalDate.of(1980, 2, 21));

        Condena condena = new Condena();
        condena.setFechaInicio(LocalDate.of(2011, 1,1));
        condena.setFechaFin(LocalDate.of(2013, 1,1));
        condena.setCumplioCondena(true);
        condena.setReo(reo);
        condena.setPenal(penal);
        condena.setDelito(delito);

        Condena condena2 = new Condena();
        condena2.setFechaInicio(LocalDate.of(2015, 4,3));
        condena2.setFechaFin(LocalDate.of(2025, 4,3));
        condena2.setCumplioCondena(false);
        condena2.setReo(reo);
        condena2.setDelito(delito);
        condena2.setPenal(penal2);

        List<Condena> condenas = new ArrayList<>();
        condenas.add(condena);
        condenas.add(condena2);

        reo.setCondenas(condenas);

        penalService.create(penal);
        penalService.create(penal2);
        delitoService.create(delito);

        reoService.create(reo);

    }
}
