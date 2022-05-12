package com.example.dto;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class UserDto implements Validator {

    private int id;

    @NotBlank(message = "Can not be blank")
    @Size(min = 5, max = 45, message = "Not within the allowable range")
    private String firstName;

    @NotBlank(message = "Can not be blank")
    @Size(min = 5, max = 45, message = "Not within the allowable range")
    private String lastName;

    @NotBlank(message = "Can not be blank")
    @Pattern(regexp = "^(090|091)[0-9]{7}$", message = "Wrong format")
    private String numberPhone;

    @NotBlank(message = "Can not be blank")
    private String dateOfBirth;

    @NotBlank(message = "Can not be blank")
    private String email;

    public UserDto() {
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getNumberPhone() {
        return numberPhone;
    }

    public void setNumberPhone(String numberPhone) {
        this.numberPhone = numberPhone;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        UserDto userDto = (UserDto) target;
        if (!userDto.email.matches("^[a-z]*@gmail.com$")) {
            errors.rejectValue("email", "email_error", "Error");
        }

        if (!userDto.dateOfBirth.matches("^(18|19|[2-9][0-9])$")) {
            errors.rejectValue("dateOfBirth", "age_error1", "Error");
        }
    }
}
//    public static String regexAge(String temp) {
//        Scanner sca = new Scanner(System.in);
//        boolean check = true;
//        while (check) {
//            try {
//                if (Pattern.matches(BIRTHDAY_REGEX, temp)) {
//                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
//                    LocalDate age = LocalDate.parse(temp, formatter);
//                    LocalDate now = LocalDate.now();
//                    int current = Period.between(age, now).getYears();
//                    if (current < 100 && current > 18) {
//                        check = false;
//                    } else {
//                        throw new AgeException("Tuổi phải lớn hơn 18 và nhỏ hơn 100, hãy nhập lại: ");
//                    }
//                } else {
//                    throw new AgeException("Định dạng nhập vào sai, hãy nhập lại: ");
//                }
//            } catch (AgeException e) {
//                System.out.print(e.getMessage());
//                temp = sca.nextLine();
//            }
//        }
//        return temp;
//    }
//        if (userDto.dateOfBirth.matches("(^(((0[1-9]|1[0-9]|2[0-8])[\\/](0[1-9]|1[012]))|((29|30|31)[\\/](0[13578]|1[02]))|((29|30)[\\/](0[4,6,9]|11)))[\\/](19|[2-9][0-9])\\d\\d$)|(^29[\\/]02[\\/](19|[2-9][0-9])(00|04|08|12|16|20|24|28|32|36|40|44|48|52|56|60|64|68|72|76|80|84|88|92|96)$)")) {
//            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
//            LocalDate age = LocalDate.parse(userDto.dateOfBirth, formatter);
//            LocalDate now = LocalDate.now();
//            int current = Period.between(age, now).getYears();
//            if (current > 100 && current < 18) {
//                errors.rejectValue("dateOfBirth", "age_error1", "Error");
//            }
//        } else {
//            errors.rejectValue("dateOfBirth", "age_error2", "Error");
//        }

