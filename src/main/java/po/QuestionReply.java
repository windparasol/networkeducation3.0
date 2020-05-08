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
public class QuestionReply {
    private Integer qrId;

    private Integer ccId;

    private Integer aqId;

    private String qstate;

    private Integer qscore;

    private Integer stId;

    private List<ReplyRecord> replyRecordList;
}