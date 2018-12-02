package com.panda.moneymonster.utils;

import com.panda.moneymonster.domain.entity.Stock;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author panda
 */
public class StockTextUtils {
    /** Logger */
    private static final Logger LOGGER = LoggerFactory.getLogger(StockTextUtils.class);

    public static Stock getStocks(String rawStockInfo){
        LOGGER.info("Begin to cook raw stock info.{}",rawStockInfo);
        Stock stock = new Stock();
        // make raw to delicious
        String[] splits = rawStockInfo.replace(")", "").split("\\(");
        try {
            stock.setStockName(splits[0]);
            stock.setStockCode(splits[1]);
        }catch (Exception e){
            LOGGER.error("Set stock attr error.");
            return null;
        }
        LOGGER.info("Done cooking with: {}",stock.toString());
        return stock;
    }

}
