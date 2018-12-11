package main

import (
    "runtime"
    "fmt"
    "time"
)

func main() {

     var overall [][]int
     a := make([]int, 0, 999999)
     //b := make([]int, 0, 999999)
    // c := make([]int, 0, 999999)
     overall = append(overall, a)
    //overall = append(overall, b)
    // overall = append(overall, c)
     time.Sleep(time.Second)
    

     overall = nil
     PrintMemUsage()

     runtime.GC()

}

func PrintMemUsage() {
        var m runtime.MemStats
        runtime.ReadMemStats(&m)

        fmt.Printf("Alloc = %v MiB", bToMb(m.Alloc))
       
}

func bToMb(b uint64) uint64 {
    return b / 1024 / 1024
}
