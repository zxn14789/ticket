package ticker.demo.controller;

import ticker.demo.entity.Train;
import ticker.demo.result.Result;
import ticker.demo.result.ResultUtil;
import ticker.demo.service.TrainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
public class TrainController {

    @Autowired
    TrainService trainService;

    @GetMapping("/train")
    public Result all(HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Cache-Control","no-cache");
        List<Train> trains = trainService.selectAll();
        return ResultUtil.success(trains);
    }
}