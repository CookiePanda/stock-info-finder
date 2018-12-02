package com.panda.moneymonster.crawler;

import com.panda.moneymonster.domain.entity.Stock;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 *  Crawl stocklist
 * @author panda
 */
public class StocklistCrawlerController {
    /** Logger */
    private static final Logger LOGGER = LoggerFactory.getLogger(StocklistCrawlerController.class);

    public static void main(String[] args) throws Exception {
        LOGGER.info("Begin to crawler stocklist");
        StocklistCrawler stocklistCrawler = new StocklistCrawler();
        List<Stock> stockList = stocklistCrawler.visit();
        LOGGER.info("Crawler is completed");
    }
}
