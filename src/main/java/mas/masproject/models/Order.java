package mas.masproject.models;

import java.time.LocalDateTime;

enum State{
    IN_PROGRESS, CANCELED, SHIPPED
}

public class Order {
    private LocalDateTime subDate;
    private LocalDateTime endDate;
    private State state;

    public Order(LocalDateTime subDate, LocalDateTime endDate, State state) {
        this.subDate = subDate;
        this.endDate = endDate;
        this.state = state;
    }

    //todo
    public double calc(){
        return 0;
    }


    public LocalDateTime getSubDate() {
        return subDate;
    }

    public void setSubDate(LocalDateTime subDate) {
        this.subDate = subDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }
}
