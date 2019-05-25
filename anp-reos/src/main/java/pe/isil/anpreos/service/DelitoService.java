package pe.isil.anpreos.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.isil.anpreos.model.Delito;
import pe.isil.anpreos.repository.DelitoRepository;

import java.util.List;

@Service
public class DelitoService implements BasicCrud<Delito, Integer> {

    @Autowired
    DelitoRepository delitoRepository;

    @Override
    public void create(Delito delito) {
        delitoRepository.save(delito);
    }

    @Override
    public Delito update(Delito delito) {
        delitoRepository.save(delito);
        return delito;
    }

    @Override
    public void delete(Delito delito) {
        delitoRepository.delete(delito);
    }

    @Override
    public List<Delito> findAll() {
        return delitoRepository.findAll();
    }

    @Override
    public Delito findById(Integer id) {
        return delitoRepository.getOne(id);
    }
}
