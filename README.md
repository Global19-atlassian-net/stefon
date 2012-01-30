# Dieter

Dieter is a clojure interpretation of the ruby Sprockets library.
When you use it you will feel as happy as a little girl.

## Usage

Dieter provides you with a ring middleware which will compile certain
static assets. Currently it supports concatiating javascript and CSS
files, compiling [LESS CSS](http://lesscss.org/), and compiling
[Handlebars](https://github.com/wycats/handlebars.js).

Insert it into your ring middleware stack
    (-> app
        (asset-pipeline))
Or if you use noir
    (server/add-middleware asset-pipeline)

Concatination of assets is handled by a Dieter manifest file.
A manifest is a file whose name ends in .dieter and whose contents are
a clojure vector of file names / directories to concatenate.

For example, a file named assets/javascripts/app.js.dieter with the following contents:
    [
      "./base.js"
      "framework.js"
      "./lib/"
      "./models/"
    ]

Dieter would look for base.js in the same directory, framework.js in any subdirectory,
and then concatenate each file from the lib and models directories.

## License

Copyright (C) 2012 EdgeCase

Distributed under the Eclipse Public License, the same as Clojure.
