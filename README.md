# Shopping
Shopping cart

 insert products :
 
 {
  "products": [
    {
      "name": "prd1",
      "pictureUrl": "prd1",
      "price": 10
    },
{
      "name": "prd2",
      "pictureUrl": "prd2",
      "price": 20
    },
{
      "name": "prd3",
      "pictureUrl": "prd3",
      "price": 30.93
    },
{
      "name": "prd4",
      "pictureUrl": "prd4",
      "price": 450
    },
{
      "name": "prd5",
      "pictureUrl": "prd5",
      "price": 500
    }
  ]
}
--------------------------------------
add order

{
  "productOrders": [
    {
      "product": {
		"id":1,
        "name": "prd1",
        "pictureUrl": "prd1",
        "price": 10
      },
      "quantity": 5
    },
	{
      "product": {
		"id":2,
        "name": "prd2",
        "pictureUrl": "prd2",
        "price": 20
      },
      "quantity": 6
    }
  ]
}
-------------------------------------------
