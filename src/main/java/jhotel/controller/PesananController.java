package jhotel.controller;
import jhotel.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.GregorianCalendar;

@RestController
public class PesananController {

    @RequestMapping("/pesanancustomer/{id_customer}")
    public Pesanan pesananCust(@PathVariable int id_customer) {
        Pesanan pesan = DatabasePesanan.getPesananAktif(DatabaseCustomer.getCustomer(id_customer));
        return pesan;
    }

    @RequestMapping("/pesanan/{id_pesanan}")
    public Pesanan getPesanan(@PathVariable int id_pesanan) {
        Pesanan pesan = DatabasePesanan.getPesanan(id_pesanan);
        return pesan;
    }

    @RequestMapping(value = "/bookpesanan", method = RequestMethod.POST)
    public Pesanan buatPesanan(@RequestParam(value="jumlah_hari") double jumlah_hari,
                               @RequestParam(value="id_customer") int id_customer,
                               @RequestParam(value="id_hotel") int id_hotel,
                               @RequestParam(value = "nomor_kamar") String nomor_kamar) {
        Pesanan pesan = new Pesanan(jumlah_hari, DatabaseCustomer.getCustomer(id_customer));

        try {
            DatabasePesanan.addPesanan(pesan);
            Administrasi.pesananDitugaskan(DatabasePesanan.getPesananAktif(DatabaseCustomer.getCustomer(id_customer)),
                    DatabaseRoom.getRoom(DatabaseHotel.getHotel(id_hotel), nomor_kamar));
            pesan.setTanggalPesan(new GregorianCalendar().getTime());
            Pesanan aktif = DatabasePesanan.getPesananAktif(DatabaseCustomer.getCustomer(id_customer));
        } catch(PesananSudahAdaException ex) {
            ex.getMessage();
            return null;
        };
        return pesan;
    }

    @RequestMapping(value = "/cancelpesanan", method = RequestMethod.POST)
    public Pesanan cancelPesanan(@RequestParam(value="id_pesanan") int id_pesanan){
        Administrasi.pesananDibatalkan(DatabasePesanan.getPesanan(id_pesanan));
        return DatabasePesanan.getPesanan(id_pesanan);
    }

    @RequestMapping(value = "/finishpesanan", method = RequestMethod.POST)
    public Pesanan finishPesanan(@RequestParam(value="id_pesanan") int id_pesanan){
        Administrasi.pesananSelesai(DatabasePesanan.getPesanan(id_pesanan));
        return DatabasePesanan.getPesanan(id_pesanan);
    }
}
