package jhotel.controller;
import jhotel.DatabaseHotel;
import jhotel.DatabaseRoom;
import jhotel.Room;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;

@RestController
public class RoomController {

    @RequestMapping("/vacantrooms")
    public ArrayList<Room> vacantRooms() {
        ArrayList<Room> kamar = DatabaseRoom.getVacantRooms();
        return kamar;
    }

    @RequestMapping("/room/{id_hotel}/{room_no}")
    public Room getRoom(@PathVariable int id_hotel, @PathVariable String room_no) {
        Room kamar = DatabaseRoom.getRoom(DatabaseHotel.getHotel(id_hotel), room_no);
        return kamar;
    }
}
