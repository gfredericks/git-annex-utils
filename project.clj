(defproject com.gfredericks/git-annex-utils "0.1.1-SNAPSHOT"
  :description "Some things I keep doing with git-annex."
  :url "https://github.com/gfredericks/git-annex-utils"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.6.0"]

                 [me.raynes/fs "1.4.4"]
                 [me.raynes/conch "0.8.0"]]
  :deploy-repositories [["releases" :clojars]])
