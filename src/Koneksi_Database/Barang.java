package Koneksi_Database;

import java.util.InputMismatchException;
import java.util.Scanner;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.*; 
 
public class Barang {
    static Connection conn;
    private int executeUpdate;

    
    // inputkan data
    public void inputData() throws SQLException, ClassNotFoundException{

        Scanner put = new Scanner (System.in);
        String url = "jdbc:mysql://localhost:3306/kasir";
        Class.forName("com.mysql.cj.jdbc.Driver");
		conn = DriverManager.getConnection(url,"root","");
		System.out.println("Class Driver ditemukan");
        System.out.println("No. Faktur      : ");
        String No_Faktur = put.nextLine();
        System.out.println("Nama Pembeli    : ");
        String Nama_Pembeli = put.nextLine();
        System.out.println("Kode_Barang    : ");
        String Kode_Barang = put.nextLine();
        System.out.println("Tanggal         : ");
        String Tanggal = put.nextLine();
        System.out.println("Banyak Barang             : ");
        Integer Jumlah = put.nextInt();
        System.out.println("Total Belanja   : ");
        Integer Total_Belanja = put.nextInt();

        String sql = "INSERT INTO transaksi (No_Faktur, Tanggal, Nama_Pembeli, Kode_Barang, Jumlah, Total_Belanja) VALUES ('"+No_Faktur+"','"+Tanggal+"','"+Nama_Pembeli+"', '"+Kode_Barang+"', '"+Jumlah+"','"+Total_Belanja+"')";
        Statement statement = conn.createStatement();
        statement.execute(sql);
        System.out.println("Berhasil input data");

    }

    public void View() throws SQLException, ClassNotFoundException{

        Scanner put = new Scanner (System.in);
        String url = "jdbc:mysql://localhost:3306/penjualan_pbo";
        Class.forName("com.mysql.cj.jdbc.Driver");
		conn = DriverManager.getConnection(url,"root","");
		System.out.println("Class Driver ditemukan");

        String text = "=======\nData Penjualan\n=======\n";
        System.out.println(text.toUpperCase());
        String sql ="SELECT * FROM transaksi";
		Statement statement = conn.createStatement();
		ResultSet result = statement.executeQuery(sql);
		
		while(result.next()){
			System.out.print("\nNo_Faktur\t: ");
            System.out.print(result.getString("No_Faktur"));
            System.out.print("\nTanggal\t: ");
            System.out.print(result.getString("Tanggal"));
            System.out.print("\nNama_Pembeli\t: ");
            System.out.print(result.getString("Nama_Pembeli"));
            System.out.print("\nKode_Barang\t: ");
            System.out.print(result.getString("Kode_Barang"));
            System.out.print("\nJumlah\t: ");
            System.out.print(result.getInt("Jumlah"));
            System.out.print("\nTotal_Belanja\t: ");
            System.out.print(result.getInt("Total_Belanja"));
            System.out.print("\n");
		}

    }


