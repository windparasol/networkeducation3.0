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
public class ClassRoom {
    private Integer roId;

    private Integer tcId;

    private String roomname;

    private String roomdescrible;

    private List<User> studentList;

    private  User user;

    private List<ClassRoomCase> classRoomCaseList;
}