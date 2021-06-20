package mas.masproject.dto;

import mas.masproject.models.Instrument;
import mas.masproject.models.MusicAlbum;
import mas.masproject.models.Product;
import mas.masproject.models.enums.AlbumType;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

public class ProductReadModel {

    private long id;
    private double prize;
    private int count;
    public String type;
    private String name;
    private String producer;
    private boolean electronic;

    private String title;
    private String performer;
    private int pubYear;
    private int length;
    private AlbumType mediaType;

    public ProductReadModel(Product product) {
        this.id = product.getProductId();
        this.count = product.getCount();
        this.prize = product.getPrize();
        this.type = product.getType();
        if (product.getType().contains("Instrument")){
            this.electronic = ((Instrument)product).isElectronic();
            this.producer = ((Instrument)product).getProducer();
            this.name = ((Instrument)product).getName();
       }else
           if (product.getType().contains("MusicAlbum")) {
               this.title = ((MusicAlbum) product).getTitle();
               this.performer = ((MusicAlbum) product).getPerformer();
               this.length = ((MusicAlbum) product).getLength();
               this.mediaType = ((MusicAlbum) product).getMediaType();
           }
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getPrize() {
        return prize;
    }

    public void setPrize(double prize) {
        this.prize = prize;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public boolean isElectronic() {
        return electronic;
    }

    public void setElectronic(boolean electronic) {
        this.electronic = electronic;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPerformer() {
        return performer;
    }

    public void setPerformer(String performer) {
        this.performer = performer;
    }

    public int getPubYear() {
        return pubYear;
    }

    public void setPubYear(int pubYear) {
        this.pubYear = pubYear;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public AlbumType getMediaType() {
        return mediaType;
    }

    public void setMediaType(AlbumType mediaType) {
        this.mediaType = mediaType;
    }

    @Override
    public String toString() {

        String info = "";

        if (this.type.equals("Instrument")){
            info =  name +
                    ", producent: " + producer +
                    ", elektr: " + (isElectronic() ? "tak" : "nie");
        }
        else
            if (this.type.equals("MusicAlbum")){
                info = title+
                        ", wykonawca: " + performer +
                        ", rok: " + pubYear +
                        ", " + (length > 0 ? " długość: " + length + ", " : "") +
                        "nośnik: " + mediaType;
            }

            info += ", cena: " + prize + " zł";
            return info;
    }
}
