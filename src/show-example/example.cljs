(ns show-example.example
  (:require [showtime.showtime :refer [add-slide showtime]]))

;Slide test
(add-slide
 [:h1 "Slide title"]
 [:span "Esse eh o primeiro Slide e abaixo os topicos"]
 [:ul
  (for [x (range 1 10)]
    [:li x])])


(add-slide
 [:h1 "Slide 2! Transicao funcionando"]
 [:span "Worked!!!!"])

(add-slide
 [:h1 "Slide 3!"]
 [:span "Fuck yaeh!!!!"])


(add-slide
 [:h1 "Slide 4!"]
 [:span "Agora sim!!!!"])


(add-slide
 [:h1 "Slide 5!"]
 [:span "Temos que melorar os controles"])


(showtime)
