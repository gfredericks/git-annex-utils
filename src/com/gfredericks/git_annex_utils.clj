(ns com.gfredericks.git-annex-utils
  (:require [me.raynes.fs :as fs]))

(defn repo-contents
  "Returns a set of SHA256 hashes of the files in this repo."
  [root-dir]
  (set
   (for [[dir _dirs filenames] (fs/iterate-dir root-dir)
         filename filenames
         :let [f (fs/file dir filename)]
         :when (fs/link? f)
         :let [f2 (fs/normalized-path f)
               [_ sha256] (re-find #"SHA256-s\d+--([0-9a-f]{64})\b" (str f2))]]
     sha256)))

(defn parse-sha256-CLI-output
  "Returns a seq of [sha filename] pairs."
  [s]
  (map #(subvec % 1) (re-seq #"(?m)^([0-9a-f]{64})\s+(.*)$" s)))
