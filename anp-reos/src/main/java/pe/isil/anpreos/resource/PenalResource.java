package pe.isil.anpreos.resource;

import com.sun.org.apache.regexp.internal.RE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.isil.anpreos.model.Penal;
import pe.isil.anpreos.service.PenalService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PenalResource {

    @Autowired
    PenalService penalService;

    @GetMapping("/penales")
    public ResponseEntity getAll(){
        List<Penal> penals = penalService.findAll();

        if (penals == null){
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(penals, HttpStatus.OK);
    }

    @GetMapping("/penales/{id}")
    public ResponseEntity getPenalById(@PathVariable Integer id){
        Penal penal = penalService.findById(id);

        if (penal == null){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(penal, HttpStatus.OK);
    }

    @PostMapping("/penales")
    public ResponseEntity createPenal(@RequestBody Penal penal){
        penalService.create(penal);
        return new ResponseEntity<>(penal, HttpStatus.CREATED);
    }

    @PutMapping("/penales/{id}")
    public ResponseEntity updatePenal(@PathVariable Integer id, @RequestBody Penal penal){
        Penal currentPenal = penalService.findById(id);
        if (currentPenal == null){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        penal.setId(currentPenal.getId());
        penalService.update(penal);
        return new ResponseEntity<>(penal, HttpStatus.OK);
    }

    @DeleteMapping("/penales/{id}")
    public ResponseEntity deletePenal(@PathVariable Integer id){
        Penal penal = penalService.findById(id);
        if (penal == null){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }

        penalService.delete(penal);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
