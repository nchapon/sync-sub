(ns sync-sub.core-test
  (:use [midje.sweet]
        [sync-sub.core])
  (:import [org.joda.time LocalTime]))

(def start (LocalTime. 0 0 0 0))

(fact "Add millis" (add-millis "01:05:12,598" 1000) => (LocalTime. 1 5 13 598))

(fact "Read file into vector"
  (get-lines "resources/sub.srt") => not-empty)


(fact "Convert string to LocalTime"
  (convert-to-time "00:09:53,678") => (LocalTime. 0 9 53 678))

(fact "Convert string to LocalTime when millis starts with zero"
  (convert-to-time "00:09:00,078") => (LocalTime. 0 9 0 78))


(fact "Is time ?" (is-time? "00:00:35,769 --> 00:00:37,964") => true)
(fact "It's not a time" (is-time? "no time") => false)
(fact "It's not a time" (is-time? "") => false)
