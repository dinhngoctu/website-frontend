package WS.BLG.repository;

import WS.BLG.entities.WordEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DicRepository extends JpaRepository<WordEntity,Long>, ICustomDicRepository {
    Optional<WordEntity> findWordsBySearchValueAndTypeDicAndUserId(String searchValue, Integer typeDict, Long userId);
}
