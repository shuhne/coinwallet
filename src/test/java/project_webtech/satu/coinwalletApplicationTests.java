package project_webtech.satu;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import project_webtech.satu.entity.Coinwallet;
import project_webtech.satu.repository.CoinwalletRepository;
import project_webtech.satu.service.CoinwalletService;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doReturn;

@SpringBootTest
class coinwalletApplicationTests {
	@Autowired
	private CoinwalletService testService;

	@MockBean
	private CoinwalletRepository testRepo;

	@Test
	@DisplayName("check if new wallets could be created")
	public void shouldRegisterFlashcardByOwnerWithNumberOfRegistration() {
		String user = "testuser@test.com";
		Coinwallet demo1= new Coinwallet();
		demo1.setOwner(user);
		Coinwallet demo2= new Coinwallet();
		demo2.setOwner(user);
		doReturn(List.of(demo1,demo2)).when(testRepo).findAll();
		List<Coinwallet> existing = testService.findAll(user);
		assertEquals(2, existing.size());
	}

}
