package project_webtech.satu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import project_webtech.satu.Service.CoinwalletService;
import project_webtech.satu.entity.Coinwallet;

import java.util.List;

@RestController
public class CoinwalletController {

    @Autowired
    private CoinwalletService coinwalletService;

    @GetMapping("/getcoinwallet")
    @ResponseStatus(HttpStatus.OK)
    public List<Coinwallet> getAllCoinwallets(){
        return this.coinwalletService.getAllCoinwallets();
    }

    @GetMapping("coinwallet/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Coinwallet getCoinwalletById(@PathVariable int id){
        return this.coinwalletService.getCoinwalletById(id);
    }

    @PostMapping("/savecoinwallet")
    @ResponseStatus(HttpStatus.OK)
    public Coinwallet saveCoinwallet(@RequestBody Coinwallet coinwallet){
        return this.coinwalletService.saveCoinwallet(coinwallet);
    }

    @PostMapping("/saveAllCoinWallets")
    @ResponseStatus(HttpStatus.OK)

    public List<Coinwallet> saveAllCoinwallets(@RequestBody List<Coinwallet> coinwallet){
        return this.coinwalletService.saveAllCoinwallets(coinwallet);
    }

    @DeleteMapping("/coinwallet/delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    // ggf. sichern (nicht public)
    public String deleteCoinwalletById(@PathVariable int id){
        return this.coinwalletService.deleteCoinwalletById(id);
    }

    @PutMapping("/coinwallet/update/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Coinwallet updateCoinwallet(@RequestBody Coinwallet coinwallet){
        return this.coinwalletService.updateCoinwallet(coinwallet);
    }
}
