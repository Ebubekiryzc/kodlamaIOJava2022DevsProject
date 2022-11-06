package kodlama.io.devs.dataaccess.abstracts;

import kodlama.io.devs.entities.concretes.ProgrammingTechnologyType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProgrammingTechnologyTypeRepository extends JpaRepository<ProgrammingTechnologyType, Long> {
}
