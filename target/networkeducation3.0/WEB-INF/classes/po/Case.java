package po;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(value = { "handler" })
public class Case {
    private Integer csId;

    private String csName;

    private String sceneDescrible;

    private Integer tcId;

    private String auditor;

    private String pageUrl;

    private List<CaseQuestion> questionList;
}