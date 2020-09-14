package th.ac.ku.atm;

import java.io.IOException;
import java.util.Map;

public interface DataSource {
    Map<Integer,Customer> readCustomers() throws IOException;
}
