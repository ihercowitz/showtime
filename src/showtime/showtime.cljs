(ns showtime.showtime
  (:require [dommy.core :as dommy])
  (:use-macros
   [dommy.macros :only [node sel sel1]]))

(def slide-sequence [(atom -1) (atom [])])

;Showtime functions
(defn- slide [itens]
  (doseq [item itens]
    (dommy/append!
     (sel1 :#content)
     (node item))))

(defn add-slide [& content]
  (swap! (last slide-sequence) conj content))

(defn- change-slide [slide]
  (dommy/clear! (sel1 :#content))
  (doseq [x (@(last slide-sequence) slide)]
    (dommy/append!
     (sel1 :#content)
     (node x))))


(defn- slide-control [f]
  (let [total-slides (count @(last slide-sequence))
        current-slide @(first slide-sequence)
        chosen-slide (swap! (first slide-sequence) f)]
    (cond
     (>= chosen-slide total-slides) (reset! (first slide-sequence) (dec total-slides)) 
     (<= chosen-slide 0) (reset! (first slide-sequence) 0)
     :default chosen-slide)))

(defn- key-control [evt]
  (cond
   (= 39 (.-keyCode evt)) (change-slide (slide-control inc))
   (= 37 (.-keyCode evt)) (change-slide (slide-control dec))))


(dommy/listen! (sel1 :body) :keyup key-control)


(defn showtime
  []
  (change-slide 0))
