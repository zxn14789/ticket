package ticker.demo.controller;

import ticker.demo.entity.Order;
import ticker.demo.result.Result;
import ticker.demo.result.ResultUtil;
import ticker.demo.service.CountService;
import ticker.demo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class OrderController {

    @Autowired
    OrderService orderService;

    @Autowired
    CountService countService;

    //购票添加订单
    @PostMapping("/addorder")
    public Result insert(@RequestParam(name = "count_id") int count_id,
                         @RequestParam(name = "name") String name,
                         @RequestParam(name = "idno") String idno,
                         @RequestParam(name = "pay") int pay, HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Cache-Control","no-cache");
        response.setHeader("Access-Control-Allow-Methods","GET,POST,DELETE");
        int money = countService.selectMoney(count_id);     //票价
        int refund = pay;   //退款金额
        int n = countService.selectCount(count_id);     //票存
        Map<String,Integer> map = new HashMap<String,Integer>();
        map.put("refund",refund);
        if(pay < money){
            return ResultUtil.error("钱不够",map);
        }else{
            if (n <= 0){
                return ResultUtil.error("票不足",map);
            }else{
                Timestamp time = new Timestamp(System.currentTimeMillis()); //当前时间
                int seat;
                if (orderService.selectByCid(count_id)!=null){
                    seat = orderService.selectSeat(count_id)+1;
                }else {
                    seat = 1;
                }
                refund = pay - money;   //退款金额
                Order order = new Order(count_id,name,idno,seat,time,pay,refund);
                countService.CountMinus(count_id); //票-1
                orderService.insert(order);
                return ResultUtil.success(order);
            }
        }
    }

    //后台管理添加订单
    @PostMapping("/aorder")
    public Result add(@RequestParam(name = "name") String name,
                      @RequestParam(name = "idno") String idno,
                      @RequestParam(name = "number") String number,
                      @RequestParam(name = "date") String date,
                      @RequestParam(name = "pay") int pay,HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Cache-Control","no-cache");
        response.setHeader("Access-Control-Allow-Methods","GET,POST,DELETE");
        int cid = countService.selectCid(date,number);      //查cid
        return insert(cid,name,idno,pay,response);
    }

    //查询所有订单
    @GetMapping("/allorder")
    public Result allOrder(HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Cache-Control","no-cache");
        List<Order> orders = orderService.selectAll();
        return ResultUtil.success(orders);
    }

    //删除订单
    @DeleteMapping("/delorder/{id}")
    public Result deleteById(@PathVariable("id")int id, HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Cache-Control","no-cache");
        response.setHeader("Access-Control-Allow-Methods","GET,POST,DELETE");
        int cid = orderService.selectCid(id);
        countService.CountPlus(cid); //票+1
        int r = orderService.deleteByPrimaryKey(id);
        return ResultUtil.success(r);
    }

    //根据目的地和日期查订单信息
    @GetMapping("/orderdd")
    public Result orderByDd(@RequestParam(name = "destination") String destination, @RequestParam(name = "date") String date,HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Cache-Control","no-cache");
        List<Order> orders;
        if (destination==""){
            if (date==""){          //destination空,date空
                orders = orderService.selectAll();
            }else {                 //destination空,date不空
                orders = orderService.selectOrderByDate(date);
            }
        }else {
            if (date==""){          //destination不空,date空
                orders = orderService.selectOrderByDestination(destination);
            }else {                 //destination不空,date不空
                orders = orderService.selectOrderByDd(destination,date);
            }
        }
        return ResultUtil.success(orders);
    }
}