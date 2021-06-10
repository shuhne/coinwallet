package project_webtech.satu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project_webtech.satu.entity.Coinwallet;

public interface CoinwalletRepository extends JpaRepository <Coinwallet, Integer> {

}
