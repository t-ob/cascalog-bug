(defproject cascalog-bug "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.5.1"]
                 [cascalog/cascalog-core "2.0.0-SNAPSHOT"]]
  :profiles {:dev {:dependencies [[org.apache.hadoop/hadoop-core "1.1.2"]]}})
