package com.panda.moneymonster.crawler;

import com.panda.moneymonster.domain.entity.Stock;
import com.panda.moneymonster.mapper.StockMapper;
import com.panda.moneymonster.utils.StockTextUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 *  use for get newest stock list info.
 * @author panda
 */
@Service
class StocklistCrawler {
    private static final Logger LOGGER = LoggerFactory.getLogger(StocklistCrawler.class);
    private static final String STOCK_LIST_URL = "http://quote.eastmoney.com/stocklist.html";

    @Autowired
    private StockMapper stockMapper;

    List<Stock> visit() throws IOException {
        URL stocklistURL = new URL(STOCK_LIST_URL);
        LOGGER.info("starting visit: {}",stocklistURL);
        Document doc = Jsoup.parse(stocklistURL, 100000);
        Element quotesearch = doc.getElementById("quotesearch");
        if(!quotesearch.hasText()){
            LOGGER.error("ERROR: Get quotesearch fail!");
        }
        LOGGER.info("Get quotesearch");
        Elements li = quotesearch.getElementsByTag("li");
        if(li.isEmpty()){
            LOGGER.error("ERROR: Get li fail!");
        }
        LOGGER.info("Get li");
        int i = 0;
        List<Stock> stockList = new ArrayList<>();
        for (Element l:li) {
            String rawStockInfo = l.wholeText();
            LOGGER.info("Element:{}, {}",i,rawStockInfo);
            Stock stock = StockTextUtils.getStocks(rawStockInfo);
            try{
                LOGGER.info("Starting insert stock: {}",stock.toString());
                int cbr = stockMapper.insertStock(stock);
                if(cbr == 0 ){
                    LOGGER.error("ERROR: Cannot insert stock if same stock exists.");
                }
            } catch (Exception e){
                LOGGER.error("ERROR: insert stock fails.");
            }
            stockList.add(stock);
            i++;
        }
        return stockList;
    }
}
