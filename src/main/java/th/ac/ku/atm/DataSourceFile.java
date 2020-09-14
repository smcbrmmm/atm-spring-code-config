package th.ac.ku.atm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.util.FileCopyUtils;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class DataSourceFile implements DataSource {

    @Autowired
    ResourceLoader resourceLoader;
//    private String filename = ;
//
//    public DataSourceFile(@Value("${filename}")String filename) {
//        this.filename = @Value("${filename}";
//    }

    /**
     * Reads the customer numbers and pins
     * and initializes the bank accounts.
     */
    public Map<Integer,Customer> readCustomers() throws IOException {
        Map<Integer,Customer> customers = new HashMap<Integer,Customer>();
        Resource resource = resourceLoader.getResource("file:src/main/resources/accounts.txt");
        InputStream inputStream = resource.getInputStream();

        byte[] bdata = FileCopyUtils.copyToByteArray(inputStream);
        String data = new String(bdata, StandardCharsets.UTF_8);
//        System.out.println(data);

        String[] lines = data.split(System.getProperty("line.separator"));
//        System.out.println(lines[0]);
//        System.out.println(lines[1]);

        for(int i=0;i<lines.length;i++){
            String[] result = lines[i].split(" ");
            customers.put(Integer.parseInt(result[0]),new Customer(Integer.parseInt(result[0]),result[1],Integer.parseInt(result[2]),Integer.parseInt(result[3])));
        }

        return customers;
//        Map<Integer,Customer> customers = new HashMap<>();
//
//        customers.put(1,new Customer(1,"ขวัญ",1234,1000));
//        customers.put(2,new Customer(2,"พลอย",2345,2000));
//        customers.put(3,new Customer(3,"ฝน",3456,3000));
//
//        return customers;
    }
}
