# Laboratory Work 2. Structural Patterns

### Course: Design Patterns
### Author: Nicolae Gherman

----

## Theory 

Structural patterns define how each component or entity should be structured so as to have very flexible interconnecting modules which can work together in a larger system. Structural patterns describe how classes and objects can be combined to form larger structures.



## Objectives:

* Get familiar with structural design patterns
* Implement the  x out of 5 Structural Patterns.

## Implementation description 
I have implemented 3 Patters: 
* Proxy 
* Decorator 
* Facade 
<br>
I have decided to  simulate the   Registration (CRUD on databse depending on permision roles.), the  Opening of  a Digital Wallet , adding to wallet,  and Command Pizza deping on type of pizzas. All that happens in memory, in a map database. All that happens through POST requests on a http server. <br>   

SO, The part with registration is handled by a  <b> proxy </b> in  'database-proxy ' folder. Additional functionalities are added to the proxy.  <br>
The facade is a sum up of digital wallet functionalities (sub system features such as  account, ledger, security code). So the two methods AddMoneyToWallet and DeductMoneyFromWallet serves as the 'interface' or the <b> facade </b> because it contains the  backend logic of wallet functionalities.  <br> 
The decorator patterns is simple implemented on choosing the topping of pizzas which represents the actual types of pizza which the client can command!. <br>

#### S
 
1.  Proxy Database  

Firstly, the server routes looks like these:

```     
r.HandleFunc("/register/{usr}/{pw}", RegisterUser).Methods("POST")
r.HandleFunc("/login/{usr}/{pw}", LogInUser).Methods("POST")
r.HandleFunc("/updatePW/{usr}/{pw}/{token}", UpdateUsrPW).Methods("PUT")
r.HandleFunc("/setAdmin/{usr}", SetAdmin).Methods("PUT")
r.HandleFunc("/deleteUser/{who}/{which}", DeleteUser).Methods("POST") 

``` 

So the proxy manages the permissions before the actually changes are registered into the database.  
Some of them: 
```  
func (pdb *ProxyDB) LogInUser(name string, pw []byte) (bool, string) {
	token := randStr(10)
	pdb.tokenMap[name] = token
	pizzaGenerator.PrintMenu()
	return pdb.db.LogInUser(name, pw), token

}
func (pdb *ProxyDB) PrintUserPW(name string) (string, bool) {

	if pdb.roleMap[name] == ADMIN {
		return pdb.PrintUserPW(name)
	}
	return "not an admin", true
}

func (pdb *ProxyDB) DeleteUser(whoIsDeleting string, whoToDelete string) bool {
	if pdb.roleMap[whoIsDeleting] == ADMIN {
		return pdb.db.DeleteUser(whoToDelete, whoIsDeleting)
	}
	return false
}
```

2. The Digital Wallet
Basically the  methods sums up the features of the wallet, making it a Facade. 
```   
// walletFacade.go 

func (w *WalletFacade) AddMoneyToWallet(accountID string, securityCode string, amount int) error {
...
}

func (w *WalletFacade) DeductMoneyFromWallet(accountID string, securityCode string, amount int) error {
... 
} 

``` 

3. The pizza 

Basically, the wrappers are presented below: 
``` 
type SimplePizza struct{}

func (p *SimplePizza) getPrice() int {
	return 7
}

// Decorator
type TomatoTopping struct {
	pizza IPizza
}

type CheeseTopping struct {
	pizza IPizza
}

// Helper functions for decorators
func (c *TomatoTopping) getPrice() int {
	pizzaPrice := c.pizza.getPrice()
	return pizzaPrice + 2
}

func (c *CheeseTopping) getPrice() int {
	pizzaPrice := c.pizza.getPrice()
	return pizzaPrice + 3
}
```

---  

Shortly: So the user has to register and open a wallet though request. He can add money to that wallet  and buy pizza depending on how much money he got in the wallet. 


## The request: 

1. localhost:8080/register/usr/ok 
 Payload: 

 ```
 Succesful register 
``` 

2.  localhost:8080/login/usr/ok 
Actually, generate a session token that can be used on updating the password! ( addition functionalies on proxy ) 

Payload: 

``` 
XVlBzgbaiC
```  
And it prints the menu: 
```
Price of simple pizza  with tomato topping is 9 SEND TYPE 1 
Price of simple pizza  with cheese topping is 10  SEND TYPE 2
Price of simple pizza  with cheese && tomato topping is 13  SEND TYPE 3
Price of simple pizza  is 7  SEND TYPE 4

```
3.  localhost:8080/openWallet/usr 

Payload: 
``` 
succesfull opened wallet! 
```
Print: 
```
Starting create account
Account created

```

4. localhost:8080/CommandPizza/usr/3  
Payload 
``` 
Balance is not sufficient 
``` 
5. localhost:8080/addToWallet/usr 
Payload: 
``` 
successful added moneye! 10 $ !! 
``` 
Print ( actually the features of the wallet ): 
``` 
Starting debit money from wallet
Account Verified
SecurityCode Verified
Starting add money to wallet
Account Verified
SecurityCode Verified
Wallet balance added successfully
Sending wallet credit notification
Make ledger entry for accountId usr with txnType credit for amount 10

```
6. localhost:8080/CommandPizza/usr/2  
Payload:
``` 
Succesful pizza bougth
``` 

Print: 

``` 
Price of simple pizza cheese topping is 10
Starting debit money from wallet
Account Verified
SecurityCode Verified
Wallet balance is Sufficient
Sending wallet debit notification
Make ledger entry for accountId usr with txnType credit for amount 10

```

