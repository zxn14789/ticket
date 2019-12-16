package ticker.demo.dao;

import ticker.demo.entity.Train;

import java.util.List;

public interface TrainMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Train record);

    Train selectByPrimaryKey(Integer id);

    List<Train> selectAll();

    int updateByPrimaryKey(Train record);
}