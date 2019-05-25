package pe.isil.anpreos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.isil.anpreos.model.Reo;

@Repository
public interface ReoRepository extends JpaRepository<Reo, Integer> {
}
