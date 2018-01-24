package pl.motoevent.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.motoevent.entity.Event;
import pl.motoevent.entity.User;

public interface EventRepository extends JpaRepository<Event, Long> {

}
