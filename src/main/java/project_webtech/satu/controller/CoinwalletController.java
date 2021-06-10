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

    @GetMapping("/coinwallet")
    @ResponseStatus(HttpStatus.OK)
    public List<Coinwallet> getAllCoinwallets(){
        return this.coinwalletService.getAllCoinwallets();
    }

    @GetMapping("coinwallet/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Coinwallet getCoinwalletById(@PathVariable Long id){
        return this.coinwalletService.getCoinwalletById(id);
    }

    @PostMapping("/flashcards/save")
    @ResponseStatus(HttpStatus.OK)
    public Coinwallet saveCoinwallet(@RequestBody Coinwallet coinwallet){
        return this.coinwalletService.saveCoinwallet(coinwallet);
    }

    @PostMapping("/flashcards/save/all")
    @ResponseStatus(HttpStatus.OK)
    public List<Coinwallet> saveAllCoinwallets(@RequestBody List<Coinwallet> coinwallets){
        return this.coinwalletService.saveAllCoinwallets(coinwallets);
    }

    @DeleteMapping("/flashcards/delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    public String deleteCoinwalletById(@PathVariable Long id){
        return this.coinwalletService.deleteCoinwalletById(id);
    }

    @PutMapping("/flashcards/update/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Coinwallet updateCoinwallet(@RequestBody Coinwallet coinwallet){
        return this.coinwalletService.updateCoinwallet(coinwallet);
    }
}
