package kodlama.io.devs.dataaccess.abstracts;

import kodlama.io.devs.entities.concretes.ProgrammingTechnology;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProgrammingTechnologyRepository extends JpaRepository<ProgrammingTechnology, Long> {
}
