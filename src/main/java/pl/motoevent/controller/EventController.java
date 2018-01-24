package pl.motoevent.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.core.support.EventPublishingRepositoryProxyPostProcessor;
import org.springframework.web.bind.annotation.*;
import pl.motoevent.entity.Event;
import pl.motoevent.entity.User;
import pl.motoevent.repository.EventRepository;

import java.util.List;

@RestController
@RequestMapping("/event")
public class EventController {

    @Autowired
    private EventRepository eventRepository;

    @PostMapping("/add")
    public String addEvent(@RequestBody Event event) {
        eventRepository.save(event);
        return "ok";
    }

    @GetMapping("/all")
    public List<Event> showAllEvents() {
        return this.eventRepository.findAll();
    }
}
