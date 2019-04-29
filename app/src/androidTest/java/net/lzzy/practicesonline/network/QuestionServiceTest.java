package net.lzzy.practicesonline.network;

import net.lzzy.practicesonline.activities.models.Question;
import net.lzzy.practicesonline.activities.models.view.QuestionType;
import net.lzzy.practicesonline.activities.network.QuestionService;

import org.json.JSONException;
import org.junit.Test;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by lzzy_gxy on 2019/4/22.
 * Description:
 */
public class QuestionServiceTest {

    @Test
    public void testGetQuestionsOfPracticeFromServer() throws IOException {
        String json= QuestionService.getQuestionsOfPracticeFromServer(28);
        assertTrue(json.contains("交互性和充分性"));
    }

    @Test
    public void testGetQuestions() throws IOException, IllegalAccessException, JSONException, InstantiationException {
        String json= QuestionService.getQuestionsOfPracticeFromServer(28);
        List<Question> questions= QuestionService.getQuestions(json, UUID.randomUUID());
        assertEquals(6,questions.size());
        Question question=questions.get(1);
        assertTrue(questions.get(1).getContent().contains("主要目的在于"));
        assertEquals(QuestionType.SINGLE_CHOICE,question.getType());
        assertEquals(4,question.getOptions().size());
        assertTrue(question.getOptions().get(0).isAnswer());

    }
}