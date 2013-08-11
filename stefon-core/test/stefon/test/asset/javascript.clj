(ns stefon.test.asset.javascript
  (:require [clojure.java.io :as io]
            [stefon.test.helpers :as h]
            [stefon.settings :as settings]
            [stefon.asset :as asset]
            [stefon.asset.javascript :as js])
  (:use clojure.test)
  (:import stefon.asset.javascript.Js))

(deftest test-read-asset-js
  (let [asset (asset/read-asset (Js. (io/file "test/fixtures/assets/javascripts/app.js")))]
    (testing "includes file contents"
      (is (h/has-text? (:content asset) "var file = \"/app.js\"")))))

;; (deftest test-compress-js
;;   (testing "valid javascript"
;;     (let [uncompressed-js " var foo = 'bar'; "
;;           asset (Js. "filename.js" uncompressed-js)]
;;       (is (= "var foo=\"bar\";" (asset/compress asset)))))

;;   (testing "with compile errors"
;;     (let [uncompressed-with-errors "var foo = [1, 2, 3, ];"
;;           asset (Js. "haz-errors.js" uncompressed-with-errors)]
;;       (settings/with-options {:compress true :log-level :quiet}
;;         (is (= uncompressed-with-errors (asset/compress asset)))))))