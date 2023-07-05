package UAS;

public class TransferBank implements Transfer{

    @Override
    public void proses(int jumlahTf, String tujuan) {
        System.out.println("Transfer " + jumlahTf + " ke Rekening Tabungan " + tujuan);
        System.out.println("TRANSFER BERHASIL");
    }
}
