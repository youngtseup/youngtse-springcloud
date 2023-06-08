package com.youngtse.mapper.slave;

import com.youngtse.domain.entity.SlaveTest;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Title: SlaveTestMapper
 * @Date 2023/4/30 1:51
 * @Author Youngtse
 * @Description: TODO
 */
@Mapper
public interface SlaveTestMapper {
    void insertSlaveTest(SlaveTest slaveTest);

    SlaveTest getSlaveTestById(int id);

    void updateSlaveTest(SlaveTest slaveTest);

    void deleteSlaveTest(int id);
}
