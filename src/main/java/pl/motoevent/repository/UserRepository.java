package pl.motoevent.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.motoevent.entity.User;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    @Query(value = "SELECT users_id FROM events_users WHERE Event_id = ?1", nativeQuery = true)
    List<User> findAllUsersInEvent(long id);

    User findByUsername(String username);

}
