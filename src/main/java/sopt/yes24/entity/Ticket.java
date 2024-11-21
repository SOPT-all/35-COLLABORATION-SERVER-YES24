package sopt.yes24.entity;

import jakarta.persistence.*;
import java.util.Date;

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
    private String area_detail;

    @Column
    private Date date;

    @Column
    private String img;

    @Column
    private String comment;

    @Column
    private int number_of_likes;

    @Column
    private boolean like_status;

    @Column(name = "duration", length = 50)
    private String duration;

    @Column(name = "audience_rating", length = 50)
    private String audience_rating;

    @Column(name = "notice", length = 255)
    private String notice;

    @Column(name = "hypertext", length = 255)
    private String hypertext;

    @Column(name = "hyperlink", length = 255)
    private String hyperlink;

    @Column(name = "ticket_pricing", length = 255)
    private String ticket_pricing; 

    public Ticket() {

    }

    public Ticket(Long ticket_id, String title, String area, Date date, String img, String comment, int number_of_likes, boolean like_status) {
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

    public String getArea_detail() {
        return area_detail;
    }

    public Date getDate() {
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

    public String getDuration() {
        return duration;
    }

    public String getAudience_rating() {
        return audience_rating;
    }

    public String getNotice() {
        return notice;
    }

    public boolean getLike_status() {
        return like_status;
    }
    public String getHyperlink() {
        return hyperlink;
    }

    public String getHypertext() {
        return hypertext;
    }

    /*
     * R석 88,000원
     * S석 77,000원
     * A석 66,000원
     */
    public String getTicket_pricing() {
        return ticket_pricing;
    }
}
