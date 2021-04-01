package ru.anton.myolimpoks.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "role")
@NoArgsConstructor
@RequiredArgsConstructor
public class Role extends AbstractEntity{

    @Getter
    @Setter
    @NonNull
    private String name;
}
