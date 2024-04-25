package LaliServer.models;

import jakarta.persistence.*;

@Entity
public class Assistant {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String name;
    private String phone;
    private String confirmation;
    private String message;

    public Assistant() {}
    public Assistant(String name, String phone, String confirmation, String message) {
        this.name = name;
        this.phone = phone;
        this.confirmation = confirmation;
        this.message = message;
    }

    public Assistant(String name, String phone, String confirmation) {
        this(name, phone, confirmation, "");
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

    public void setId() {}

    public void setName() {}

    public void setPhone() {}

    public void setConfirmation() {}

    public void setMessage() {}
}
