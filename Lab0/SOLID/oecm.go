package SOLID

import "fmt"

type Guitar struct {
	model        string
	volume       float32
	metalStrings int
}

func (g *Guitar) Set(model string, volume float32, nrString int) {
	g.model = model
	g.volume = volume
	g.metalStrings = nrString
}
func (g *Guitar) Get() string {
	return fmt.Sprintf("Model name: %v \n Volume %v\n Nr of strings: %v \n", g.model, g.volume, g.metalStrings)

}

type CustomizedGuitar struct {
	Guitar
	designId    int
	nameOfOwner string
}

func (g *CustomizedGuitar) Set(model string, volume float32, nrString int, id int, owner string) {
	g.model = model
	g.volume = volume
	g.metalStrings = nrString
	g.designId = id
	g.nameOfOwner = owner
}

func (g *CustomizedGuitar) Get() string {
	return fmt.Sprintf("Model name: %v \n Volume %v\n Nr of strings: %v \n Unique Id: %v \n Name of Owner %v\n ", g.model, g.volume, g.metalStrings, g.designId, g.nameOfOwner)
}
