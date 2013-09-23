(defproject sync-sub "0.1.0-SNAPSHOT"
  :description "See https://github.com/nchapon/sync-sub"
  :url "https://github.com/nchapon/sync-sub"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.5.1"]
                 [joda-time/joda-time "2.1"]
                 [org.clojure/tools.cli "0.2.4"]
                 [midje "1.5.1"]]
  :main sync-sub.cmdline
  ;; As above, but for uberjar.
  :uberjar-name "sync-sub.jar")
