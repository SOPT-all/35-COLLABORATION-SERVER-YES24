package sopt.yes24.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "performances")
public class Performances {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "perform_id")
    private Long perform_id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ticket_id", nullable = false)
    private Ticket ticket;

    @Column(name = "audience_rating", length = 50)
    private String audienceRating;

    @Column(name = "viewing_time")
    private LocalDate viewingTime;

    @Column(name = "hyperlink", length = 255)
    private String hyperlink;

    public Performances() {

    }

    public Performances(Long perform_id, Ticket ticket, String audienceRating, LocalDate viewingTime, String hyperlink) {
        this.perform_id = perform_id;
        this.ticket = ticket;
        this.audienceRating = audienceRating;
        this.viewingTime = viewingTime;
        this.hyperlink = hyperlink;
    }

    public Long getPerformId() {
        return perform_id;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public String getAudienceRating() {
        return audienceRating;
    }

    public LocalDate getViewingTime() {
        return viewingTime;
    }

    public String getHyperlink() {
        return hyperlink;
    }
}

