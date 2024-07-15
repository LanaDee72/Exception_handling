import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class View {

    private UserController userController = new UserController();

    private User create(String[] info) throws Exception{
            String lastname = info[0];
            String name = info[1];
            String patronymic = info[2];
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.uuuu");
            LocalDate birthDate = LocalDate.parse(info[3], formatter);
            if (info[4].length() != 11){
                throw new Exception("Неверный формат номера телефона. Телефон должен содержать 11 символов");
            }
            long phoneNumber = Long.parseLong(info[4]);
            if (info[5].length() != 1) {
                throw new Exception("Неверно задан пол. Пол должен содержать один символ 'm' или 'f'");
            }
            if (info[5].charAt(0) != 'f' && info[5].charAt(0) != 'm'){
                throw new Exception("Неверно задан пол. Пол должен содержать один символ 'm' или 'f'");
            }
            char gender = info[5].charAt(0);
            return userController.create(lastname, name, patronymic, birthDate, phoneNumber, gender);
    }

    private void saveFile(User user) throws IOException{

        File file = new File(user.getLastname() + ".txt");
        BufferedWriter writer = new BufferedWriter(new FileWriter(file, true));
        writer.write(user.toString());
        writer.newLine();
        writer.close();

    }

    public void start() throws Exception{
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите через пробел ФИО, дата рождения, номер телефона, пол: ");
        String info = scanner.nextLine();

        String[] data = info.split(" ");

        if (data.length != 6) {
            throw new Exception("Неверное количество данных");
        }

        try{
            User user = create(data);
            saveFile(user);
        } catch(DateTimeParseException e){
            System.out.println("Неверный формат даты. Введите дату в формате dd.mm.yyyy");
        } catch(NumberFormatException e){
            System.out.println("Неверный формат номера телефона");
        }
     

    }

}



// } catch(DateTimeParseException e){
//     System.out.println("Неверный формат даты");
// } catch(NumberFormatException e){
//     System.out.println("Неверный формат номера телефона");
// }