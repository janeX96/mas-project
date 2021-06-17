package mas.masproject.dto;

import mas.masproject.models.Client;

public class ClientReadModel {

    private String lastName;

    public ClientReadModel(Client client) {
        this.lastName = client.getLastName();
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
