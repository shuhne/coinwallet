package project_webtech.satu.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project_webtech.satu.entity.Coinwallet;
import project_webtech.satu.repository.CoinwalletRepository;

import java.util.List;

@Service
public class CoinwalletService {

    @Autowired
    private CoinwalletRepository coinwalletRepository;


    public List<Coinwallet> getAllCoinwallets(){
        return this.coinwalletRepository.findAll();
    }

    public Coinwallet getCoinwalletById(int id){
        return this.coinwalletRepository.findById(id).orElse(null);
    }

    public Coinwallet saveCoinwallet(Coinwallet coinwallet){
        return this.coinwalletRepository.save(coinwallet);
    }

    public List<Coinwallet> saveAllCoinwallets(List<Coinwallet> coinwallets){
        return this.coinwalletRepository.saveAll(coinwallets);
    }

    public String deleteCoinwalletById(int id){
        this.coinwalletRepository.deleteById(id);
        return "coinwallet removed";
    }

    public Coinwallet updateCoinwallet(Coinwallet coinwallet){
        Coinwallet existingCoinwallet = this.coinwalletRepository.findById((coinwallet.getId())).orElse(null);
        existingCoinwallet.setCoincurrency(coinwallet.getCoincurrency());
        existingCoinwallet.setCoinvalue(coinwallet.getCoinvalue());
        return this.coinwalletRepository.save(existingCoinwallet);
    }
}