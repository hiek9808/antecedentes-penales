package pe.isil.anpreos.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.isil.anpreos.model.Condena;
import pe.isil.anpreos.model.Penal;
import pe.isil.anpreos.model.Reo;
import pe.isil.anpreos.service.DelitoService;
import pe.isil.anpreos.service.PenalService;
import pe.isil.anpreos.service.ReoService;

import java.util.List;

@RequestMapping("/api")
@RestController
public class ReoResource {

    @Autowired
    private ReoService reoService;

    @Autowired
    PenalService penalService;

    @Autowired
    DelitoService delitoService;


    //lista de todos los reos
    @GetMapping("/reos")
    public ResponseEntity getAll(){
        List<Reo> reos = reoService.findAll();
        if(reos.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(reos, HttpStatus.OK);
    }

    //llamada del reo por su id
    @GetMapping("/reos/{id}")
    public ResponseEntity getReoById(@PathVariable Integer id){
        Reo reo = reoService.findById(id);
        if(reo == null){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(reo, HttpStatus.OK);
    }

    //creacion de un nuevo reo
    @PostMapping("/reos")
    public ResponseEntity createReo(@RequestBody Reo reo){
        for (Condena condena : reo.getCondenas()){
            condena.setReo(reo);
        }

        reoService.create(reo);
        return new ResponseEntity<>(reo, HttpStatus.CREATED);
    }

    //actualizacion de un reo por su id
    @PutMapping("/reos/{id}")
    public ResponseEntity updateReo(@PathVariable Integer id, @RequestBody Reo reo){
        Reo currentReo = reoService.findById(id);
        if(currentReo == null){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        reo.setId(currentReo.getId());
        for (Condena condena : reo.getCondenas()){
            condena.setReo(reo);
        }
        reoService.update(reo);
        return new ResponseEntity<>(reo, HttpStatus.OK);
    }

    //eliminacion de un reo por su id
    @DeleteMapping("/reos/{id}")
    public ResponseEntity deleteReo(@PathVariable Integer id){
        Reo currentReo = reoService.findById(id);
        if(currentReo == null){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        reoService.delete(currentReo);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
}
