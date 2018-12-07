package main

import "time"
import "fmt"
import "math/rand"
var c1 = make(chan string)
var c2 = make(chan string)
var c3 = make(chan string)
func main() {
    reliableRequest()
   
    
}
func reliableRequest(){
    
    // Cada canal receberá um valor depois de uma certa quantidade
    // de tempo, para simular e.x. o bloqueamento operações RPC
    // executando em goroutines simultâneas.    
    go func() {
        var tempo int = rand.Intn(1)
        time.Sleep(time.Second * time.Duration(tempo))
        request("mirror1.com")
        c1 <- "mirror1"
    }()
    go func() {
        var tempo2 int = rand.Intn(1)
        time.Sleep(time.Second * time.Duration(tempo2))
        c2 <- "mirror2"
    }()
    go func(){
        var tempo3 int = rand.Intn(1)
        time.Sleep(time.Second * time.Duration(tempo3))
        c2 <- "mirror3"
    }()


    // Nós iremos utilizar o `select` para esperar esses valores
    // simultâneamente, imprimindo cada um como ele chega.    
    
        select {
        case msg1 := <-c1:
            fmt.Println("Primeiro servidor a responder", msg1)
        case msg2 := <-c2:
            fmt.Println("Primeiro servidor a responder", msg2)
        
        case msg3 := <-c3:
            fmt.Println("Primeiro servidor a responder", msg3)
   }
}

func request(serverName string) {

    
}
