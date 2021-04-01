package ru.anton.myolimpoks.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.anton.myolimpoks.entity.CorrectAnswer;

public interface CorrectAnswerRepo extends JpaRepository<CorrectAnswer, Long> {
}
