package pl.motoevent.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.core.support.EventPublishingRepositoryProxyPostProcessor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import pl.motoevent.entity.Event;
import pl.motoevent.entity.User;
import pl.motoevent.repository.EventRepository;
import pl.motoevent.repository.UserRepository;
import pl.motoevent.security.UserPrincipal;

import java.util.List;

@RestController
@RequestMapping("/event")
public class EventController {

    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/add")
    public String addEvent(@RequestBody Event event) {
        eventRepository.save(event);
        return "ok";
    }

    @GetMapping("/all")
    public List<Event> showAllEvents(@AuthenticationPrincipal UserPrincipal principal) {
        if(principal == null) {
            System.out.println("niezalogowadfas");
        } else {
            System.out.println(principal.getUsername());
        }
        return this.eventRepository.findAll();
    }

    @GetMapping("/{id}")
    public Event showEventDetails(@PathVariable long id) {
        return this.eventRepository.findOne(id);
    }

    @GetMapping("/{id}/riders")
    public List<User> showAllRidersInEvent(@PathVariable long id) {
        Event event = new Event();
        event.setId(id);
        return this.userRepository.findAllUsersByEvents(event);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id) {
        this.eventRepository.delete(id);
    }

    @PostMapping("/{id}/joinEvent")
    public User addUserToEvent(@AuthenticationPrincipal UserPrincipal principal, @PathVariable long id) {
        Event one = this.eventRepository.findOne(id);
        String username = principal.getUsername();
        System.out.println(username);
        User user = userRepository.findByUsername(username);
        Long userId = user.getId();
        one.getUsers().add(user);
        eventRepository.save(one);
        return user;
    }

    @GetMapping("/all/{id}")
    public List<Event> getAllEvent(@PathVariable long id) {
        return this.eventRepository.findAllEventsWhereUserIs(id);
    }
}
