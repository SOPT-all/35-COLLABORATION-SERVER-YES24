package sopt.yes24.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "ticket")
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ticket_id;

    @Column
    private String title;

    @Column
    private String area;

    @Column
    private LocalDate date;

    @Column
    private String img;

    @Column
    private String comment;

    @Column
    private int number_of_likes;

    @Column
    private boolean like_status;

    public Ticket() {

    }

    public Ticket(Long ticket_id, String title, String area, LocalDate date, String img, String comment, int number_of_likes, boolean like_status) {
        this.ticket_id = ticket_id;
        this.title = title;
        this.area = area;
        this.date = date;
        this.img = img;
        this.comment = comment;
        this.number_of_likes = number_of_likes;
        this.like_status = like_status;
    }

    public Long ticket_id() {
        return ticket_id;
    }

    public String getTitle() {
        return title;
    }

    public String getArea() {
        return area;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getImg() {
        return img;
    }

    public String getComment() {
        return comment;
    }

    public int getNumber_of_likes() {
        return number_of_likes;
    }

    public boolean getLike_status() {
        return like_status;
    }
}
