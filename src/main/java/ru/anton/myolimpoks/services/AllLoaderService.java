package ru.anton.myolimpoks.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;
import ru.anton.myolimpoks.MyOlimpoksApplication;
import ru.anton.myolimpoks.entity.*;
import ru.anton.myolimpoks.repositorys.CorrectAnswerRepo;
import ru.anton.myolimpoks.repositorys.QuestionRepo;
import ru.anton.myolimpoks.repositorys.TestQuestionsRepo;
import ru.anton.myolimpoks.repositorys.UserRepository;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

@Slf4j
@Service
public class AllLoaderService implements CommandLineRunner {

    private final QuestionRepo questionRepo;
    private final CorrectAnswerRepo correctAnswerRepo;
    private final TestQuestionsRepo testQuestionsRepo;
    private final UserRepository userRepository;

    public AllLoaderService(QuestionRepo questionRepo,
                            CorrectAnswerRepo correctAnswerRepo,
                            TestQuestionsRepo testQuestionsRepo, UserRepository userRepository) {
        this.questionRepo = questionRepo;
        this.correctAnswerRepo = correctAnswerRepo;
        this.testQuestionsRepo = testQuestionsRepo;
        this.userRepository = userRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        MyOlimpoksApplication obj = new MyOlimpoksApplication();

        InputStream stringReaderAllTest = obj.getClass()
                .getClassLoader()
                .getResourceAsStream("Thermal_power_plants.txt");


        InputStream strReaderCorrectAnswer = obj.getClass()
                .getClassLoader()
                .getResourceAsStream("Answer.txt");

        String[] splitAllTest = getStrings(stringReaderAllTest);

        String[] resultAllTest = Arrays.copyOfRange(splitAllTest, 1, splitAllTest.length);

        log.info("-------------------------------------------------");
        log.info("Save questions and test questions in repositories");
        log.info("-------------------------------------------------");
        for (String s : resultAllTest) {
            String[] strings = s.split("\\n");
            questionRepo.save(new Question(strings[1]));
            testQuestionsRepo
                    .save(new TestQuestions(Arrays.asList(Arrays
                            .copyOfRange(strings, 2, strings.length))));
        }

        String[] correctAnswers = getStrings(strReaderCorrectAnswer);

        String[] resultCorrectAnswer = Arrays.copyOfRange(correctAnswers, 1, correctAnswers.length);

        log.info("-------------------------------------------------");
        log.info("Save correct answer and in repositories");
        log.info("-------------------------------------------------");
        for (String s : resultCorrectAnswer) {
            String[] split = s.split("\\n");

            correctAnswerRepo.save(new CorrectAnswer(split[2]));
        }


        stringReaderAllTest.close();
        strReaderCorrectAnswer.close();
    }

    private String[] getStrings(InputStream stringReaderAllTest) throws IOException {
        StringBuilder fileContent;
        try (BufferedReader br = new BufferedReader(new InputStreamReader(stringReaderAllTest))) {

            fileContent = new StringBuilder();
            String st;
            while ((st = br.readLine()) != null) {
                if (st.contains("Правила по охране труда при эксплуатации тепловых энергоустановок"))
                    continue;
                if (st.contains("Мероприятия по оказани первой помощи (Приказ Минздрава России от 04.05.2012 № 477н)"))
                    continue;
                fileContent.append(st)
                        .append("\n");
            }
        }


        return fileContent.toString()
                .split("Вопрос \\d+");
    }
}