    public void Update() throws ClassNotFoundException, SQLException{

        Scanner terimaInput = new Scanner (System.in);
        String url = "jdbc:mysql://localhost:3306/penjualan_pbo";
        Class.forName("com.mysql.cj.jdbc.Driver");
		conn = DriverManager.getConnection(url,"root","");
		System.out.println("Class Driver ditemukan");

        String text = "\n===Ubah Data Penjualan===";
		System.out.println(text.toUpperCase());

        View();
        System.out.print("Masukkan No_Faktur yang Ingin diupdate : ");
        var No_Faktur = terimaInput.nextLine();

        String sql = "SELECT * FROM transaksi WHERE No_Faktur = " +No_Faktur;
            
        Statement statement = conn.createStatement();
        ResultSet result = statement.executeQuery(sql);

        if(result.next()){
                
            System.out.print("Nama_Pembeli ["+result.getString("Nama_Pembeli")+"]\t: ");
            String Nama_Pembeli = terimaInput.nextLine();

            System.out.print("Kode_Barang ["+result.getString("Kode_Barang")+"]\t: ");
            String Kode_Barang = terimaInput.nextLine();

            System.out.print("Tanggal ["+result.getString("Tanggal")+"]\t: ");
            String Tanggal = terimaInput.nextLine();
            

            System.out.print("Jumlah ["+result.getInt("Jumlah")+"]\t: ");
            Integer Jumlah = terimaInput.nextInt();

            System.out.print("Total_Belanja ["+result.getInt("Total_Belanja")+"]\t: ");
            Integer Total_Belanja = terimaInput.nextInt();
               
            sql = "UPDATE transaksi SET Tanggal='"+Tanggal+"', Nama_Pembeli= '"+Nama_Pembeli+"', Kode_Barang = '"+Kode_Barang+"', Jumlah='"+Jumlah+"',Total_Belanja='"+Total_Belanja+"' WHERE No_Faktur='"+No_Faktur+"'";
            if(statement.executeUpdate(sql) > 0){
                System.out.println("Berhasil memperbaharui data (No_Faktur "+No_Faktur+")");
            }
        }
        statement.close(); 


        }
        


    public  void hapusdata() throws ClassNotFoundException, SQLException {

        Scanner terimaInput = new Scanner (System.in);
        String url = "jdbc:mysql://localhost:3306/penjualan_pbo";
        Class.forName("com.mysql.cj.jdbc.Driver");
		conn = DriverManager.getConnection(url,"root","");
		System.out.println("Class Driver ditemukan");

		String text4 = "\n===Hapus Data===";
		System.out.println(text4.toUpperCase());
	
		
		try{
	        View();
	        System.out.print("Ketik No_Faktur yang akan Anda Hapus : ");
	        Integer No_Faktur= Integer.parseInt(terimaInput.nextLine());
	        
	        String sql = "DELETE FROM transaksi WHERE No_Faktur = "+ No_Faktur;
	        Statement statement = conn.createStatement();
	        //ResultSet result = statement.executeQuery(sql);
	        
	        if(statement.executeUpdate(sql) > 0){
	            System.out.println("Berhasil menghapus data transaksi (No_Faktur "+No_Faktur+")");
	        }
	   }catch(SQLException e){
	        System.out.println("Terjadi kesalahan dalam menghapus data barang");
	        }
		}

    public void Search() throws ClassNotFoundException, SQLException{

        Scanner terimaInput = new Scanner (System.in);
        String url = "jdbc:mysql://localhost:3306/penjualan_pbo";
        Class.forName("com.mysql.cj.jdbc.Driver");
		conn = DriverManager.getConnection(url,"root","");
		System.out.println("Class Driver ditemukan");

        String text5 = "\n===Cari Data Mahasiswa===";
		System.out.println(text5.toUpperCase());
		
				
		System.out.print("Masukkan No_Faktur : ");
        
		Integer keyword = terimaInput.nextInt();
        Statement statement = conn.createStatement();
        String sql = "SELECT * FROM transaksi WHERE No_Faktur LIKE '%"+keyword+"%'";
        ResultSet result = statement.executeQuery(sql); 
                
        while(result.next()){
        	System.out.print("\nNo_Faktur\t: ");
            System.out.print(result.getInt("No_Faktur"));
            System.out.print("\nTanggal\t: ");
            System.out.print(result.getString("Tanggal"));
            System.out.print("\nNama_Pembeli\t: ");
            System.out.print(result.getString("Nama_Pembeli"));
            System.out.print("\nKode_Barang\t: ");
            System.out.print(result.getString("Kode_Barang"));
            System.out.print("\nJumlah\t: ");
            System.out.print(result.getInt("Jumlah"));
            System.out.print("\nTotal_Belanja\t: ");
            System.out.print(result.getInt("Total_Belanja"));
            

    }

}}