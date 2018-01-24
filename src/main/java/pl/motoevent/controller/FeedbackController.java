package pl.motoevent.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.motoevent.entity.Event;
import pl.motoevent.entity.Feedback;
import pl.motoevent.entity.User;
import pl.motoevent.repository.EventRepository;
import pl.motoevent.repository.FeedbackRepository;
import pl.motoevent.repository.UserRepository;

import java.util.List;

@RestController
@RequestMapping("/feedback")
public class FeedbackController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private FeedbackRepository feedbackRepository;

    @Autowired
    private EventRepository eventRepository;

    @GetMapping("/add")
    public void addFeedback() {
        User user = userRepository.findOne(2L);
        Event event = eventRepository.findOne(3L);
        Feedback feedback = new Feedback();
        feedback.setUser(user);
        feedback.setEvent(event);
        feedback.setDateAdd("2014-05-03");
        feedback.setDescription("opis");
        feedbackRepository.save(feedback);
    }

    @GetMapping("/all")
    public List<Feedback> getAll() {
        return feedbackRepository.findAll();
    }
}
