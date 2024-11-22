package sopt.yes24.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "seat_availabilities")
public class SeatAvailability {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "seat_id")
    private Long seatId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "perform_id", nullable = false)
    private Performance performance;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ticket_id", nullable = false)
    private Ticket ticket;

    @Column(name = "seat_type", length = 255)
    private String seatType;

    @Column(name = "total_seats")
    private Integer totalSeats;

    @Column(name = "seats_price", length = 255)
    private String seatsPrice;

    public SeatAvailability() {
    }

    public SeatAvailability(Long seatId, Performance performance, Ticket ticket, String seatType, Integer totalSeats, String seatsPrice) {
        this.seatId = seatId;
        this.performance = performance;
        this.ticket = ticket;
        this.seatType = seatType;
        this.totalSeats = totalSeats;
        this.seatsPrice = seatsPrice;
    }

    public Long getSeatId() {
        return seatId;
    }

    public Performance getPerformances() {
        return performance;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public String getSeatType() {
        return seatType;
    }

    public Integer getTotalSeats() {
        return totalSeats;
    }

    public String getSeatsPrice() {
        return seatsPrice;
    }
}
