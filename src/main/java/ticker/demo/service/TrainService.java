package ticker.demo.service;
import ticker.demo.entity.Train;
import ticker.demo.dao.TrainMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrainService {

    @Autowired
    TrainMapper trainMapper;

    public List<Train> selectAll(){
        return trainMapper.selectAll();
    }
}