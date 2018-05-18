package jhotel.controller;
import jhotel.Customer;
import jhotel.DatabaseCustomer;
import jhotel.DatabaseCustomerPostgre;
import jhotel.PelangganSudahAdaException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {

    @RequestMapping("/")
    public String indexPage(@RequestParam(value="name", defaultValue="world") String name) {
        return "Hello " + name;
    }

    @RequestMapping(value = "/newcustomer", method = RequestMethod.POST)
    public Customer newCust(@RequestParam(value="name") String name,
                            @RequestParam(value="email") String email,
                            @RequestParam(value="tahun", defaultValue="1997", required = false) int tahun,
                            @RequestParam(value = "password") String password) {
        Customer customer = new Customer(name, 3, 7, tahun, email, password, "photo");
        try {
            DatabaseCustomerPostgre.insertCustomer(name, email, password);
        } catch(Exception ex) {
            ex.getMessage();
            return null;
        };
        return customer;
    }

    @RequestMapping("/getcustomer/{id}")
    public Customer getCust(@PathVariable int id) {
        Customer customer = DatabaseCustomer.getCustomer(id);
        return customer;
    }

    @RequestMapping(value = "/logincust", method = RequestMethod.POST)
    public Customer loginCust(@RequestParam(value = "email") String email,
                              @RequestParam(value = "password") String password) {

        for(int i=1; i<=DatabaseCustomerPostgre.getLastCustomerId(); i++) {
            Customer pelanggan = DatabaseCustomerPostgre.getCustomer(i);
            Customer customer = new Customer(pelanggan.getNama(), 3, 7, 1997, pelanggan.getEmail(), pelanggan.getPassword(), pelanggan.getPhoto());
            try {
                DatabaseCustomer.addCustomer(customer);
            }
            catch(Exception ex) {
                ex.getMessage();
            }
        }

        Customer customer = DatabaseCustomer.getCustomerLogin(email, password);
        return customer;
    }

}