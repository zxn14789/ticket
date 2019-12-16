package ticker.demo.dao;

import ticker.demo.entity.Number;

import java.util.List;

public interface NumberMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Number record);

    Number selectByPrimaryKey(Integer id);

    List<Number> selectAll();

    int updateByPrimaryKey(Number record);
}