package pe.isil.anpreos.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.isil.anpreos.model.Delito;
import pe.isil.anpreos.service.DelitoService;

import java.util.List;

@RequestMapping("/api")
@RestController
public class DelitoResource {

    @Autowired
    DelitoService delitoService;

    @GetMapping("/delitos")
    public ResponseEntity getAll(){
        List<Delito> delitos = delitoService.findAll();

        if (delitos == null){
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(delitos, HttpStatus.OK);
    }

    @GetMapping("/delitos/{id}")
    public ResponseEntity getDelitoById(@PathVariable Integer id){
        Delito delito = delitoService.findById(id);

        if (delito == null){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(delito, HttpStatus.OK);
    }
}
