(ns showtime.showtime
  (:require [dommy.core :as dommy])
  (:use-macros
   [dommy.macros :only [node sel sel1]]))

(def slide-sequence (atom []))

;Showtime functions
(defn slide [itens]
  (doseq [item itens]
    (dommy/append!
     (sel1 :#content)
     (node item))))

(defn add-slide [& content]
  (swap! slide-sequence conj content))

(defn change-slide [slide]
  (dommy/clear! (sel1 :#content))
  (doseq [x slide]
    (dommy/append!
     (sel1 :#content)
     (node x))))

(defn key-control [evt]
  (cond
   (= 39 (.-keyCode evt)) (change-slide (nth @slide-sequence 1))
   (= 37 (.-keyCode evt)) (change-slide (nth @slide-sequence 0))))


(dommy/listen! (sel1 :body) :keyup key-control)


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


(change-slide (nth @slide-sequence 0))
