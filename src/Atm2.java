import java.util.Scanner;

public class Atm2 {
    /*ATM
    Kullanicidan giriş için kart numarasi ve şifresini isteyin, eger herhangi birini yanlis girerse tekrar isteyin.
    Kart numarasi aralarda boşluk ile girerse de eger doğruysa kabul edin.
    Kart numarasi ve sifre dogrulanirsa kullanicinin yapabileceği işlemleri ekrana yazdirin,

    Menu listesinde Bakiye sorgula, para yatirma, para çekme, para gönderme, sifre değiştirme ve cikis islemleri olacaktır.

    Para çekme ve para gonderme işleminde mevcut bakiyeden buyuk para çekilemez,
    Para gönderme işleminde istenen iban TR ile baslamali ve toplam 26 karakterli olmali, eger değilse menü ekranina
    geri donsun.
    Sifre değiştirme işleminde mevcut şifreyi teyit ettikten sonra, sifre değişiklik işlemini yapmali,
    */

    final static String kartNo= "2012";
    static String sifre= "9999";
    static double bakiye=10000;
    static Scanner scan= new Scanner(System.in);
//---------------------------------------------------------------------------

/*
    public static void main(String[] args) {
        System.out.println("SAKINGELME Banka HosGeldiniz");
        giris();
        anaMenu();
    }

    private static void giris() {
        System.out.println("Giris Yapmak Icin Lutfen KartNo'sunu Giriniz : ");
        String girilenKartno = scan.nextLine();
        girilenKartno=girilenKartno.replaceAll("\\s","");
        System.out.println("Lutfen Sifrenizi Giriniz");
        String girilenSifre = scan.nextLine();
        if (girilenKartno.equals(kartNo) && girilenSifre.equals(sifre)) {
            anaMenu();
        } else {
            System.out.println("Yanlis Giris Yaptiniz");
            giris();
        }
    }



    private static void anaMenu() {
        System.out.println("Islem Yapmak Istediginiz Menu Icin Rakam Giriniz" +
                "\nBakiye Goruntuleme   -=>>    1 " +
                "\nPara Cekme           -=>>    2 " +
                "\nPara Yatirma         -=>>    3 " +
                "\nPara Gonderme        -=>>    4 " +
                "\nSifre Degistirme     -=>>    5 " +
                "\nCIKIS                -=>>    6 ");

        int giris = scan.nextInt();
        switch (giris){
            case 1:
               guncelBakiye();
            case 2:
                System.out.println("Lutfen Cekmek Istediginiz Miktari Giriniz : ");
                double miktar= scan.nextDouble();
               // paraCekme(miktar);
            case 3:
                System.out.println("Lutfen Yatirmak Istediginiz Miktari Giriniz : ");
                miktar= scan.nextDouble();
              //  paraYatirma(miktar);
            case 4:
                System.out.println("Gondermek Istediginiz IBAN'i Giriniz");
                String ibanNo=scan.nextLine();
                ibanKontrol(ibanNo);
                scan.nextLine();
                System.out.println("Gonderilecek Miktari Giriniz");
                miktar=scan.nextDouble();

                ibanKontrol(ibanNo);

            case 5:
            case 6:
                cikis();

        }


    }

    private static String ibanKontrol(String ibanNo) {
        ibanNo=ibanNo.replaceAll("\\s","");
        if (ibanNo.startsWith("TR") && ibanNo.length()== 26){

    }else{
        System.out.println("Gecerli IBAN giriniz");

    }


    private static void paraCekme(double miktar) {
        if(miktar<=bakiye){
            bakiye-=miktar;
            System.out.println("Hesabinizdan " + miktar + " cekildi. \n" + "Kalan Bakiyeniz :" + bakiye+"\n");
            anaMenu();
        }else {
            System.out.println("Yeterli Bakiyeniz Yoktur, Para Cekme Isleminiz Iptal Edilmistir.\n Ana Menu'den tekrar secim yapiniz ");
            anaMenu();
        }

    }

    //private static void paraYatirma(double miktar) {

        bakiye+=miktar;
        System.out.println(bakiye);
        anaMenu();
    }

    private static void cikis() {
        System.out.println("Tekrar Bekleriz- HoscakalinNN!!");
        System.exit(0);
    }

    private static void guncelBakiye() {
        System.out.println("Guncel Bakiyeniz --> "+bakiye+"\n");
        anaMenu();
        scan.nextLine();

    }*/
}
