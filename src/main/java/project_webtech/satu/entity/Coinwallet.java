package project_webtech.satu.entity;




import javax.persistence.*;

@Entity
@Table(name="coinwallets")
public class Coinwallet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private int id;
    @Column(name="coincurrency", nullable = false)
    private String coincurrency;
    @Column(name="coinvalue", nullable = false)
    private String coinvalue;

    public Coinwallet() {}

    public Coinwallet(String coincurrency, String coinvalue) {
        this.coincurrency = coincurrency;
        this.coinvalue = coinvalue;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    @Override
    public String toString() {
        return "Coinwallet{" +
                "id=" + id +
                ", coincurrency='" + coincurrency + '\'' +
                ", coinvalue='" + coinvalue + '\'' +
                '}';
    }
}
