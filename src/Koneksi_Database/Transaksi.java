package Koneksi_Database;

import java.sql.SQLException;
import java.text.DateFormat;  
import java.text.SimpleDateFormat;
import java.util.*;

import javax.management.Query;  

public class Transaksi extends Barang implements Pembelian {

    Scanner input = new Scanner(System.in);
    Queue<Integer> x = new LinkedList<>();
    int ntr; 
    Integer antri;
    String noFaktur; 
    int jumlah; 
    Integer subTotal; 
    Integer hargaBarang;
    Integer diskon; 
    Integer totalharga; 
    String namaBarang; 
    String huruf;
    Boolean penjualan = true; 
    String pilih;
    


    @Override
    public void Queue() {
        System.out.println("ke-  : " +x.remove());
    }

    public void Antrian(){
        System.out.println("Masukkan Daya Tampung : ");
        this.ntr = input.nextInt();
        System.out.println("\n########################################\n");
        System.out.println("Daya Tampung Antrian : "+ this.ntr);
        System.out.println("\n########################################\n");
        for(int b = 0; b<ntr; b++){
            System.out.println("Antrian ke- : ");
            this.antri = input.nextInt();
            x.add(antri);
        }
        System.out.println("########################################");
        System.out.println("Antrian saat ini: " + x);
        System.out.println("########################################");

        }


    @Override
    public void Menu() {
        while(penjualan){
            System.out.println("Pilihan : ");
            System.out.println("1. Input Nomor Faktur");
            System.out.println("2. Keterangan Barang");
            System.out.println("3. Cek Diskon");
            System.out.println("4. Fiks Total Harga");
            System.out.println("5. Cetak Faktur");
            System.out.println("\n\n");
            System.out.println("Masukkan Pilihan Anda : "); this.pilih = input.next();
            switch (pilih) {

                    case "1": noFaktur();
                    
                    break;

                    case "2": KetBarang(); 
                              subTotal();
                    
                    break;

                    case "3": Discount();
                    
                    break;

                    case "4": TotalHarga();
                    
                    break;

                    case "5": display();

                    
                    break;
                default: System.err.println("\nInput anda tidak ditemukan\nSilakan pilih [1-5]");
                
            }
           
            System.out.println("Masukkan Pilihan Selanjutnya ? [ y/n ]");
            this.pilih = input.next();
			penjualan = this.pilih.equalsIgnoreCase("y");
            //System.out.println("");
            
        } 

        System.out.println("Sampai Jumpa Kembali :) ");
        
    }

    private String getTanggal() {  
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd 'pada' hh:mm:ss a zzz");  
        Date date = new Date();  
        return dateFormat.format(date);  
    }  
   
    public String noFaktur(){

        this.noFaktur = noFaktur;
        System.out.println("======================================\n");
        System.out.println("Nomor Faktur Pelanggan : ");
        this.noFaktur= input.next();
        System.out.println("======================================\n");

        return noFaktur;
    }

    public void KetBarang(){
        this.hargaBarang = hargaBarang;
        this.jumlah = jumlah;
        System.out.println("Masukkan Nama Barang : ");
        this.namaBarang = input.next();
        System.out.println("\nHarga Barang : ");
        this.hargaBarang=input.nextInt();
        System.out.println("\n");
        System.out.println("Jumlah barang : ");
        this.jumlah = input.nextInt();

    }

    public void subTotal(){

        System.out.println("\n=========================================================\n");
        this.subTotal= this.hargaBarang*this.jumlah;
        System.out.println("Sub Total : "+this.subTotal);
        System.out.println("\n=========================================================\n");

    }

    public Integer Discount() {
        /* 
        1. 60.000 - 500.000 = 10%
        2. 500.000 - 1.000.000 = 15%
        3. 1.000.000 - 1.500.000 = 20%
        4. 1.500.000 - 2.000.000 = 25%
        5. >=2.000.000 = 30%
        */
       diskon = this.diskon;
 
       if(subTotal>=60000 && subTotal<500000){
           diskon = subTotal/100;
           System.out.println("\n=========================================================\n");
           System.out.println("Selamat Anda Mendapatkan Diskon 10%");
           System.out.println("\n=========================================================\n");
       }
       else if(subTotal>=500000 && subTotal<1000000){
           diskon = subTotal*15/100;
           System.out.println("\n=========================================================\n");
           System.out.println("Selamat Anda Mendapatkan Diskon 15%");
           System.out.println("\n=========================================================\n");
       }
       else if(subTotal>=1000000 && subTotal<1500000){
         diskon =subTotal*20/100;
         System.out.println("\n=========================================================\n");
         System.out.println("Selamat Anda Mendapatkan Diskon 20%");
         System.out.println("\n=========================================================\n");
     }
     else if(subTotal>=1500000 && subTotal<2000000){
         diskon = subTotal*25/100;
         System.out.println("\n=========================================================\n");
         System.out.println("Selamat Anda Mendapatkan Diskon 25%");
         System.out.println("\n=========================================================\n");
     }
     else{
         diskon = subTotal*30/100;
         System.out.println("\n=========================================================\n");
         System.out.println("Selamat Anda Mendapatkan Diskon 30%");
         System.out.println("\n=========================================================\n");
     }
       return diskon;  
     }

    public Integer TotalHarga() {
        
        totalharga=subTotal-diskon;
        System.out.println("\n=====================\nTotal Belanja = " +totalharga +"\n=====================\n");
    return this.totalharga;
    }

    public void display(){

        System.out.println("\n=========================================================\n");
        System.out.println("                       FAKTUR PEMBELIAN                    \n");
        System.out.println("Tanggal       : "+getTanggal());
        System.out.println("No. Faktur    : "+this.noFaktur);
        System.out.println("Nama Barang   : "+ this.namaBarang);
        System.out.println("Jumlah Barang : " +this.jumlah);
        System.out.println("Sub Total     : " +this.subTotal);
        System.out.println("Discount      : " +this.diskon);
        System.out.println("\n=========================================================\n");
        System.out.println("TOTAL BELANJA : "+this.totalharga);
        System.out.println("\n=========================================================\n");

    }

}