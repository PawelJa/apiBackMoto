package pl.motoevent.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.motoevent.entity.Event;
import pl.motoevent.entity.User;

import java.util.List;

public interface EventRepository extends JpaRepository<Event, Long> {

    @Query(value = "SELECT users_id FROM events_users WHERE Event_id = ?1", nativeQuery = true)
    List<User> findAllUsersInEvent(long id);

    @Query(value = "SELECT Event_id FROM events_users WHERE users_id = ?1", nativeQuery = true)
    List<Event> findAllEventsWhereUserIs(long id);

}
