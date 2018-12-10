package main

import ("time"
        "fmt"
        "math/rand"
)

var ( canal1 = make(chan string)
      canal2 = make(chan string)
      canal3 = make(chan string)
      canal4 = make(chan string)
)

func main() {
    reliableRequest()
}

func reliableRequest(){
    
    started := time.Now()
    
    // Cada canal receberá um valor depois de uma certa quantidade
    // de tempo, para simular e.x. o bloqueamento operações RPC
    // executando em goroutines simultâneas.    
    go func() {
        r := rand.New(rand.NewSource(time.Now().UnixNano()))
        var tempo = r.Intn(10)
        time.Sleep(time.Second * time.Duration(tempo))
        request("mirror1.com")
        <- canal1
    }()

    go func() {
        r := rand.New(rand.NewSource(time.Now().UnixNano()))
        var tempo2 = r.Intn(10)
        time.Sleep(time.Second * time.Duration(tempo2))
        request("mirror2.br")
        <- canal2
    }()

    go func(){
        r := rand.New(rand.NewSource(time.Now().UnixNano()))
        var tempo3 = r.Intn(10)
        time.Sleep(time.Second * time.Duration(tempo3))
        request("mirror3.edu")
        <- canal3
    }()

    var msg string;

    // Nós iremos utilizar o `select` para esperar esses valores
    // simultâneamente, imprimindo cada um como ele chega.    
    
        select {
          case msg1 := <-canal1:
           msg = "Primeiro canal a chegar: " + msg1
          case msg2 := <-canal2:
           msg = "Primeiro canal a chegar: " + msg2
          case msg3 := <-canal3:
           msg = "Primeiro canal a chegar: " + msg3
        }
  
  took := time.Since(started).Seconds()
  fmt.Println(took)

  if took < 2 {
    fmt.Println(msg)
  } else {
    fmt.Println("Erro: Tempo de execução superior a dois segundos, igual à = ", took)
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
