package main

import ("time"
        "fmt"
        "math/rand"
        "os"
)

var ( canal1 = make(chan string)
      canal2 = make(chan string)
      canal3 = make(chan string)
      done = make(chan interface{})
)

func main() {

	go killer(done)

	r := rand.New(rand.NewSource(time.Now().UnixNano()))
	var number = r.Intn(15)

  for i := 0; i < number; i++ {
		go reliableRequest()
	}

  time.Sleep(1 * time.Minute)
}

func reliableRequest(){
    
    // Cada canal receberá um valor depois de uma certa quantidade
    // de tempo, para simular e.x. o bloqueamento operações RPC
    // executando em goroutines simultâneas.    
    go func() {
        r := rand.New(rand.NewSource(time.Now().UnixNano()))
        var tempo = r.Intn(15)
        time.Sleep(time.Second * time.Duration(tempo))
        request("mirror1.com")
        <- canal1
    }()

    go func() {
        r := rand.New(rand.NewSource(time.Now().UnixNano()))
        var tempo2 = r.Intn(15)
        time.Sleep(time.Second * time.Duration(tempo2))
        request("mirror2.br")
        <- canal2
    }()

    go func(){
        r := rand.New(rand.NewSource(time.Now().UnixNano()))
        var tempo3 = r.Intn(15)
        time.Sleep(time.Second * time.Duration(tempo3))
        request("mirror3.edu")
        <- canal3
    }()


    // Nós iremos utilizar o `select` para esperar esses valores
    // simultâneamente, imprimindo cada um como ele chega.    
    
        select {
          case msg1 := <-canal1:
            fmt.Println("Primeiro servidor a responder", msg1)
          case msg2 := <-canal2:
            fmt.Println("Primeiro servidor a responder", msg2)
          case msg3 := <-canal3:
            fmt.Println("Primeiro servidor a responder", msg3)
          case <-done:
			      return
            
          time.Sleep(2 * time.Minute)
        }
}

func request(serverName string) {
    
    done <- "apenas p dizer q o programa pode ser cancelado"

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

func killer(done chan interface{}) {

  os.Stdin.Read(make([]byte, 1))
	close(done)

}
