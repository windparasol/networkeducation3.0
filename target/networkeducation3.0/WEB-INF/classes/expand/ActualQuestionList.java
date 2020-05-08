package expand;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import po.ActualQuestion;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ActualQuestionList {
    private List<ActualQuestion> actualquestionlist;
}
