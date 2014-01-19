(defproject showtime "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.5.1"]
                 [org.clojure/clojurescript "0.0-2138"]
                 [prismatic/dommy "0.1.2"]]
  :plugins [[lein-cljsbuild "1.0.1"]] 
  :cljsbuild {
             :builds [{
                       :source-paths ["src-cljs"]
                       :compiler {
                                  :output-to "resources/js/showtime.js"
                                  :optimizations :whitespace}}]})
