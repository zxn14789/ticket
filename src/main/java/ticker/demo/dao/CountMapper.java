package ticker.demo.dao;

import ticker.demo.entity.Count;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CountMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Count record);

    Count selectByPrimaryKey(Integer id);

    //根据目的地和日期查车次信息
    List<Count> selectCntByDd(@Param("destination")String destination,@Param("date") String date);

    //根据目的地查车次信息
    List<Count> selectCntByDestination(@Param("destination")String destination);

    //根据日期查车次信息
    List<Count> selectCntByDate(@Param("date") String date);

    //查所有车次信息
    List<Count> selectAllCnt();

    List<Count> selectAll();

    int updateByPrimaryKey(Count record);

    //修改票存
    int updateCount(@Param("cid") Integer cid,@Param("count") int count);

    //查票价
    int selectMoney(Integer id);

    //查询票存
    int selectCount(Integer id);

    //购票后票存减1
    int CountMinus(Integer id);

    //删除订单后票存加1
    int CountPlus(Integer id);

    //查cid
    int selectCid(@Param("date") String date,@Param("number") String number);
}