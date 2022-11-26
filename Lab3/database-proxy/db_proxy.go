package inMemoryDB

import (
	"math/rand"

	wallet "github.com/senpainikolay/TMPS-sem5/lab2/digital-wallet-facade"
	pizzaGenerator "github.com/senpainikolay/TMPS-sem5/lab2/pizza-generator-decorator"
)

const (
	ADMIN = iota
	USER
)

var walletFacade *wallet.WalletFacade

type ProxyDB struct {
	db *inMemoryDB
	// Permission Proxy :))
	roleMap map[string]int
	// Session Token
	tokenMap map[string]string
}

func GetProxy(db *inMemoryDB) *ProxyDB {
	return &ProxyDB{
		db:       db,
		roleMap:  make(map[string]int),
		tokenMap: make(map[string]string),
	}
}

func (pdb *ProxyDB) LogInUser(name string, pw []byte) (bool, string) {
	token := randStr(10)
	pdb.tokenMap[name] = token
	pizzaGenerator.PrintMenu()
	return pdb.db.LogInUser(name, pw), token

}

func (pdb *ProxyDB) RegisterUser(name string, pw []byte) bool {
	res := pdb.db.RegisterUser(name, pw)
	if res {
		pdb.roleMap[name] = USER
	}
	return res
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

func (pdb *ProxyDB) UpdateUserPW(name string, pw []byte, tk string) bool {
	if tk != pdb.tokenMap[name] {
		return false
	}
	success := pdb.db.UpdateUserPW(name, pw, tk)
	if !success {
		return false
	}
	return true

}

func (pdb *ProxyDB) SetAdminStatus(name string) {
	pdb.roleMap[name] = ADMIN
}

func (pdb *ProxyDB) OpenWallet(usr string) string {
	_, err := pdb.tokenMap[usr]
	if !err {
		return "NOT LOGGED IN!! Unable to open a wallet!!!"
	}
	walletFacade = wallet.NewWalletFacade(usr, pdb.tokenMap[usr])
	return "succesfull opened wallet!"
}

func (pdb *ProxyDB) AddToWallet(usr string) string {
	_, exist := pdb.tokenMap[usr]
	if !exist {
		return "NOT LOGGED IN!!"
	}
	err := walletFacade.AddMoneyToWallet(usr, pdb.tokenMap[usr], 10)
	if err != nil {
		return err.Error()
	}
	return "successful added moneye! 10 $ !! "
}
func (pdb *ProxyDB) DeductFromWallet(usr string, pizzaType int) string {
	_, exist := pdb.tokenMap[usr]
	if !exist {
		return "NOT LOGGED IN!!"
	}
	err := walletFacade.DeductMoneyFromWallet(usr, pdb.tokenMap[usr], pizzaGenerator.GeneratePizza(pizzaType))
	if err != nil {
		return err.Error()
	}
	return "Succesful pizza bougth"
}
func randStr(n int) string {
	charset := []byte("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ")

	b := make([]byte, n)
	for i := range b {
		b[i] = charset[rand.Intn(len(charset))]
	}
	return string(b)
}
