package engine.controller;

import engine.model.Quiz;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/quiz")
public class QuizController {

    // Statický kvíz, který bude náš server vracet
    // Tento kvíz obsahuje tři atributy: title (název), text (otázka) a options (pole možných odpovědí)
    private static final Quiz QUIZ = new Quiz(
            "The Java Logo",
            "What is depicted on the Java logo?",
            new String[]{"Robot", "Tea leaf", "Cup of coffee", "Bug"}
    );

    // Správná odpověď v poli možností = 3 (jdeme od 0)
    private static final int CORRECT_ANSWER_INDEX = 2;

    // GET /api/quiz: Vrátí JSON objekt s kvízem
    @GetMapping
    public Quiz getQuiz() {
        return QUIZ;
    }

    //POST /api/quiz?answer=X: Zkontroluje odpověď a vrátí JSON objekt s výsledkem
    @PostMapping
    public ResponseEntity<?> solveQuiz(@RequestParam int answer) {
        if (answer == CORRECT_ANSWER_INDEX) {
            return ResponseEntity.ok(new Result(true, "Congratulations, you're right!"));
        } else {
            return ResponseEntity.ok(new Result(false, "Wrong answer! Please, try again."));
        }
    }

    static class Result {
        private boolean success;
        private String feedback;

        public Result(boolean success, String feedback) {
            this.success = success;
            this.feedback = feedback;
        }

        public boolean isSuccess() {
            return success;
        }

        public String getFeedback() {
            return feedback;
        }
    }
}
