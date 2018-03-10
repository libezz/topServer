package topServer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import topServer.entity.BasePO;

public interface BaseRepository<T extends BasePO> extends JpaRepository<T, Long> {

}
