package pe.isil.anpreos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.isil.anpreos.model.Penal;

@Repository
public interface PenalRepository extends JpaRepository<Penal, Integer> {
}
