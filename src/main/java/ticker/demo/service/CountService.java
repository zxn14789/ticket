package ticker.demo.service;

import ticker.demo.dao.CountMapper;
import ticker.demo.entity.Count;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountService {

    @Autowired
    CountMapper countMapper;

    //查所有车次信息
    public List<Count> selectAllCnt(){
        return countMapper.selectAllCnt();
    }

    //根据目的地和日期查车次信息
    public List<Count> selectCntByDd(String destination, String date){
        return countMapper.selectCntByDd(destination,date);
    }

    //根据目的地查车次信息
    public List<Count> selectCntByDestination(String destination){
        return countMapper.selectCntByDestination(destination);
    }

    //根据日期查车次信息
    public List<Count> selectCntByDate(String date){
        return countMapper.selectCntByDate(date);
    }

    //查票价
    public int selectMoney(int id){
        return countMapper.selectMoney(id);
    }

    //查询票存
    public int selectCount(int id){
        return countMapper.selectCount(id);
    }

    //购票后票存减1
    public int CountMinus(int id){
        return countMapper.CountMinus(id);
    }

    //删除订单后票存加1
    public int CountPlus(int id){
        return countMapper.CountPlus(id);
    }

    //查cid
    public int selectCid(String date,String number){
        return countMapper.selectCid(date,number);
    }

    //修改票存
    public int updateCount(int cid,int count){
        return countMapper.updateCount(cid,count);
    }
}