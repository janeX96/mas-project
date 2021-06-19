package mas.masproject.models;

import javax.persistence.*;
//
//@Entity
//@Table("stationary_sale")
public class StationarySale {

    @EmbeddedId
    private StationarySalePK id;

//    @ManyToOne
//    @MapsId("employer_id") //This is the name of attr in EmployerDeliveryAgentPK class
//    @JoinColumn(name = "EMPLOYER_ID")
//    private Employer employer;
//
//    @ManyToOne
//    @MapsId("deliveryAgent_id")
//    @JoinColumn(name = "DELIVERY_AGENT_ID")
//    private DeliveryAgent deliveryAgent;
//


}
