package sopt.yes24.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

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
    private LocalDateTime viewingTime;

    public Performance() {

    }

    public Performance(Long performId, Ticket ticket, String audienceRating, LocalDateTime viewingTime) {
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

    public LocalDateTime getViewingTime() {
        return viewingTime;
    }
}

