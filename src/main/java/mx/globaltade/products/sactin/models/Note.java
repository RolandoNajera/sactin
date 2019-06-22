package mx.globaltade.products.sactin.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Entity
@Table(name = "notes")
public class Note {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String noteNumber;

    private String inputDate;

    private String outputDate;

    private String deliveryDate;

    private Long totalPieces;

    private String totalAmount;

    private String comments;

    private String createAt;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @PrimaryKeyJoinColumn
    private Profile profile;

    public Note() {
        super();
    }

    public Note(Long id, String noteNumber, String inputDate, String outputDate, String deliveryDate, Long totalPieces, String totalAmount, String comments) {
        this.id = id;
        this.noteNumber = noteNumber;
        this.inputDate = inputDate;
        this.outputDate = outputDate;
        this.deliveryDate = deliveryDate;
        this.totalPieces = totalPieces;
        this.totalAmount = totalAmount;
        this.comments = comments;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNoteNumber() {
        return noteNumber;
    }

    public void setNoteNumber(String noteNumber) {
        this.noteNumber = noteNumber;
    }

    public String getInputDate() {
        return inputDate;
    }

    public void setInputDate(String inputDate) {
        this.inputDate = inputDate;
    }

    public String getOutputDate() {
        return outputDate;
    }

    public void setOutputDate(String outputDate) {
        this.outputDate = outputDate;
    }

    public String getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(String deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public Long getTotalPieces() {
        return totalPieces;
    }

    public void setTotalPieces(Long totalPieces) {
        this.totalPieces = totalPieces;
    }

    public String getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(String totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public String getCreateAt() {
        return createAt;
    }

    public void setCreateAt(String createAt) {
        this.createAt = createAt;
    }

    @PrePersist
    public void prePersis() {
        this.createAt = LocalDateTime.now()
                .format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS"));
    }
}
