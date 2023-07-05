package UAS;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // deklarasi variabel
        String pilihanProgram;
        int pilihan;
        String usernameLogin;
        String passwordLogin;
        String usernameTujuan;
        int jumlahTf;

        String balikMenu;
        boolean flag = true;

        // build user dengan Builder design pattern
        User user1 = new Builder("Bank1", "bank1")
                .firstName("Haiqel").lastName("Hakeem")
                .email("haiqelhakeem@gmail.com")
                .balanceBank(3000000)
                .buildBank();
        User user2 = new Builder("Bank2", "bank2")
                .firstName("Hubbal").lastName("Habbaza")
                .email("hubbal@gmail.com")
                .balanceBank(3000000)
                .buildBank();

        UserDana userD1 = new Builder("Dana1","dana1").nama("Hubbal").balanceDana(2000000).buildDana();
        UserDana userD2 = new Builder("Dana2", "dana2").nama("Haiqel").balanceDana(3000000).buildDana();

        TransferFactory factory = new TransferFactory();

        Transfer transferDana = factory.createTransfer("Dana");
        Transfer transferBank = factory.createTransfer("Bank");

        // Scanner
        Scanner inputInt = new Scanner(System.in);
        Scanner inputStr = new Scanner(System.in);

        // Pilih Program DANA / BANK
        System.out.print("Pilih Program (DANA / BANK): ");
        pilihanProgram = inputInt.next();

            if (pilihanProgram.equalsIgnoreCase("DANA")) {
                System.out.println();
                System.out.println("LOGIN BERHASIL");
                System.out.println("===================================");
                System.out.println("Welcome to DANA");
                // Login DANA
                System.out.println("Login DANA Untuk Masuk ke Menu");
                System.out.print("Username: ");
                usernameLogin = inputStr.nextLine();
                System.out.print("Password: ");
                passwordLogin = inputStr.nextLine();

                // MASUKA KE AKUN DANA 1
                if (usernameLogin.equalsIgnoreCase(userD1.getUsername()) && passwordLogin.equals(userD1.getPassword())) {
                    System.out.println("Login DANA Berhasil!!!");
                    System.out.println("Selamat Datang " + userD1.getNama());

                    System.out.println();
                    System.out.println("SALDO ANDA: " + userD1.getBalanceDana());

                    do {
                        System.out.println("======================");
                        System.out.println("Menu Program: ");
                        System.out.println("1. Transfer ke Akun DANA");
                        System.out.println("2. Transfer ke Rekening Bank");
                        System.out.println("3. Keluar");

                        System.out.println();
                        System.out.print("Pilihan Anda: ");
                        pilihan = inputInt.nextInt();

                        switch (pilihan) {
                            case 1 -> {
                                System.out.println();
                                System.out.println("SALDO: " + userD1.balanceDana);
                                System.out.println("==========================");
                                System.out.println("TRANSFER KE AKUN DANA");
                                System.out.print("Username DANA Tujuan: ");
                                usernameTujuan = inputStr.nextLine();
                                System.out.print("Jumlah Transfer: ");
                                jumlahTf = inputInt.nextInt();
                                int saldoAkhir = userD1.getBalanceDana() - jumlahTf;

                                if (usernameTujuan.equalsIgnoreCase(userD2.getUsername())){
                                    transferDana.proses(jumlahTf,userD2.getNama());
                                }

                                System.out.println();
                                System.out.println("SALDO AKHIR: " + saldoAkhir);
                                userD1.balanceDana = saldoAkhir;
                            } case 2 -> {
                                System.out.println();
                                System.out.println("SALDO: " + userD1.balanceDana);
                                System.out.println("============================");
                                System.out.println("TRANSFER KE REKENING BANK");
                                System.out.print("Username Bank Tujuan: ");
                                usernameTujuan = inputStr.nextLine();
                                System.out.print("Jumlah Transfer: ");
                                jumlahTf = inputInt.nextInt();
                                int saldoAkhir = userD1.getBalanceDana() - jumlahTf;

                                if (usernameTujuan.equalsIgnoreCase(user1.getUsername())){
                                    transferBank.proses(jumlahTf,user1.getFirstName() + " " + user1.getLastName());
                                } else if (usernameTujuan.equalsIgnoreCase(user2.getUsername())) {
                                    transferBank.proses(jumlahTf,user2.getFirstName() + " " + user2.getLastName());
                                }

                                System.out.println();
                                System.out.println("SALDO AKHIR: " + saldoAkhir);
                                userD1.balanceDana = saldoAkhir;
                            } case 3 -> {
                                System.out.println("Keluar...");
                                System.exit(0);
                            }
                        }
                        System.out.println();
                        System.out.print("Kembali ke Menu Awal? (Y / N) ");
                        balikMenu = inputStr.nextLine();
                        if (balikMenu.equalsIgnoreCase("Y")) {
                            flag = true;
                        } else {
                            System.out.println("Keluar...");
                            flag = false;
                        }
                    } while (flag);

                // MASUK KE AKUN DANA 2
                } else if (usernameLogin.equalsIgnoreCase(userD2.getUsername()) && passwordLogin.equalsIgnoreCase(userD2.getPassword())) {
                    System.out.println("Login DANA Berhasil!!!");
                    System.out.println("Selamat Datang " + userD2.getNama());

                    System.out.println();
                    System.out.println("SALDO ANDA: " + userD2.getBalanceDana());

                    do {
                        System.out.println("======================");
                        System.out.println("Menu Program: ");
                        System.out.println("1. Transfer ke Akun DANA");
                        System.out.println("2. Transfer ke Rekening Bank");
                        System.out.println("3. Keluar");

                        System.out.println();
                        System.out.print("Pilihan Anda: ");
                        pilihan = inputInt.nextInt();

                        switch (pilihan) {
                            case 1 -> {
                                System.out.println();
                                System.out.println("SALDO: " + userD2.balanceDana);
                                System.out.println("==========================");
                                System.out.println("TRANSFER KE AKUN DANA");
                                System.out.print("Username DANA Tujuan: ");
                                usernameTujuan = inputStr.nextLine();
                                System.out.print("Jumlah Transfer: ");
                                jumlahTf = inputInt.nextInt();
                                int saldoAkhir = userD2.getBalanceDana() - jumlahTf;

                                if (usernameTujuan.equalsIgnoreCase(userD1.getUsername())){
                                    transferDana.proses(jumlahTf,userD1.getNama());
                                }

                                System.out.println();
                                System.out.println("SALDO AKHIR: " + saldoAkhir);
                                userD2.balanceDana = saldoAkhir;
                            } case 2 -> {
                                System.out.println();
                                System.out.println("SALDO: " + userD2.balanceDana);
                                System.out.println("============================");
                                System.out.println("TRANSFER KE REKENING BANK");
                                System.out.print("Username Bank Tujuan: ");
                                usernameTujuan = inputStr.nextLine();
                                System.out.print("Jumlah Transfer: ");
                                jumlahTf = inputInt.nextInt();
                                int saldoAkhir = userD2.getBalanceDana() - jumlahTf;

                                if (usernameTujuan.equalsIgnoreCase(user1.getUsername())){
                                    transferBank.proses(jumlahTf,user1.getFirstName() + " " + user1.getLastName());
                                } else if (usernameTujuan.equalsIgnoreCase(user2.getUsername())) {
                                    transferBank.proses(jumlahTf,user2.getFirstName() + " " + user2.getLastName());
                                }

                                System.out.println();
                                System.out.println("SALDO AKHIR: " + saldoAkhir);
                                userD2.balanceDana = saldoAkhir;
                            } case 3 -> {
                                System.out.println("Keluar...");
                                System.exit(0);
                            }
                        }
                        System.out.println();
                        System.out.print("Kembali ke Menu Awal? (Y / N) ");
                        balikMenu = inputStr.nextLine();
                        if (balikMenu.equalsIgnoreCase("Y")) {
                            flag = true;
                        } else {
                            System.out.println("Keluar...");
                            flag = false;
                        }
                    } while (flag);
                }

            } else if (pilihanProgram.equalsIgnoreCase("BANK")) {
                System.out.println();
                System.out.println("LOGIN BERHASIL");
                System.out.println("===================================");
                System.out.println("Welcome to BANK");
                // Login BANK
                System.out.println("Login BANK Untuk Masuk ke Menu");
                System.out.print("Username: ");
                usernameLogin = inputStr.nextLine();
                System.out.print("Password: ");
                passwordLogin = inputStr.nextLine();

                if (usernameLogin.equalsIgnoreCase(user1.getUsername()) && passwordLogin.equalsIgnoreCase(user1.getPassword())){
                    System.out.println("Login BANK Berhasil!!!");
                    System.out.println("Selamat Datang " + user1.getFirstName() + " " + user1.getLastName());

                    System.out.println();
                    System.out.println("SALDO ANDA: " + user1.getBalance());

                    do {
                        System.out.println("======================");
                        System.out.println("Menu Program: ");
                        System.out.println("1. Transfer ke Rekening Bank");
                        System.out.println("2. Transfer ke Akun DANA");
                        System.out.println("3. Keluar");

                        System.out.println();
                        System.out.print("Pilihan Anda: ");
                        pilihan = inputInt.nextInt();

                        switch (pilihan) {
                            case 1 -> {
                                System.out.println();
                                System.out.println("SALDO: " + user1.balanceBank);
                                System.out.println("==========================");
                                System.out.println("TRANSFER KE REKENING BANK");
                                System.out.print("Username BANK Tujuan: ");
                                usernameTujuan = inputStr.nextLine();
                                System.out.print("Jumlah Transfer: ");
                                jumlahTf = inputInt.nextInt();
                                int saldoAkhir = user1.balanceBank - jumlahTf;

                                if (usernameTujuan.equalsIgnoreCase(user2.getUsername())){
                                    transferDana.proses(jumlahTf,user2.getFirstName() + " " + user2.getLastName());
                                }

                                System.out.println();
                                System.out.println("SALDO AKHIR: " + saldoAkhir);
                                user1.balanceBank = saldoAkhir;
                            } case 2 -> {
                                System.out.println();
                                System.out.println("SALDO: " + user1.balanceBank);
                                System.out.println("============================");
                                System.out.println("TRANSFER KE AKUN DANA");
                                System.out.print("Username DANA Tujuan: ");
                                usernameTujuan = inputStr.nextLine();
                                System.out.print("Jumlah Transfer: ");
                                jumlahTf = inputInt.nextInt();
                                int saldoAkhir = user1.balanceBank - jumlahTf;

                                if (usernameTujuan.equalsIgnoreCase(userD1.getUsername())){
                                    transferBank.proses(jumlahTf,userD1.getNama());
                                } else if (usernameTujuan.equalsIgnoreCase(userD2.getUsername())) {
                                    transferBank.proses(jumlahTf,userD2.getNama());
                                }
                                System.out.println();
                                System.out.println("SALDO AKHIR: " + saldoAkhir);
                                user1.balanceBank = saldoAkhir;
                            }
                        }
                        System.out.println();
                        System.out.print("Kembali ke Menu Awal? (Y / N) ");
                        balikMenu = inputStr.nextLine();
                        if (balikMenu.equalsIgnoreCase("Y")) {
                            flag = true;
                        } else {
                            System.out.println("Keluar...");
                            flag = false;
                        }
                    } while (flag);
                } else if (usernameLogin.equalsIgnoreCase(user2.getUsername()) && passwordLogin.equalsIgnoreCase(user2.getPassword())) {
                    System.out.println("Login BANK Berhasil!!!");
                    System.out.println("Selamat Datang " + user2.getFirstName() + " " + user2.getLastName());

                    System.out.println();
                    System.out.println("SALDO ANDA: " + user2.getBalance());

                    do {
                        System.out.println("======================");
                        System.out.println("Menu Program: ");
                        System.out.println("1. Transfer ke Rekening Bank");
                        System.out.println("2. Transfer ke Akun DANA");
                        System.out.println("3. Keluar");

                        System.out.println();
                        System.out.print("Pilihan Anda: ");
                        pilihan = inputInt.nextInt();

                        switch (pilihan) {
                            case 1 -> {
                                System.out.println();
                                System.out.println("SALDO: " + user2.balanceBank);
                                System.out.println("==========================");
                                System.out.println("TRANSFER KE REKENING BANK");
                                System.out.print("Username BANK Tujuan: ");
                                usernameTujuan = inputStr.nextLine();
                                System.out.print("Jumlah Transfer: ");
                                jumlahTf = inputInt.nextInt();
                                int saldoAkhir = user2.balanceBank - jumlahTf;

                                if (usernameTujuan.equalsIgnoreCase(user1.getUsername())){
                                    transferDana.proses(jumlahTf,user1.getFirstName() + " " + user1.getLastName());
                                }

                                System.out.println();
                                System.out.println("SALDO AKHIR: " + saldoAkhir);
                                user2.balanceBank = saldoAkhir;
                            } case 2 -> {
                                System.out.println();
                                System.out.println("SALDO: " + user2.balanceBank);
                                System.out.println("============================");
                                System.out.println("TRANSFER KE AKUN DANA");
                                System.out.print("Username DANA Tujuan: ");
                                usernameTujuan = inputStr.nextLine();
                                System.out.print("Jumlah Transfer: ");
                                jumlahTf = inputInt.nextInt();
                                int saldoAkhir = user2.balanceBank - jumlahTf;

                                if (usernameTujuan.equalsIgnoreCase(userD1.getUsername())){
                                    transferBank.proses(jumlahTf,userD1.getNama());
                                } else if (usernameTujuan.equalsIgnoreCase(userD2.getUsername())) {
                                    transferBank.proses(jumlahTf,userD2.getNama());
                                }
                                System.out.println();
                                System.out.println("SALDO AKHIR: " + saldoAkhir);
                                user2.balanceBank = saldoAkhir;
                            }
                        }
                        System.out.println();
                        System.out.print("Kembali ke Menu Awal? (Y / N) ");
                        balikMenu = inputStr.nextLine();
                        if (balikMenu.equalsIgnoreCase("Y")) {
                            flag = true;
                        } else {
                            System.out.println("Keluar...");
                            flag = false;
                        }
                    } while (flag);
                }
            } else {
                System.out.println("INPUT INVALID!!!");
                System.exit(0);
            }
    }
}