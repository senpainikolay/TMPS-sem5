package SOLID

import (
	"fmt"
	"strings"
)

type Book struct {
	Name   string
	Author string
	Text   string
}

func (b *Book) ReplaceWordInText(wordToReplace string, wordForReplace string) string {
	return strings.ReplaceAll(b.Text, wordToReplace, wordForReplace)
}

func (b *Book) FindWord(word string) bool {
	return strings.Contains(b.Text, word)
}

type BookPrinter struct{}

func (bp *BookPrinter) Print(name, author, text string) {
	fmt.Printf("The book is called %v and it was written by %v \n", name, author)
	fmt.Println("The context of the book:")
	fmt.Println(text)
}

type BookTranslator struct {
	language string
}

func (bt *BookTranslator) Translate(text string) string {
	// return translateMethod(Text, bt.language)
	return "none"
}
