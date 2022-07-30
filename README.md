# Muhammed_emad_task
Task for deal services for progress soft application:
The end points with sample requests:
1- Save deal:

   Request:
   http://localhost:8086/deals (POST)
   {
    "deal_id":"1",
    "ordering_currency":"iqd",
    "to_currency_code":"usd",
    "time_stamp":"1/1/2020",
    "amount":"100"
}

    

2- Get all deal:

http://localhost:8086/deals/ (GET)

Response:

[
    {
        "deal_id": "1",
        "ordering_currency": "iqd",
        "to_currency_code": "jod",
        "time_stamp": "1/1/2020",
        "amount": 100.00
    }
]

3 - Update deal:
    http://localhost:8086/deals/2  (PUT)
    
    Request:
    {
    "deal_id":"50",
    "ordering_currency":"eur",
    "to_currency_code":"iqd",
    "time_stamp":"11:50:20 10/10/2020",
    "amount":"30"
}

4- Delete Deal:     (DELETE)
   Request :
   
   http://localhost:8086/deals/1
   
   
   
Note:for simplicity i did not use the DTO design pattern.
Note:use docker compose to run.
