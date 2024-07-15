import java.time.LocalDate;

public class User {

    private String name;
    private String lastname;
    private String patronymic;
    private LocalDate birthDate;
    private long phoneNumber;
    private char gender;


    public User(String lastname, String name, String patronymic, LocalDate birthDate, long phoneNumber, char gender){
        this.lastname = lastname;
        this.name = name;
        this.patronymic = patronymic;
        this.birthDate = birthDate;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
    }

    @Override
    public String toString() {
        return String.format("%s %s %s, %tD, %d, %c", lastname, name, patronymic, birthDate, phoneNumber, gender);
    }

    public String getName() {
        return name;
    }

    public String getLastname() {
        return lastname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public char getGender() {
        return gender;
    }

    

}