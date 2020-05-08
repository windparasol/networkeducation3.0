package po;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(value = { "handler" })
public class CaseQuestion {
    private Integer questionId;

    private String question;

    private Integer csId;

    private String note;

    private Integer questionScore;

}