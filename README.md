# Hulk-Store-Redis-Springboot

This is a minimal proyect where we use spring boot as framework to expose differents endpoints and redis as database trying to simulate a real store to sell products. All services are exposed in **http://localhost:8080/** .

# How to run 
  - First you need to install the spring boot tool , you can find it at the official page **https://spring.io/tools**.
  - Then you need the redis server, you can download it here **https://github.com/MicrosoftArchive/redis/releases**.
  - Once you have all tools you just need to clone this repository, open it with the spring tool.
  - Run the redis server.
  - Run the proyect.

# How to use

Using postman you can use the diferents endpoints of this proyect:

  - The first one is **/createProduct** this endpoint create a producto. You can use this doing a post petition.
  
example body 

```{"amount": 1, "price": 100, "name": "patata"}```
  - with a get petition **/Products** you can see all your products.
  - with a get petition **/Product/{name}** you can see a specific producto by name.
  - with a put petition **sellProduct/{name}/{amountToSell}** you can reduce the stock of a product.
  - with a put petition **addStock/{name}/{amountToAdd}** you can add stock to a specific product.
  - with a delete petition **/Products/{name}** you can delete a specific product.
  
  
  
