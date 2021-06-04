package WS.BLG.repository;

import WS.BLG.entities.Words;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DicRepository extends JpaRepository<Words,Long>, ICustomDicRepository {
}
