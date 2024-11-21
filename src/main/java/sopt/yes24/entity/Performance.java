package sopt.yes24.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "performances")
public class Performance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "perform_id")
    private Long perform_id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ticket_id", nullable = false)
    private Ticket ticket;

    @Column(name = "viewing_time")
    private LocalDate viewingTime;

    public Performance() {

    }

    public Performance(Long perform_id, Ticket ticket, String audienceRating, LocalDate viewingTime) {
        this.perform_id = perform_id;
        this.ticket = ticket;
        this.viewingTime = viewingTime;
    }

    public Long getPerformId() {
        return perform_id;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public LocalDate getViewingTime() {
        return viewingTime;
    }
}

