import java.util.Scanner;

public class pp01_ATM {
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

    final String kartNo="1234567890123456";
    static Scanner scan= new Scanner(System.in);
    static String sifre="1234";
    static double bakiye=20000;




    public static void main(String[] args) {
    giris();


    }

    private static void giris() {
        System.out.println("Kart Numarasi Giriniz ");
        String kkartNo= scan.nextLine();
        System.out.println("Sife Giriniz");
        String kSifre= scan.next();
        kkartNo=kkartNo.replaceAll("\\s","");

        if (kSifre.equals(sifre) && kkartNo.equals(kkartNo)){
            System.out.println("ok");
            menu();
        }
    }

    private static void menu() {
        System.out.println("****** JAVABANKA HISGELDINIZ******\n" +
                "Yapmak Istediginiz Islemi Seciniz\n" +
                "1. Bakiye Sorgulama\n" +
                "2. Para Yatirma\n" +
                "3. Para Cekme\n" +
                "4. Para Gonderme\n" +
                "5. Sifre Degistirme\n" +
                "6. CIKIS");

        int secim = scan.nextInt();
        switch (secim){
            case 1:{ bakiyeSorgula();}
            case 2:{
                System.out.println("Yatirilacak Miktari Giriniz");
                double miktar=scan.nextDouble();
                paraYatirma(miktar);  }
            case 3:{
                System.out.println("Cekilecek Miktari Giriniz :");
                double miktar=scan.nextDouble();
                paracekme();
            }
            case 4:{        }
            case 5:{        }
            case 6:{        }

     }



}

    private static void paracekme() {
    }

    private static void paraYatirma(double miktar) {
        bakiye+=miktar;
        bakiyeSorgula();
        menu();

    }

    private static void bakiyeSorgula() {
        System.out.println("Bakiyeniz: " + bakiye);

    }
    }
