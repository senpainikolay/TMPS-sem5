package pizza

// Pizza
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
