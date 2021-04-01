package ru.anton.myolimpoks.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.anton.myolimpoks.entity.Question;

public interface QuestionRepo extends JpaRepository<Question, Long> {
}
