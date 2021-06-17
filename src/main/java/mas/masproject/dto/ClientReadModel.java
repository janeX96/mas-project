package mas.masproject.dto;

import mas.masproject.models.Client;

public class ClientReadModel {

    private String lastName;
    private String firstName;
    private String address;
    private String phoneNumber;

    public ClientReadModel(Client client) {
        this.firstName = client.getFirstName();
        this.lastName = client.getLastName();
        this.address = client.getAddress();
        this.phoneNumber = client.getPhoneNumber();
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}
