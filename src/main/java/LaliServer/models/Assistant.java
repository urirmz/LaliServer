package LaliServer.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Assistant {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String name;
    private String phone;
    private String confirmation;
    private String message;

    public Assistant(String name, String phone, String confirmation) {
        this.name = name;
        this.phone = phone;
        this.confirmation = confirmation;
    }

    public Assistant(String name, String phone, String confirmation, String message) {
        this.name = name;
        this.phone = phone;
        this.confirmation = confirmation;
        this.message = message;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getConfirmation() {
        return confirmation;
    }

    public String getMessage() {
        return message;
    }
}
