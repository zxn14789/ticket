package ticker.demo.service;

import ticker.demo.dao.OrderMapper;
import ticker.demo.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    OrderMapper orderMapper;

    public int insert(Order order){
        return orderMapper.insert(order);
    }

    //查询座位
    public int selectSeat(int cid){
        return orderMapper.selectSeat(cid);
    }

    //根据cid查询是否有人买过该车的票
    public Order selectByCid(int cid){
        return orderMapper.selectByCid(cid);
    }

    //查询所有订单信息
    public List<Order> selectAll(){
        return orderMapper.selectAll();
    }

    public int deleteByPrimaryKey(int id){
        return orderMapper.deleteByPrimaryKey(id);
    }

    //查询count_id
    public int selectCid(int id){
        return orderMapper.selectCid(id);
    }

    //根据目的地和日期查订单信息
    public List<Order> selectOrderByDd(String destination, String date){
        return orderMapper.selectOrderByDd(destination,date);
    }

    //根据目的地查订单信息
    public List<Order> selectOrderByDestination(String destination){
        return orderMapper.selectOrderByDestination(destination);
    }

    //根据日期查订单信息
    public List<Order> selectOrderByDate(String date){
        return orderMapper.selectOrderByDate(date);
    }
}