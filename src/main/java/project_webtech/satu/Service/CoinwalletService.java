package project_webtech.satu.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Service;
import project_webtech.satu.entity.Coinwallet;
import project_webtech.satu.repository.CoinwalletRepository;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;


@Service
public class CoinwalletService {

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

    public Coinwallet save(Coinwallet coinwallet) {
        return this.coinwalletRepository.save(coinwallet);
    }


    public Coinwallet updateCoinwallet(Coinwallet coinwallet){
        Coinwallet existingCoinwallet = this.coinwalletRepository.findById((coinwallet.getId())).orElse(null);
        assert existingCoinwallet != null;
        existingCoinwallet.setCoincurrency(coinwallet.getCoincurrency());
        existingCoinwallet.setCoinvalue(coinwallet.getCoinvalue());
        return this.coinwalletRepository.save(existingCoinwallet);
    }
}