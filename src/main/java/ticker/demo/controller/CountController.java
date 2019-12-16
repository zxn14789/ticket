package ticker.demo.controller;

import ticker.demo.entity.Count;
import ticker.demo.result.Result;
import ticker.demo.result.ResultUtil;
import ticker.demo.service.CountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
public class CountController {

    @Autowired
    CountService countService;

    //查所有车次信息
    @GetMapping("/allcnt")
    public Result allCnt(HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Cache-Control","no-cache");
        List<Count> counts = countService.selectAllCnt();
        return ResultUtil.success(counts);
    }

    //根据目的地和日期查车次信息
    @GetMapping("/cnt")
    public Result cntByDd(@RequestParam(name = "destination") String destination, @RequestParam(name = "date") String date,HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Cache-Control","no-cache");
        List<Count> counts;
        if (destination==""){
            if (date==""){          //destination空,date空
                counts = countService.selectAllCnt();
            }else {                 //destination空,date不空
                counts=countService.selectCntByDate(date);
            }
        }else {
            if (date==""){          //destination不空,date空
                counts=countService.selectCntByDestination(destination);
            }else {                 //destination不空,date不空
                counts=countService.selectCntByDd(destination,date);
            }
        }
        return ResultUtil.success(counts);
    }

    //修改票存
    @PostMapping("/ucount")
    public Result updateCount(@RequestParam(name = "id") int id, @RequestParam(name = "count") int count,HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Cache-Control","no-cache");
        int r = countService.updateCount(id,count);
        if (r==1){
            return ResultUtil.success(r);
        }else {
            return ResultUtil.error(r);
        }
    }
}