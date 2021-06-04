package mas.masproject.models;

import java.time.LocalDate;

public class Client extends Person {
    private String addres;
    private String phoneNumber;

    public Client(String firstName, String lastName, LocalDate birthDate) {
        super(firstName, lastName, birthDate);
    }
}
