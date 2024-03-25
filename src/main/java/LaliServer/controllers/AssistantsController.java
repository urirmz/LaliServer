package LaliServer.controllers;

import LaliServer.models.Assistant;
import LaliServer.services.AssistantsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="/api/assistant")
public class AssistantsController {

    @Autowired
    private AssistantsRepository assistantRepository;

    @PostMapping(path="/add") // Map ONLY POST Requests
    public @ResponseBody String addNewUser(
            @RequestParam String name,
            @RequestParam String phone,
            @RequestParam String confirmation,
            @RequestParam String message) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request

        Assistant newAssistant = new Assistant(
            name,
            phone,
            confirmation,
            message
        );
        assistantRepository.save(newAssistant);
        return "Saved";
    }

    @GetMapping(path="/all")
    public @ResponseBody Iterable<Assistant> getAllUsers() {
        // This returns a JSON or XML with the users
        return assistantRepository.findAll();
    }

}
