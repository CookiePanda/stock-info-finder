package com.panda.moneymonster.crawler;

import com.panda.moneymonster.domain.entity.Stock;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.IOException;
import java.util.List;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
@MapperScan("com.panda.moneymonster.mapper.StockMapper")
public class StocklistCrawlerTest {
    /** Logger */
    private static final Logger LOGGER = LoggerFactory.getLogger(StocklistCrawlerTest.class);
    @Autowired
    private StocklistCrawler stocklistCrawler;

    @Test
    public void addStockListTest() throws IOException {
        LOGGER.info("Begin to crawler stocklist");
        List<Stock> stockList = stocklistCrawler.visit();
        LOGGER.info("Crawler is completed");
    }


}
