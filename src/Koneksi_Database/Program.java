package Koneksi_Database;

import java.sql.Connection;
import java.util.Scanner;  

public class Program {

    static Connection conn;

    public static void main(String[] args) throws Exception {
        
        Transaksi transaksi = new Transaksi();
        Scanner masukkan = new Scanner (System.in);
        int pilihan;
        transaksi.Antrian();
        
        while(transaksi.penjualan){
            transaksi.Queue();
            while (transaksi.penjualan) {

                System.out.println("\n1.Transaksi\n2.Input db\n3.Ubah Data db\n4.Hapus Data db\n5.Cari Data db\n6.View Data db");
            pilihan = masukkan.nextInt();
            switch (pilihan) {

                case 1:
                transaksi.Menu();
                    
                    break;

                case 2:
                transaksi.inputData();
                    
                    break;
                    
                case 3:
                transaksi.Update();
                    
                    break;
                    
                case 4:
                transaksi.hapusdata();
                    break;
                    
                case 5:
                transaksi.Search();
                    
                    break;
                    
                case 6:
                transaksi.View();
                    
                    break;

                default:
                System.err.println("\nInputkan angka 1-6");

                    break;
            }
        System.out.println("Lanjutkan  ? [ y/n ]");
        transaksi.pilih = transaksi.input.next();
		transaksi.penjualan = transaksi.pilih.equalsIgnoreCase("y");
            }
        System.out.println("Input Pembelian Berikutnya ? [ y/n ]");
        transaksi.pilih = transaksi.input.next();
		transaksi.penjualan = transaksi.pilih.equalsIgnoreCase("y");
        } System.out.println();
    } 
}