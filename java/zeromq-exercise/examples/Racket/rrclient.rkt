#lang racket
#|
#   Request-reply client in Racket
#   Connects REQ socket to tcp://localhost:5559
#   Sends "Hello" to server, expects "World" back
|#
(require net/zmq)

;  Prepare our context and sockets
(define ctxt (context 1))
(define sock (socket ctxt 'REQ))

(socket-connect! sock "tcp://localhost:5559")

;  Do 10 requests, waiting each time for a response
(for ([request (in-range 10)])
  (printf "Sending request ~a...\n" request)
  (socket-send! sock #"Hello")
  
  ;  Get the reply.
  (define message (socket-recv! sock))
  (printf "Received reply ~a [~a]\n" request message))

(context-close! ctxt)
