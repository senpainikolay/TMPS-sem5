package pizza

import "fmt"

func GeneratePizza(pizzaType int) int {
	var pizza = &SimplePizza{}

	switch pizzaType {
	case 1:
		//Add tomato topping
		pizzaWithTomato := &TomatoTopping{
			pizza: pizza,
		}

		fmt.Printf("Price of simple pizza  with tomato topping is %d\n", pizzaWithTomato.getPrice())
		return pizzaWithTomato.getPrice()
	case 2:
		//Add cheese topping
		pizzaWithCheese := &CheeseTopping{
			pizza: pizza,
		}
		fmt.Printf("Price of simple pizza cheese topping is %d\n", pizzaWithCheese.getPrice())
		return pizzaWithCheese.getPrice()
	case 3:
		//Add cheese topping
		pizzaWithCheese := &CheeseTopping{
			pizza: pizza,
		}
		//Add tomato topping
		pizzaWithCheeseAndTomato := &TomatoTopping{
			pizza: pizzaWithCheese,
		}

		fmt.Printf("Price of simple pizza  with tomato and cheese topping is %d\n", pizzaWithCheeseAndTomato.getPrice())
		return pizzaWithCheeseAndTomato.getPrice()
	default:
		fmt.Printf("Cost of simple pizza is %d\n", pizza.getPrice())
		return pizza.getPrice()

	}

}

func PrintMenu() {
	fmt.Println("Price of simple pizza  with tomato topping is 9 SEND TYPE 1 ")
	fmt.Println("Price of simple pizza  with cheese topping is 10  SEND TYPE 2")
	fmt.Println("Price of simple pizza  with cheese && tomato topping is 13  SEND TYPE 3")
	fmt.Println("Price of simple pizza  is 7  SEND TYPE 4")

}
