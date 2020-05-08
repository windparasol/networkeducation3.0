package po;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(value = { "handler" })
public class ReplyRecord {
    private Integer rrId;

    private Integer qrId;

    private String userType;

    private String rstate;

    private String narration;

    private String annexurl;
}