package mas.masproject.models;

import mas.masproject.models.enums.AlbumType;

import javax.persistence.*;

@Entity
@Table(name = "music_album")
public class MusicAlbum extends Product{

    @Column(name = "title")
    private String title;
    @Column(name = "performer")
    private String performer;
    @Column(name = "pubYear")
    private int pubYear;
    //długość nagrania w minutach
    @Column(name = "length")
    private int length;

    @Enumerated(EnumType.STRING)
    @Column(name = "mediaType")
    private AlbumType mediaType;


    public MusicAlbum() {
    }

    public MusicAlbum(double prize, int count, String title, String performer, int pubYear, int length, AlbumType mediaType) {
        super(prize, count);
        this.title = title;
        this.performer = performer;
        this.pubYear = pubYear;
        this.length = length;
        this.mediaType = mediaType;
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
        return  title +
                ", wykonawca: " + performer +
                ", rok: " + pubYear +
                ", długość: " + length +
                ", nośnik: " + mediaType;
    }
}
