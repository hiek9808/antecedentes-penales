package pe.isil.anpreos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.isil.anpreos.model.Delito;

@Repository
public interface DelitoRepository extends JpaRepository<Delito, Integer> {
}
