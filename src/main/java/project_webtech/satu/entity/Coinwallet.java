package project_webtech.satu.entity;




import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name="coinwallets")
public class Coinwallet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "coincurrency")
    @Enumerated(value = EnumType.STRING)
    private Currency coincurrency;

    @Column(name = "coinvalue")
    private BigDecimal coinvalue;

    @Column(name = "owner")
    private String owner;

    @Column(name = "price")
    private BigDecimal price;

    public Coinwallet() {
    }

    public Coinwallet(long id, Currency coincurrency, BigDecimal coinvalue, String owner, BigDecimal price) {
        this.id = id;
        this.coincurrency = coincurrency;
        this.coinvalue = coinvalue;
        this.owner = owner;
        this.price = price;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Currency getCoincurrency() {
        return coincurrency;
    }

    public void setCoincurrency(Currency coincurrency) {
        this.coincurrency = coincurrency;
    }

    public BigDecimal getCoinvalue() {
        return coinvalue;
    }

    public void setCoinvalue(BigDecimal coinvalue) {
        this.coinvalue = coinvalue;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Coinwallet{" +
                "id=" + id +
                ", coincurrency=" + coincurrency +
                ", coinvalue=" + coinvalue +
                ", owner='" + owner + '\'' +
                ", price=" + price +
                '}';
    }
}


