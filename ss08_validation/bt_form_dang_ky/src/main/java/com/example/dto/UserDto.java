package com.example.dto;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class UserDto implements Validator {

    private int id;

//    @NotBlank(message = "Can not be blank")
    @Size(min = 5, max = 45, message = "Must be in the range of 5 to 45")
    private String firstName;

//    @NotBlank(message = "Can not be blank")
    @Size(min = 5, max = 45, message = "Must be in the range of 5 to 45")
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
        if (!userDto.email.matches("^[a-z0-9]*@gmail.com$")) {
            errors.rejectValue("email", "email_error", "Error");
        }

//        if (!userDto.dateOfBirth.matches("^(18|19|[2-9][0-9])$")) {
//            errors.rejectValue("dateOfBirth", "age_error1", "Error");
//        }

        if (userDto.dateOfBirth.matches("^(0?[1-9]|[12][0-9]|3[01])[\\/\\-](0?[1-9]|1[012])[\\/\\-]\\d{4}$")) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
//            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
            LocalDate age = LocalDate.parse(userDto.dateOfBirth, formatter);
            LocalDate now = LocalDate.now();
            int current = Period.between(age, now).getYears();
            if (current < 18) {
                errors.rejectValue("dateOfBirth", "age_error1", "Error");
            } else if (current > 100) {
                errors.rejectValue("dateOfBirth", "age_error2", "Error");
            }
        } else {
            errors.rejectValue("dateOfBirth", "age_error3", "Error");
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


