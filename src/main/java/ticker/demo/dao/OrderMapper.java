package ticker.demo.dao;
import ticker.demo.entity.Order;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrderMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Order record);

    Order selectByPrimaryKey(Integer id);

    //查询座位
    int selectSeat(Integer cid);

    //根据cid查询是否有人买过该车的票
    Order selectByCid(Integer cid);

    //查询所有订单信息
    List<Order> selectAll();

    int updateByPrimaryKey(Order record);

    //查询count_id
    int selectCid(Integer id);

    //根据目的地和日期查订单信息
    List<Order> selectOrderByDd(@Param("destination")String destination, @Param("date") String date);

    //根据目的地查订单信息
    List<Order> selectOrderByDestination(@Param("destination")String destination);

    //根据日期查订单信息
    List<Order> selectOrderByDate(@Param("date") String date);
}