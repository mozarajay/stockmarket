Super Simple Stock Market
----------------------------------------------------------------------------------------------------------
   Example Assignment – Super Simple Stock Market
----------------------------------------------------------------------------------------------------------
Requirements:
----------------------------------------------------------------------------------------------------------
1. Provide working source code that will :-
  a. For a given stock,
    i.  Given any price as input, calculate the dividend yield
    ii. Given any price as input, calculate the P/E Ratio
    iii.Record a trade, with timestamp, quantity of shares, buy or sell indicator and traded price
    iv. Calculate Volume Weighted Stock Price based on trades in past 15 minutes
  b. Calculate the GBCE All Share Index using the geometric mean of prices for all stocks
-----------------------------------------------------------------------------------------------------------
Constraints & Notes
-----------------------------------------------------------------------------------------------------------
1. Written in one of these languages:
	Java, C#, C++, Python
2. No database or GUI is required, all data need only be held in memory
3. No prior knowledge of stock markets or trading is required – all formulas are provided below.
----------------------------------------------------------------------------------------------------------
Application Feature
----------------------------------------------------------------------------------------------------------
1) It is written using Java 8 and Spring Boot
2) It is Server Application running on tomcat port 8080
3) Application contain REST APIs for the required 5 functions given in requirements
----------------------------------------------------------------------------------------------------------
HOW TO USE
----------------------------------------------------------------------------------------------------------
This is maven Project, so you can run:
     a) mvn test -> to execute the unit tests.
     b) mvn package -> to generate the executable jar.
     
To run the program just run:
    java -jar stockmarket-0.0.1-SNAPSHOT.jar
    
To run REST API:
     This is spring boot application you can deploy just by running SimpleStockMarketApplication class 
     and test below rest api using postman by filling appropriate values needed for the APIs:
     
      a) http://127.0.0.1:8080/stockexchange/stock/{symbol}/dividendyield/stockPrice=?
      b) http://127.0.0.1:8080/stockexchange/stock/{symbol}/peratio/stockPrice=?
      c) http://127.0.0.1:8080/stockexchange/stock/{symbol}/vwprice
      d) http://127.0.0.1:8080/stockexchange/trade/tradeRequest=?
      e) http://127.0.0.1:8080/stockexchange/gbce
      
Application can deploy as service separately and any other application/system can call required rest api
------------------------------------------------------------------------------------------------------------
TEST Controller Classes
------------------------------------------------------------------------------------------------------------
    1) com.jpmorgan.simplestockmarket.stock.controller.StockControllerTest
    2) com.jpmorgan.simplestockmarket.trade.controller.TradeControllerTest
    3) com.jpmorgan.simplestockmarket.controller.SimpleStockMarketControllerTest

     
