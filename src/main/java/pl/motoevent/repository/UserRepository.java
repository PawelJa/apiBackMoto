package pl.motoevent.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import pl.motoevent.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);

}
