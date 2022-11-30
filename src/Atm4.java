import java.util.Scanner;

public class Atm4 {
      /*
        Kullanicidan giriş için --kart numarasi-- ve --şifresini-- isteyin, eger herhangi birini yanlis girerse tekrar isteyin.
        Kart numarasi aralarda boşluk ile girerse de eger doğruysa kabul edin.
        Kart numarasi ve sifre dogrulanirsa kullanicinin yapabileceği işlemleri ekrana yazdirin,

        Menu listesinde --Bakiye sorgula, para yatirma, para çekme, para gönderme, sifre değiştirme ve cikis islemleri-- olacaktır.

        Para çekme ve para gonderme işleminde mevcut bakiyeden buyuk para çekilemez,
        Para gönderme işleminde istenen iban TR ile baslamali ve toplam 26 karakterli olmali, eger değilse menü ekranina
        geri donsun.
        Sifre değiştirme işleminde mevcut şifreyi teyit ettikten sonra, sifre değişiklik işlemini yapmali,
        */

    final static String kartNo = "99";
    static String sifre = "1";
    static Scanner scan = new Scanner(System.in);
    static double bakiye = 1000;
    double miktar = 0;

    public static void main(String[] args) {
        System.out.println("==__--__== SAKIN GELME BANKA Hosgeldiniz ==__--__==");

        giris();
    }

    private static void giris() {
        System.out.println("Lutfen Kart Numaranizi Giriniz");
        String girilenKartNo = scan.nextLine();
        girilenKartNo = girilenKartNo.replaceAll("\\s", "");
        System.out.println("Sifreniz");
        String girilenSifre = scan.nextLine();
        //girilenSifre.hashCode();

        if (girilenKartNo.equalsIgnoreCase(kartNo) && girilenSifre.equalsIgnoreCase(sifre)) {
            menu();
        } else {
            System.out.println("Yanlis giris yaptiniz");
            giris();
        }

    }

    private static void menu() {
        System.out.println("= = = = ---- _ _ _--- ANA MENU ---_ _ _ ---- = = = =\n" +
                "#-> Lutfen Yapmak Istedginiz Islem Icin Rakam Giriniz <-#" +
                "\n<- 1 -> Bakiye Sorgulama " +
                "\n<- 2 -> Para Cekme       " +
                "\n<- 3 -> Para Yatirma     " +
                "\n<- 4 -> Para Gonderme    " +
                "\n<- 5 -> Sifre Degistirmne" +
                "\n<- 6 -> CIKIS            ");

        int islemno = scan.nextInt();
        switch (islemno) {
            case 1:{
                bakiyeSorgulma();
                menu();
            }
            case 2:{
                System.out.println("Lutfen cekmek istediginiz miktari giriniz ");
                double miktar= scan.nextDouble();
                paraCekme(miktar);
            }
            case 3:{
                System.out.println("Lutfen yatirmak istediginiz miktari giriniz ");
                double miktar= scan.nextDouble();
                paraYatirma(miktar);
            }
            case 4: {
                System.out.println("Lutfen IBAN giriniz ");
                String iban = scan.nextLine();
                scan.nextLine();
                System.out.println("Lutfen Miktari giriniz");
                double miktar=scan.nextDouble();
                paraGonderme(ibanKontrol(iban), miktar);
            }
            case 5:{
                sifreDegistir();
            }
            case 6:{
                cikis();

            }


        }


    }

    private static void paraGonderme(String iban, double miktar) {
        if (miktar <= bakiye) {
            bakiye -= miktar;
            System.out.println(iban + " NOLU IBANA " + miktar + " GONDERILDI");
            bakiyeSorgulma();
        } else {
            System.out.println("GECERLI MIKTAR GIRINIZ:");
            paraGonderme(iban, scan.nextDouble());
        }

    }

    private static String ibanKontrol(String iban) {
        iban = iban.replaceAll("\\s", "");
        if (iban.startsWith("TR") && iban.length() == 26) {
            System.out.println(iban);
        } else {
            System.out.println("GECERLI IBAN GIRINIZ: ");
            //String iban2 = scan.nextLine();
            //ibanKontrol(iban2);
            //scan.nextLine();
            //ibanKontrol(scan.nextLine());
        }
        return iban;
    }

    private static void paraYatirma(double miktar) {
        bakiye+=miktar;
        System.out.println("Yatiralan miktar "+miktar);
        bakiyeSorgulma();

    }

    private static void paraCekme(double miktar) {

        if(miktar<=bakiye){
            bakiye-=miktar;
            bakiyeSorgulma();

        }else {
            System.out.println("Yetersiz bakiye");
            paraCekme(scan.nextDouble());
        }
    }

    private static void sifreDegistir() {
        System.out.println("Mevcut Sifrenizi Giriniz");

        String ksifre = scan.next();
        if (ksifre.equals(sifre)) {
            System.out.println("Yeni Sifrenizi Giriniz ");
            sifre = scan.next();
            scan.nextLine();
            giris();
        } else {
            System.out.println("Yanlis giris yaptiniz");
            sifreDegistir();
        }
    }

    private static void cikis() {
        System.out.println("Tekrar bekleriz");
        System.exit(0);
    }

    private static void bakiyeSorgulma() {
        System.out.println("Guncel Bakiye "+bakiye);
        menu();
    }



}
