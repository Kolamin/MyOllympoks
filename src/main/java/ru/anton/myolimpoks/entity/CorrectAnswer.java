package ru.anton.myolimpoks.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class CorrectAnswer extends AbstractEntity{

    @Column(length = 2048)
    @Getter
    @Setter
    private String correctAnswer;
}
