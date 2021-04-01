package ru.anton.myolimpoks.entity;

import lombok.*;

import javax.persistence.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Entity
public class Question extends AbstractEntity {

    @Getter
    @Setter
    @Column(length = 2048)
    private String question;
}
