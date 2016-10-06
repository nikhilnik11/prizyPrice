Prizy Pricer

  1.	Three functionalities viz. Product Loader (Submit Survey Product), Product List (FetchAllProducts), Product Viewer (FetchProduct)       are provided using RestControllers.
  2.	In memory HSQL database is used, Which is flushed every time on server start up and loaded with initial data.
  3.	The Database scripts are mention in data.sql, placed at root location of the project.

Running the application

  1.	Go to com.xebia.prizy.application.Application class. Run as java application.
  2.	Spring Boot is used to boot the application.
  3.	Default port is mentioned as 8097 (Mentioned in application.properties).
  4.	There are three Rest endpoints:
  
    a.	Product List (FetchAllProducts) :
    
      i.	Hit http://localhost:8097/allProducts from browser or client like Postman to fetch all the products saved in DB.
            b.	Product Loader (Submit Survey Product) :
                 i.	Hit a post request from Postman to http://localhost:8097/submitSurvey, add ‘Content-Type:application/json’ in the header with request body as follows :
                  ii.	Product will be the object for which survey is being submitted.
              
                    {
                        "product":{
                        "id": 1,
                        "barCode": "12SP34",
                        "name": "Samsung Phone",
                        "discription": "Samgung s7"
                      },
                        "priceByUser": "2000",
                        "notes": "Nikhil Inserted 3"
                     }        
          c.	Product Viewer (FetchProduct):
              i.	Hit a get request using URL http://localhost:8097/product?code=12SP34, code will be the bar code of the product for                 which the details needs to be fetched.
              ii.	Initially the price will be Zero. Unless you submit some surveys first.

Implementation of new Ideal price formulas
        1.	Whenever a new ideal price formula needs to be entered. Just make a new class implementing IIdealPriceFormula.
        2.	Change the qualifier in PriceCalculator class to the newly create class.
Running the Tests
        1.	Go to com.xebia.prizy.testpricecalculator.PriceCalculatorTest class. Run as junit application.
        2.	Formulas to find average weight, lowest weight, highest weight and ideal weight as tested.
