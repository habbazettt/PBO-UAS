package UAS;

public class UserDana {
    private String username;
    private String password;
    private String nama;
    public int balanceDana;

    UserDana(UAS.Builder builder){
        this.nama = builder.nama;
        this.balanceDana = builder.balanceDana;
        this.username = builder.username;
        this.password = builder.password;
    }

    public String getNama() {
        return nama;
    }

    public int getBalanceDana() {
        return balanceDana;
    }

    public String getUsername(){
        return username;
    }

    public String getPassword(){
        return password;
    }
}