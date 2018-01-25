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
        return this.userRepository.findAllUsersInEvent(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id) {
        this.eventRepository.delete(id);
    }

    @PostMapping("/{id}/joinEvent")
    public void addUserToEvent(@PathVariable long id) {
        long userId=1;//TODO
        Event one = this.eventRepository.findOne(id);
        User user = new User();
        user.setId(userId);
        one.getUsers().add(user);
        eventRepository.save(one);
    }
}
