package jhotel.controller;
import jhotel.DatabaseHotel;
import jhotel.Hotel;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;

@RestController
public class HotelController {

    @RequestMapping("/hotel")
    public ArrayList<Hotel> hotelsList() {
        ArrayList<Hotel> hotel = DatabaseHotel.getHotelDatabase();
        return hotel;
    }

    @RequestMapping("/hotel/{id_hotel}")
    public Hotel getHotel(@PathVariable int id_hotel) {
        Hotel hotel = DatabaseHotel.getHotel(id_hotel);
        return hotel;
    }
}
