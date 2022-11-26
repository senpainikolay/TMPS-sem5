package main

import (
	"fmt"
	"log"
	"net/http"
	"strconv"

	"github.com/gorilla/mux"
	dbMod "github.com/senpainikolay/TMPS-sem5/lab2/database-proxy"
)

// declare the interface
var dbInterface dbMod.DatabaseProcesses

// real db
var db = dbMod.GetDB()

// proxy role control funcs
var pdb = dbMod.GetProxy(db)

func main() {
	// assign to the interface the proxy ( same as db funcs + additional proxy funcs)
	dbInterface = pdb

	r := mux.NewRouter()
	r.HandleFunc("/register/{usr}/{pw}", RegisterUser).Methods("POST")
	r.HandleFunc("/login/{usr}/{pw}", LogInUser).Methods("POST")
	r.HandleFunc("/updatePW/{usr}/{pw}/{token}", UpdateUsrPW).Methods("PUT")
	r.HandleFunc("/setAdmin/{usr}", SetAdmin).Methods("PUT")
	r.HandleFunc("/deleteUser/{who}/{which}", DeleteUser).Methods("POST")
	// Facade Wallet
	r.HandleFunc("/openWallet/{usr}", OpenWallet).Methods("POST")
	r.HandleFunc("/addToWallet/{usr}", AddToWallet).Methods("POST")
	r.HandleFunc("/CommandPizza/{usr}/{pizzaType}", DeductFromWallet).Methods("POST")
	log.Println("Runining on localhost:8080")
	http.ListenAndServe(":8080", r)

}

func RegisterUser(w http.ResponseWriter, r *http.Request) {
	vars := mux.Vars(r)
	usr := vars["usr"]
	pw := vars["pw"]
	success := dbInterface.RegisterUser(usr, []byte(pw))
	if !success {
		fmt.Fprint(w, "Not succesful register")
	} else {
		fmt.Fprint(w, "Succesful register")
	}

}
func LogInUser(w http.ResponseWriter, r *http.Request) {
	vars := mux.Vars(r)
	usr := vars["usr"]
	pw := vars["pw"]
	success, tk := dbInterface.LogInUser(usr, []byte(pw))
	if !success {
		fmt.Fprint(w, "Not suscces log in")
	} else {
		fmt.Fprint(w, tk)
	}

}
func UpdateUsrPW(w http.ResponseWriter, r *http.Request) {
	vars := mux.Vars(r)
	usr := vars["usr"]
	pw := vars["pw"]
	token := vars["token"]
	success := dbInterface.UpdateUserPW(usr, []byte(pw), token)
	if success {
		fmt.Fprint(w, "succesful updated")

	} else {
		fmt.Fprint(w, "Something wrong on updating")
	}

}
func SetAdmin(w http.ResponseWriter, r *http.Request) {
	vars := mux.Vars(r)
	usr := vars["usr"]
	pdb.SetAdminStatus(usr)

}
func OpenWallet(w http.ResponseWriter, r *http.Request) {
	vars := mux.Vars(r)
	usr := vars["usr"]
	msg := pdb.OpenWallet(usr)
	fmt.Fprint(w, msg)

}
func AddToWallet(w http.ResponseWriter, r *http.Request) {
	vars := mux.Vars(r)
	usr := vars["usr"]
	msg := pdb.AddToWallet(usr)
	fmt.Fprint(w, msg)

}
func DeductFromWallet(w http.ResponseWriter, r *http.Request) {
	vars := mux.Vars(r)
	usr := vars["usr"]
	pizzaIdType := vars["pizzaType"]
	intVar, _ := strconv.Atoi(pizzaIdType)
	msg := pdb.DeductFromWallet(usr, intVar)
	fmt.Fprint(w, msg)

}

func DeleteUser(w http.ResponseWriter, r *http.Request) {
	vars := mux.Vars(r)
	usr := vars["who"]
	usr2 := vars["which"]
	success := dbInterface.DeleteUser(usr, usr2)
	if success {
		fmt.Fprint(w, "succesful updated")

	} else {
		fmt.Fprint(w, "Something wrong on updating")
	}

}
