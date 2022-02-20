package main

import (
	"container/list"
	"fmt"
)

type IntegerHeap []int

func main() {
	fmt.Printf("hello, world\n")
	fmt.Printf("See")
	reverse()
	basics()
	checkList()

	i, j, k := checkTuples()
	fmt.Println(i, j, k)

	var intHeap *IntegerHeap = &IntegerHeap{1, 4, 5}
	checkHeap(intHeap)
}

func checkHeap(iHeap *IntegerHeap) {

}

func reverse() {
	fmt.Println("What a reverse")
}

func basics() {
	v := "Hello GoLang, How we doing"
	fmt.Println(v)
}

func checkList() {
	var intList list.List

	intList.PushFront(11)
	intList.PushBack(34)
	intList.PushBack(45)
	intList.PushBack(90)

	for element := intList.Front(); element != nil; element = element.Next() {
		fmt.Println(element.Value)
	}
}

func checkTuples() (position int32, candidate string, qualified bool) {
	position = 3
	candidate = "Tuple is good"
	qualified = true
	return
}
