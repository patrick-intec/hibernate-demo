package be.infernalwhale.model;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Table(name = "order_table")
public class Order {
    @Id
    @GeneratedValue
    private Integer id;
    private String order_number;
    @Transient
    private String order_client;
    private String order_delivery_address;
    @Column
    @NotNull
    @Min(1000)
    @Max(9999)
    private Integer order_delivery_postalcode;
    // not empty >> not a null value
    @NotNull
    private String order_delivery_city;
    private boolean is_vat_free;
    private boolean is_send;
    private Date order_date;
    @Column(name = "rank_column")
    private String rank;

    public Order() {

    }

    public Order(String s1, String s2, String s3) {
        this.order_number = s1;
        this.order_client = s2;
        this.order_delivery_address = s3;
    }

    public int getId() {
        return id;
    }

    public Order setId(int id) {
        this.id = id;
        return this;
    }

    public String getOrder_number() {
        return order_number;
    }

    public Order setOrder_number(String order_number) {
        this.order_number = order_number;
        return this;
    }

    public String getOrder_client() {
        return order_client;
    }

    public Order setOrder_client(String order_client) {
        this.order_client = order_client;
        return this;
    }

    public String getOrder_delivery_address() {
        return order_delivery_address;
    }

    public Order setOrder_delivery_address(String order_delivery_address) {
        this.order_delivery_address = order_delivery_address;
        return this;
    }

    public int getOrder_delivery_postalcode() {
        return order_delivery_postalcode;
    }

    public Order setOrder_delivery_postalcode(int order_delivery_postalcode) {
        this.order_delivery_postalcode = order_delivery_postalcode;
        return this;
    }

    public String getOrder_delivery_city() {
        return order_delivery_city;
    }

    public Order setOrder_delivery_city(String order_delivery_city) {
        this.order_delivery_city = order_delivery_city;
        return this;
    }

    public boolean isIs_vat_free() {
        return is_vat_free;
    }

    public Order setIs_vat_free(boolean is_vat_free) {
        this.is_vat_free = is_vat_free;
        return this;
    }

    public boolean isIs_send() {
        return is_send;
    }

    public Order setIs_send(boolean is_send) {
        this.is_send = is_send;
        return this;
    }

    public Date getOrder_date() {
        return order_date;
    }

    public Order setOrder_date(Date order_date) {
        this.order_date = order_date;
        return this;
    }

    public String getRank() {
        return rank;
    }

    public Order setRank(String rank) {
        this.rank = rank;
        return this;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", order_number='" + order_number + '\'' +
                ", order_client='" + order_client + '\'' +
                ", order_delivery_address='" + order_delivery_address + '\'' +
                ", order_delivery_postalcode=" + order_delivery_postalcode +
                ", order_delivery_city='" + order_delivery_city + '\'' +
                ", is_vat_free=" + is_vat_free +
                ", is_send=" + is_send +
                ", order_date=" + order_date +
                '}';
    }

    @PrePersist
    public void prepersist() {
        System.out.println("Just testing something");
    }
}
