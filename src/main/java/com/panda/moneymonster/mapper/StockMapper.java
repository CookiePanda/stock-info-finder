package com.panda.moneymonster.mapper;

import com.panda.moneymonster.domain.entity.Stock;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface StockMapper {

    @Insert("INSERT INTO " +
            "base_stock_info(stock_code,stock_name) " +
            "SELECT #{stockCode}, #{stockName} " +
            "FROM DUAL WHERE NOT EXISTS(" +
            "SELECT * " +
            "FROM base_stock_info " +
            "WHERE stock_code = #{stockCode} and stock_name=#{stockName})")
    int insertStock(Stock stock);

}
