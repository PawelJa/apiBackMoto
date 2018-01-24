package pl.motoevent.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.motoevent.entity.Feedback;

public interface FeedbackRepository extends JpaRepository<Feedback, Long> {
}
