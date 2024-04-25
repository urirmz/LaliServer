package LaliServer.services;

import LaliServer.models.Assistant;
import org.springframework.data.repository.CrudRepository;

public interface AssistantsRepository extends CrudRepository<Assistant, Long> {

}