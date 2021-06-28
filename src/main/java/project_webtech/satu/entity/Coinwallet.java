package project_webtech.satu.entity;




import javax.persistence.*;

@Entity
@Table(name="coinwallets")
public class Coinwallet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @Column(name="coincurrency")
    private String coincurrency;
    @Column(name="coinvalue")
    private String coinvalue;
    @Column(name="owner")
    private String owner;

    public Coinwallet() {}

    public Coinwallet(String coincurrency, String coinvalue) {
        this.coincurrency = coincurrency;
        this.coinvalue = coinvalue;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCoincurrency() {
        return coincurrency;
    }

    public void setCoincurrency(String coincurrency) {
        this.coincurrency = coincurrency;
    }

    public String getCoinvalue() {
        return coinvalue;
    }

    public void setCoinvalue(String coinvalue) {
        this.coinvalue = coinvalue;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    @Override
    public String toString() {
        return "Coinwallet{" +
                "id=" + id +
                ", coincurrency='" + coincurrency + '\'' +
                ", coinvalue='" + coinvalue + '\'' +
                '}';
    }
}
