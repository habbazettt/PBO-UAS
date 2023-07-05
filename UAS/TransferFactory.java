package UAS;

class TransferFactory {
    public Transfer createTransfer(String jenis) {
        if (jenis.equalsIgnoreCase("Bank")){
            return new TransferBank();
        } else if (jenis.equalsIgnoreCase("Dana")) {
            return new TransferDana();
        }
        throw new IllegalArgumentException("Jenis Transaksi Tidak Valid: " + jenis);
    }
}
