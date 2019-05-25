package pe.isil.anpreos.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.isil.anpreos.model.Penal;
import pe.isil.anpreos.repository.PenalRepository;

import java.util.List;

@Service
public class PenalService implements BasicCrud<Penal, Integer> {

    @Autowired
    PenalRepository penalRepository;

    @Override
    public void create(Penal penal) {
        penalRepository.save(penal);
    }

    @Override
    public Penal update(Penal penal) {
        penalRepository.save(penal);
        return penal;
    }

    @Override
    public void delete(Penal penal) {
        penalRepository.delete(penal);
    }

    @Override
    public List<Penal> findAll() {
        return penalRepository.findAll();
    }

    @Override
    public Penal findById(Integer id) {
        return penalRepository.getOne(id);
    }
}
