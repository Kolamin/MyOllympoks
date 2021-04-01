package ru.anton.myolimpoks.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Entity
public class TestQuestions extends AbstractEntity{

    @ElementCollection(fetch = FetchType.EAGER)
    @Column(length = 2048)
    @Getter
    @Setter
    private List<String> testOptions;
}
