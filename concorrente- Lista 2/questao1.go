package main

import ("time"
        "fmt"
        "math/rand"
)

var ( canal1 = make(chan string)
      canal2 = make(chan string)
      canal3 = make(chan string)
)

func main() {
    reliableRequest()
}

func reliableRequest(){
       
    go func() {
        r := rand.New(rand.NewSource(time.Now().UnixNano()))
        var tempo = r.Intn(35)
        time.Sleep(time.Second * time.Duration(tempo))
        request("mirror1.com")
        <- canal1
    }()

    go func() {
        r := rand.New(rand.NewSource(time.Now().UnixNano()))
        var tempo2 = r.Intn(35)
        time.Sleep(time.Second * time.Duration(tempo2))
        request("mirror2.br")
        <- canal2
    }()

    go func(){
        r := rand.New(rand.NewSource(time.Now().UnixNano()))
        var tempo3 = r.Intn(35)
        time.Sleep(time.Second * time.Duration(tempo3))
        request("mirror3.edu")
        <- canal3
    }()
    
        select {
          case msg1 := <-canal1:
            fmt.Println("Primeiro servidor a responder", msg1)
          case msg2 := <-canal2:
            fmt.Println("Primeiro servidor a responder", msg2)
          case msg3 := <-canal3:
            fmt.Println("Primeiro servidor a responder", msg3)
   }
}

func request(serverName string) {
    
    if serverName == "mirror1.com" {
      canal1 <- "mirror1"
    }

    if serverName == "mirror2.br" {
      canal2  <- "mirror2"
    }

    if serverName == "mirror3.edu" {
      canal3 <- "mirror3"
    }
}
