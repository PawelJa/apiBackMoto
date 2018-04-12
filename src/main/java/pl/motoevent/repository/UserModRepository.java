package pl.motoevent.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.motoevent.entity.UserModDetails;

public interface UserModRepository extends JpaRepository <UserModDetails, Long> {
}
