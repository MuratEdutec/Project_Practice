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

    final static String kartNo="1234567890123456";
    static Scanner scan= new Scanner(System.in);
    static String sifre="1234";
    static double bakiye=20000;




    public static void main(String[] args) {
    giris();
    }

    private static void giris() {
        System.out.println("Kart Numarasi Giriniz ");
        String kkartNo= scan.nextLine();
        scan.nextLine();
        System.out.println("Sife Giriniz");
        String kSifre= scan.next();
        kkartNo=kkartNo.replaceAll("\\s","");

        if (kSifre.equals(sifre) && kkartNo.equals(kartNo)){
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
                System.out.print("Yatirilacak Miktari Giriniz ");
                double miktar=scan.nextDouble();
                paraYatirma(miktar);  }
            case 3:{
                System.out.println("Cekilecek Miktari Giriniz : ");
                double miktar=scan.nextDouble();
                paracekme(miktar);
            }
            case 4:{
                System.out.println("IBAN GIRINIZ ");
                String iban=scan.nextLine();
                scan.nextLine();
                System.out.println("Gonderilecek Miktari Giriniz ");
                double miktar=scan.nextDouble();
                paraGonderme(ibanKontrol(iban), miktar);
            }
            case 5:{
                sifreDegistir();
            }
            case 6:{
                System.out.println("***** HOSCAKALIN *****");
                System.exit(0);
            }

     }
}

    private static void sifreDegistir() {
        System.out.println("Eski sifrenizi giriniz: ");
        String kSifre= scan.next();
        if (kSifre.equals(sifre)){
            System.out.println("Yeni sifresnizi giriniz");
            sifre= scan.next();
            giris();
        }else {
            System.out.println("Dogru Sifre Giriniz");
            sifreDegistir();
        }
    }


    //TR12 1213 1415 1516 1718 1920 22




    private static String ibanKontrol(String iban) {
        iban = iban.replaceAll("\\s", "");
        if (iban.startsWith("TR") && iban.length() == 26) {

        } else {
            System.out.println("GECERLI IBAN GIRINIZ: ");
            //String iban2 = scan.nextLine();
            //ibanKontrol(iban2);
            scan.nextLine();
            ibanKontrol(scan.nextLine());
        }
        return iban;
        }




































    private static void paraGonderme(String iban, double miktar) {

        if (miktar <= bakiye){
            bakiye -=miktar;
            System.out.println(iban + " Nolu IBANA " + miktar + " Gonderildi");
            bakiyeSorgula();

        }else {
            System.out.println("Gecerli Miktar Giriniz!");
            paraGonderme(iban, scan.nextDouble());
        }
        //TR12 1213 1415 1516 1718 1920 22

    }
    private static void paracekme(double miktar) {
        if (miktar <= bakiye){
            bakiye -= miktar;
            bakiyeSorgula();

        }else {
            System.out.println("Gecerli Miktar Giriniz!");
            paracekme(scan.nextDouble());
        }
    }
    private static void paraYatirma(double miktar) {
        bakiye+=miktar;
        bakiyeSorgula();

    }
    private static void bakiyeSorgula() {
        System.out.println("===>>> Bakiyeniz: " + bakiye+" <<<===");

    }
    }
