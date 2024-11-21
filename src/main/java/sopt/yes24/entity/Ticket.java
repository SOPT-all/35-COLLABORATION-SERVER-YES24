package sopt.yes24.entity;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "ticket")
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ticket_id")
    private Long ticketId;

    @Column
    private String title;

    @Column
    private String area;

    @Column
    private Date date;

    @Column
    private String img;

    @Column
    private String comment;

    @Column
    private int numberOfLikes;

    @Column
    private boolean likeStatus;

    @Column(name = "duration", length = 50)
    private String duration;

    @Column(name = "audience_rating", length = 50)
    private String audienceRating;

    @Column(name = "notice", length = 255)
    private String notice;

    @Column(name = "hypertext", length = 255)
    private String hypertext;

    @Column(name = "hyperlink", length = 255)
    private String hyperlink;

    @Column(name = "ticket_pricing", length = 255)
    private String ticketPricing;

    @Column(name = "period", length = 50)
    private String period;

    public Ticket() {

    }

    public Ticket(Long ticketId, String title, String area, Date date, String img, String comment, int numberOfLikes, boolean likeStatus) {
        this.ticketId = ticketId;
        this.title = title;
        this.area = area;
        this.date = date;
        this.img = img;
        this.comment = comment;
        this.numberOfLikes = numberOfLikes;
        this.likeStatus = likeStatus;
    }

    public Long getTicketId() {
        return ticketId;
    }

    public String getTitle() {
        return title;
    }

    public String getArea() {
        return area;
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

    public int getNumberOfLikes() {
        return numberOfLikes;
    }

    public boolean isLikeStatus() {
        return likeStatus;
    }

    public String getDuration() {
        return duration;
    }

    public String getAudienceRating() {
        return audienceRating;
    }

    public String getNotice() {
        return notice;
    }

    public String getHypertext() {
        return hypertext;
    }

    public String getHyperlink() {
        return hyperlink;
    }

    /*
     * R석 88,000원
     * S석 77,000원
     * A석 66,000원
     */
    public String getTicketPricing() {
        return ticketPricing;
    }

    public String getPeriod() {
        return period;
    }
}
