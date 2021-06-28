package project_webtech.satu.api;

import java.math.BigDecimal;

public class ExtAPIResponse {


    private String symbol;
    private String show_symbol;
    private String name;
    private String rank;
    private BigDecimal price;
    private String market_cap;
    private String total_volume_24h;
    private String low_24h;
    private String high_24h;
    private String delta_1h;
    private String delta_24h;
    private String delta_7d;
    private String delta_30d;


    public ExtAPIResponse() {
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getShow_symbol() {
        return show_symbol;
    }

    public void setShow_symbol(String show_symbol) {
        this.show_symbol = show_symbol;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }


    public String getMarket_cap() {
        return market_cap;
    }

    public void setMarket_cap(String market_cap) {
        this.market_cap = market_cap;
    }

    public String getTotal_volume_24h() {
        return total_volume_24h;
    }

    public void setTotal_volume_24h(String total_volume_24h) {
        this.total_volume_24h = total_volume_24h;
    }

    public String getLow_24h() {
        return low_24h;
    }

    public void setLow_24h(String low_24h) {
        this.low_24h = low_24h;
    }

    public String getHigh_24h() {
        return high_24h;
    }

    public void setHigh_24h(String high_24h) {
        this.high_24h = high_24h;
    }

    public String getDelta_1h() {
        return delta_1h;
    }

    public void setDelta_1h(String delta_1h) {
        this.delta_1h = delta_1h;
    }

    public String getDelta_24h() {
        return delta_24h;
    }

    public void setDelta_24h(String delta_24h) {
        this.delta_24h = delta_24h;
    }

    public String getDelta_7d() {
        return delta_7d;
    }

    public void setDelta_7d(String delta_7d) {
        this.delta_7d = delta_7d;
    }

    public String getDelta_30d() {
        return delta_30d;
    }

    public void setDelta_30d(String delta_30d) {
        this.delta_30d = delta_30d;
    }


    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}



