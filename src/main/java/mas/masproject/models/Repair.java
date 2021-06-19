package mas.masproject.models;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "repair")
public class Repair {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long repairId;

    @ManyToOne
    @JoinColumn(name = "luthier_id")
    private Luthier luthier;

    @ManyToOne
    @JoinColumn(name = "instrument_id")
    private Instrument instrument;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    @Column(name = "description")
    private String description;

    @Column(name = "startDateTime")
    private LocalDateTime startDateTime;

    @Column(name = "finishDateTime")
    private LocalDateTime finishDateTime;

    @Column(name = "clientPhoneNum")
    private String clientPhoneNum;

    @Column(name = "finished")
    private boolean finished;


    @OneToOne(cascade = {CascadeType.MERGE,CascadeType.PERSIST})
    @JoinColumn(name = "rate_id")
    private Rate rate;

    public Repair() {
    }

    public Repair(Luthier luthier, Instrument instrument, Client client) {
        this.luthier = luthier;
        this.instrument = instrument;
        this.client = client;
    }

    public long getRepairId() {
        return repairId;
    }

    public void setRepairId(long repairId) {
        this.repairId = repairId;
    }

    public Luthier getLuthier() {
        return luthier;
    }

    public void setLuthier(Luthier luthier) {
        this.luthier = luthier;
    }

    public Instrument getInstrument() {
        return instrument;
    }

    public void setInstrument(Instrument instrument) {
        this.instrument = instrument;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getStartDateTime() {
        return startDateTime;
    }

    public void setStartDateTime(LocalDateTime startDateTime) {
        this.startDateTime = startDateTime;
    }

    public LocalDateTime getFinishDateTime() {
        return finishDateTime;
    }

    public void setFinishDateTime(LocalDateTime finishDateTime) {
        this.finishDateTime = finishDateTime;
    }

    public String getClientPhoneNum() {
        return clientPhoneNum;
    }

    public void setClientPhoneNum(String clientPhoneNum) {
        this.clientPhoneNum = clientPhoneNum;
    }

    public boolean isFinished() {
        return finished;
    }

    public Rate getRate() {
        return rate;
    }


    public void setRate(Rate rate) {
        if (this.rate == null || this.rate != rate){
            this.rate = rate;
            rate.setRepair(this);
        }
    }

    public void setFinished(boolean finished) {
        this.finished = finished;

        if (finished){
            setFinishDateTime(LocalDateTime.now());
        }
        else {
            setFinishDateTime(null);
        }
    }
}
