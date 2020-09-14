package th.ac.ku.atm;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ATMConfig {
    @Bean
    public DataSource dataSource(){
        return new DataSourceWebAPI();
    }

    @Bean
    public Bank bank(){
        return new Bank("Samut Bank",dataSource());
    }

    @Bean
    public ATM atm(){
        return new ATM(bank());
    }

}
