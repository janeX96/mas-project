package mas.masproject.models;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "rate")
public class Rate {

    //stopień w zakresie 1-5
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "grade")
    private int grade;

    @Column(name = "rateDateTime")
    private LocalDateTime rateDateTime;

    @Column(name = "comment")
    private String comment;

    @OneToOne(mappedBy = "rate")
    private Repair repair;

    public Rate() {
    }


    public Rate(int grade, String comment) {
        //sprawdzenie czy ocena mieści się pomiędzy 1 a 5
        if(grade>5){
            this.grade = 5;
        }
        else if(grade<1){
            this.grade = 1;
        }
        else {
            this.grade = grade;
        }

        this.comment = comment;
        this.rateDateTime = LocalDateTime.now();
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public LocalDateTime getRateDateTime() {
        return rateDateTime;
    }

    public void setRateDateTime(LocalDateTime rateDateTime) {
        this.rateDateTime = rateDateTime;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Repair getRepair() {
        return repair;
    }

    public void setRepair(Repair repair) {
        if (this.repair == null || this.repair != repair){
            this.repair = repair;
            repair.setRate(this);
        }
    }


    @Override
    public String toString() {
        return "Rate{" +
                "grade=" + grade +
                ", rateDateTime=" + rateDateTime +
                ", comment='" + comment + '\'' +
                '}';
    }
}
