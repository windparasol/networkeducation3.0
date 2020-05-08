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
public class User {
    private Integer usId;

    private String email;

    private String pwd;

    private String truename;

    private String nickname;

    private String phone;

    private String headUrl;

    private String userType;

    private List<ClassRoom>  classRoomList;

    private List<QuestionReply> questionReplyList;
}