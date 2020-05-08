package service.base;

import dao.CasesMapper;
import dao.ClassRoomMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import po.Cases;
import po.ClassRoom;

@Service
public class TestService {
    @Autowired
    private CasesMapper casesMapper;

    @Autowired
    private ClassRoomMapper classRoomMapper;

    public ClassRoom testclassroom(int roid){
        return classRoomMapper.selectByPrimaryKey(roid);
    }
}
