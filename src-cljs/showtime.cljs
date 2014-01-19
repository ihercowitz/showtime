(ns showtime.showtime
  (:require [dommy.core :as dommy])
  (:use-macros
   [dommy.macros :only [node sel sel1]]))

;Showtime functions
(defn slide [& itens]
  (doseq [item itens]
    (dommy/append!
     (sel1 :#content)
     (node item))))


(defn change-slide [slide]
  (dommy/clear! (sel1 :#content))
  (apply slide))

(defn key-control [evt]
  (cond
   (= 39 (.-keyCode evt)) (change-slide slide2)
   (= 37 (.-keyCode evt)) (change-slide slide1)))


(dommy/listen! (sel1 :body) :keyup key-control)


;Slide test
(defn slide1 [] (slide
             [:h1 "Slide title"]
             [:span "Esse eh o primeiro Slide e abaixo os topicos"]
             [:ul
              (for [x (range 1 10)]
                [:li x])]))


(defn slide2 [] (slide
             [:h1 "Slide 2! Transicao funcionando"]
             [:span "Worked!!!!"]))


(slide1)
