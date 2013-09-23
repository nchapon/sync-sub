# sync-sub

A little Clojure application used to synchro subfiles (SRT).

## Usage

### Compile ###

 `lein uberjar`

### Run  ###
To synchronize a file you should run this command in sync-sub folder :
`java -jar target/sync-sub.jar -f <subtitle filename> -s <time in ms>`

With parameters :
 + __-f__ input file name
 + __-s__ time synchronization value in milliseconds, should be negative for delaying
 + __-e__ file encoding by default ISO-8859-1
 + __-h__ help



Example :

`java -jar target/sync-sub.jar -f sub.srt -s 1000`

Should produce a file sub.srt.out where subs are 1000 ms advanced.


## License

Copyright © 2013 Nicolas Chapon

Distributed under the Eclipse Public License, the same as Clojure.
