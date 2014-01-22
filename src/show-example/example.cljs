(ns show-example.example
  (:require [showtime.showtime :refer [showtime]]))

(def slide1
  '([:h1 "Header inicial"]
    [:p "Usando <p> junto"]))

(def slide2
  '([:h1 "Segundo Slide"]
    [:p "Functional way?"]))

(showtime
 slide1
 slide2)
 
