package LaliServer.controllers;

import LaliServer.models.Assistant;
import LaliServer.services.AssistantsRepository;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping(path="/api/assistant")
public class AssistantsController {

    @Autowired
    private AssistantsRepository assistantRepository;

    @PostMapping(path="/add")
    public @ResponseBody void addNewUser(HttpServletResponse response, @RequestParam String name, @RequestParam String phone,
    @RequestParam String confirmation, @RequestParam String message) throws IOException {
        Assistant newAssistant = new Assistant(
            name,
            phone,
            confirmation,
            message
        );
        assistantRepository.save(newAssistant);

        response.sendRedirect("/");
    }

    @GetMapping(path="/all.csv")
    //public @ResponseBody ResponseEntity<Resource> getAllUsers(HttpServletResponse response) throws IOException {
    public @ResponseBody void getAllUsers(HttpServletResponse response) throws IOException {
        Iterable<Assistant> allAssistants = assistantRepository.findAll();

        for (Assistant assistant : allAssistants) {

        }

        /*InputStreamResource resource = new InputStreamResource(new FileInputStream(file));

        return ResponseEntity.ok()
                .headers(headers)
                .contentLength(file.length())
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .body(resource);*/
    }

}
