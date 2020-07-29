# Harbacore.com.stockmanagement
Stock mamangement 
  ## About
  1. A Stock Management system with the following tables
     1. Main Stock Table : Here all In stock related info is written like how many products are left if stock, last date of latest stock entry,etc.
     2. Stock In table : This table contains all the entries of every product entry to stock.
     3. Stock Out Table : Contains all stock out entries.
     4. Replacement Table: Contains the details of the products in replacemnt or replaced item.
     5. Products Table: This contains all the info about the products that we have
  2. Functioning 
     1. Entery is made in Stock_In, Stock_Out tables and Replacement_table and through these our main Stock is updated
     2. Quantity and Update_date is updated in MainStock_Table 
     3. **TRANSACTIONS** are used to avoid data inconsistency
  ## SQL Queries
    1. Products Table:
        1. @Query("select productName from Products ")
           List<String> findAllProductsByName();

        2. @Query("select productName from Products where productName=:productName")
           List<String> checkName(List<String> productName);
    
    2. Main Stock Table
        1. MainStock findByProductName(String productName);
        
    3. JPA Queries(Please See stock services)
       1. stockRepository.save(prod);
       2. stockInRepository.save(prod1);
       3. stockRepository.findByProductName(productName);
       4. stockOutRepository.save(prod2);
       5. productRepository.findAllProductsByName();
       6. productRepository.findAllProductsByName();
       
   ## User Interface
    - some pics here
