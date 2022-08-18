package com.icefaces.mapper;

import com.icefaces.models.RFncFunction;
import com.icefaces.models.RFncFunctionExample;
import com.icefaces.models.RFncFunctionKey;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RFncFunctionMapper {
    long countByExample(RFncFunctionExample example);

    int deleteByExample(RFncFunctionExample example);

    int deleteByPrimaryKey(RFncFunctionKey key);

    int insert(RFncFunction row);

    int insertSelective(RFncFunction row);

    List<RFncFunction> selectByExample(RFncFunctionExample example);
    List<RFncFunction> selectAll();

    RFncFunction selectByPrimaryKey(RFncFunctionKey key);

    int updateByExampleSelective(@Param("row") RFncFunction row, @Param("example") RFncFunctionExample example);

    int updateByExample(@Param("row") RFncFunction row, @Param("example") RFncFunctionExample example);

    int updateByPrimaryKeySelective(RFncFunction row);

    int updateByPrimaryKey(RFncFunction row);
}