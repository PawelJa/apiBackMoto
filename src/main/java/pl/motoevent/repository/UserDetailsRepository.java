package pl.motoevent.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import pl.motoevent.entity.UserDetails;

public interface UserDetailsRepository extends JpaRepository<UserDetails, Long> {
}
