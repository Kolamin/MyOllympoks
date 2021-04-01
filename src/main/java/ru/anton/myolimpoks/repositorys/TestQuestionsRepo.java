package ru.anton.myolimpoks.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.anton.myolimpoks.entity.TestQuestions;

public interface TestQuestionsRepo extends JpaRepository<TestQuestions, Long> {
}
