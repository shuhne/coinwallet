package project_webtech.satu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import project_webtech.satu.Service.CoinwalletService;
import project_webtech.satu.entity.Coinwallet;

import java.util.List;

@RestController
public class CoinwalletController {

    @Autowired
    private CoinwalletService coinwalletService;

    @GetMapping("/getcoinwallet")
    @ResponseStatus(HttpStatus.OK)
    public List<Coinwallet> getAllCoinwallets(@AuthenticationPrincipal OidcUser user){
        return this.coinwalletService.findAll(user.getEmail());
    }


    @PostMapping("/createcoinwallet")
    @ResponseStatus(HttpStatus.OK)
    public Coinwallet createCoinwallet(@AuthenticationPrincipal OidcUser user, @RequestBody Coinwallet coinwallet){
        coinwallet.setOwner(user.getEmail());
        return this.coinwalletService.save(coinwallet);
    }

    @PutMapping("/updateexchange/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Coinwallet updateExchangeRate(@AuthenticationPrincipal OidcUser user, @RequestBody Coinwallet coinwallet){
        return this.coinwalletService.updateCoinwallet(coinwallet);
    }
}
