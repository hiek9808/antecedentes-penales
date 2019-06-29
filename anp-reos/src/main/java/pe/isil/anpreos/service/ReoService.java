package pe.isil.anpreos.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.isil.anpreos.model.Reo;
import pe.isil.anpreos.repository.ReoRepository;

import java.util.List;

@Service
public class ReoService implements BasicCrud<Reo, Integer> {

    @Autowired
    ReoRepository reoRepository;

    @Override
    public void create(Reo reo) {
        reoRepository.save(reo);
    }

    @Override
    public Reo update(Reo reo) {
        reoRepository.save(reo);
        return reo;
    }

    @Override
    public void delete(Reo reo) {
        reoRepository.delete(reo);
    }

    @Override
    public List<Reo> findAll() {
        return reoRepository.findAll();
    }

    @Override
    public Reo findById(Integer id) {
        return reoRepository.getOne(id);
    }

    public Reo findByDni(String dni){
        return reoRepository.findByDni(dni);
    }
}
