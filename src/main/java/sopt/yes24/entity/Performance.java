package sopt.yes24.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "performances")
public class Performance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "perform_id")
    private Long performId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ticket_id", nullable = false)
    private Ticket ticket;

    @Column(name = "viewing_time")
    private LocalDate viewingTime;

    public Performance() {

    }

    public Performance(Long performId, Ticket ticket, String audienceRating, LocalDate viewingTime) {
        this.performId = performId;
        this.ticket = ticket;
        this.viewingTime = viewingTime;
    }

    public Long getPerformId() {
        return performId;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public LocalDate getViewingTime() {
        return viewingTime;
    }
}

