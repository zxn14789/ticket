package ticker.demo.result;

public class ResultUtil {

    /**成功且带数据**/
    public static Result success(Object object){
        Result result = new Result();
        result.setCode(ResultEnum.SUCCESS.getCode());
        result.setMsg(ResultEnum.SUCCESS.getMsg());
        result.setData(object);
        return result;
    }
    public static Result success(String msg,Object object) {
        Result result = new Result();
        result.setCode(ResultEnum.SUCCESS.getCode());
        result.setMsg(msg);
        result.setData(object);
        return result;
    }
    /**成功但不带数据**/
    public static Result success(){
        return success(null);
    }
    /**失败**/
    public static Result error(){
        Result result = new Result();
        result.setCode(ResultEnum.FAIL.getCode());
        result.setMsg(ResultEnum.FAIL.getMsg());
        return result;
    }
    public static Result error(Object object){
        Result result = new Result();
        result.setCode(ResultEnum.FAIL.getCode());
        result.setMsg(ResultEnum.FAIL.getMsg());
        result.setData(object);
        return result;
    }
    public static Result error(String msg,Object object){
        Result result = new Result();
        result.setCode(ResultEnum.FAIL.getCode());
        result.setMsg(msg);
        result.setData(object);
        return result;
    }

}