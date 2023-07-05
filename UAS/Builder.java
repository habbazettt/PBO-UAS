package UAS;

public class Builder {
    String firstName;
    String lastName;
    String username;
    String password;
    String email;
    String phoneNumber;
    int balanceBank;

    String nama;
    int balanceDana;

    public Builder(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public Builder email(String email) {
        this.email = email;
        return this;
    }

    public Builder firstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public Builder lastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public Builder balanceBank(int balanceBank) {
        this.balanceBank = balanceBank;
        return this;
    }

    public Builder phoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public Builder nama(String nama) {
        this.nama = nama;
        return this;
    }

    public Builder balanceDana(int balanceDana) {
        this.balanceDana = balanceDana;
        return this;
    }

    public User buildBank() {
        return new User(this);
    }
    public UserDana buildDana() {
        return new UserDana(this);
    }


}
