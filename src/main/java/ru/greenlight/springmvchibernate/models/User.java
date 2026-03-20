package ru.greenlight.springmvchibernate.models;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import javax.persistence.*;

import lombok.*;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    @NotEmpty(message = "Имя не должно быть пустым")
    @Size(min = 2, max = 30, message = "Длина имени должна быть от 2-х до 30-ти знаков")
    private String name;

    @Column(name = "age")
    @Min(value = 1, message = "Возраст должен быть больше 0")
    private int age;

    @Column(name = "email")
    @NotEmpty(message = "Email не должен быть пустым")
    @Email(message = "Email должен быть валидным")
    private String email;

}