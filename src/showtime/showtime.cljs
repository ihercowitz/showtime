(ns showtime.showtime
  (:require [dommy.core :as dommy])
  (:use-macros
   [dommy.macros :only [node sel sel1]]))

(def current-slide (atom 0))
(def ^:dynamic *slides* (atom #{}))

(defn show-click [evt]
  (.log js/console (.-screenY evt))
  (-> (next-slide)
      show-slide)
   )

(defn- show-slide [itens]
  (dommy/clear! (sel1 :#content))
  (doseq [item itens]
    (dommy/append!
     (sel1 :#content)
     (node item))))


(dommy/listen! (sel1 :body)
               :click show-click)


(defn- next-slide []
  (-> (swap! current-slide inc)
      get-slide))

(defn- previous-slide []
  (-> (swap! current-slide dec)
      get-slide))

(defn- get-slide [index]
  (nth (first @*slides*) index))

(defn- add-slides [slides]
  (swap! *slides* conj slides))

(defn showtime
  [& slides]
  (add-slides slides)
  (-> (get-slide 0)
      show-slide))
