package main

import (
	"fmt"

	SOLID "github.com/senpainikolay/TMPS-sem5/Lab1/SOLID"
)

func main() {
	fmt.Println("Single Responsible Principle")
	book := SOLID.Book{"Crime and Punishment", "Dostoievskii", "Ok lol"}
	book2 := SOLID.Book{"Don Quijote", "Cervantes", "Ok lol 2 "}
	book.Text = book.ReplaceWordInText("lol", "kek")

	bookPrinter := SOLID.BookPrinter{}
	bookPrinter.Print(book.Name, book.Author, book.Text)
	bookPrinter.Print(book2.Name, book2.Author, book2.Text)

	fmt.Println("Open Closed Principle")

	customGuitar := SOLID.CustomizedGuitar{}
	customGuitar.Set("Calliope", 12.4, 6, 1, "Vanea")
	fmt.Println(customGuitar.Get())

}
