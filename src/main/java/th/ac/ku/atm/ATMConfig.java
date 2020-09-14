package th.ac.ku.atm;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;

@Configuration
public class ATMConfig {
    @Bean
    public DataSource dataSource(){
        return new DataSourceFile();
    }

    @Bean
    public Bank bank() throws IOException {
        return new Bank("Samut Bank - Code Config",dataSource());
    }

    @Bean
    public ATM atm() throws IOException {
        return new ATM(bank());
    }

}
