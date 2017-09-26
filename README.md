# Tech Stacks
Comparison between different tech stacks. Each with a unique set of programming language, web framework and database connector. Fulfilling the following:

* (static) types in the programming language
* small, but pluggable, web framework
* no ORM but still safe database access

## Usage
Make sure [Docker](https://www.docker.com/) and [docker-compose](https://docs.docker.com/compose/) is available, then run:
```
docker-compose build
docker-compose up
```

The different tech stacks will are now up and running. You can access them each via specific port numbers, i.e:

```
> curl localhost:9001
Hello from the Kotlin world!
> curl localhost:9002
Hello from the Python world!
```
