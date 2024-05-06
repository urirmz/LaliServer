package LaliServer.controllers;

import LaliServer.models.Assistant;
import LaliServer.services.AssistantsRepository;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.net.URISyntaxException;

@RestController
@RequestMapping(path="/assistants")
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

    @GetMapping(path = "/all")
    public @ResponseBody ResponseEntity<byte[]> getAllUsers(HttpServletResponse response) throws IOException, URISyntaxException {
        Iterable<Assistant> allAssistants = assistantRepository.findAll();

        String fileContent = "Nombres,Teléfono,Confirmación,Mensaje\n";

        for (Assistant assistant : allAssistants) {
            String name = assistant.getName().replace(",", " ") + ",";
            String phone = assistant.getPhone().replace(",", " ") + ",";
            String confirmation = assistant.getConfirmation().replace(",", " ") + ",";
            String message = assistant.getMessage().replace(",", " ") + "\n";
            fileContent += name + phone + confirmation + message;
        }

        HttpHeaders fileHeaders = new HttpHeaders();
        fileHeaders.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        fileHeaders.setContentDispositionFormData("attachment", "ListaDeAsistentes.csv");

        byte[] csvFile = fileContent.getBytes();

        return new ResponseEntity<>(csvFile, fileHeaders, HttpStatus.OK);
    }

}
