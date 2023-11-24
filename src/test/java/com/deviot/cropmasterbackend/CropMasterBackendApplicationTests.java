package com.deviot.cropmasterbackend;
import com.deviot.cropmasterbackend.account.domain.model.commands.CreateAccountCommand;
import com.deviot.cropmasterbackend.account.domain.model.commands.LogInCommand;
import com.deviot.cropmasterbackend.account.domain.services.AccountCommandService;
import com.deviot.cropmasterbackend.account.infrastructure.dtos.AuthResponse;
import com.deviot.cropmasterbackend.account.infrastructure.repositories.AccountRepository;
import com.deviot.cropmasterbackend.profile.interfaces.rest.dto.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
class CropMasterBackendApplicationTests {

	@MockBean
	private AccountRepository accountRepository;

	private AccountCommandService accountCommandService;

	@Test
	void testRegisterUser() {
		when(accountRepository.findByEmail(anyString())).thenReturn(null);

		CreateAccountCommand createAccountCommand = new CreateAccountCommand("correo@example.com", "123", "FARMER");

		AuthResponse response = this.accountCommandService.handle(createAccountCommand);

		assertNotNull(response);
		assertNotNull(response.getToken());

	}

	@Test
	void testLoginUser() {
		LogInCommand logInCommand = new LogInCommand("correo@example.com", "123");

		AuthResponse response = this.accountCommandService.handle(logInCommand);

		assertNotNull(response);
		assertNotNull(response.getToken());
	}

}
