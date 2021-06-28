package project_webtech.satu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import project_webtech.satu.entity.Coinwallet;
import project_webtech.satu.repository.CoinwalletRepository;
import project_webtech.satu.api.ExtAPIResponse;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


@Service
public class CoinwalletService {

    static final String EXCHANGE_API_URL = "https://coinlib.io/api/v1/coin?key=a8906e8639cef440&pref=EUR&symbol=";

    public CoinwalletService(RestTemplate restTemplate, CoinwalletRepository coinwalletRepository) {
        this.restTemplate = restTemplate;
        this.coinwalletRepository = coinwalletRepository;
    }

    private final RestTemplate restTemplate;
    @Autowired
    private CoinwalletRepository coinwalletRepository;






    public List<Coinwallet> findAll(String userEmail){
        var iterator = this.coinwalletRepository.findAll();
        var userWallets = new ArrayList<Coinwallet>();
        for(Coinwallet c : iterator){
            if(c.getOwner()!=null && c.getOwner().equals(userEmail)) userWallets.add(c);
        }
        return userWallets;
    }

    public Coinwallet updateCoinwallet(Coinwallet givenCoinwallet){
        Coinwallet existingCoinwallet = coinwalletRepository.findById(givenCoinwallet.getId()).orElseThrow(()-> new IllegalArgumentException("Can't find Entity for given ID: " + givenCoinwallet.getId()));
        assert existingCoinwallet != null;
        ResponseEntity<ExtAPIResponse> entity = restTemplate.getForEntity(EXCHANGE_API_URL+existingCoinwallet.getCoincurrency(), ExtAPIResponse.class);
        existingCoinwallet.setCoinvalue(givenCoinwallet.getCoinvalue());
        BigDecimal PriceResult = entity.getBody().getPrice().multiply(existingCoinwallet.getCoinvalue());
        existingCoinwallet.setPrice(PriceResult);
        return this.coinwalletRepository.save(existingCoinwallet);
    }

    public Coinwallet save(Coinwallet coinwallet) {
        return this.coinwalletRepository.save(coinwallet);
    }
}