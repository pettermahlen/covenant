Covenant
========

This is an experimental library trying to implement application-internal consumer-driven contract 
testing.

Objectives: 
1. In a large codebase, make it easy to test integration between different modules. 
1. Through easier integration testing and better module isolation, make it easier to scale up to a 
   large number of teams working on a shared codebase.

This has been done for microservices, see for instance [Pact](https://docs.pact.io/) and 
[this](https://testing.googleblog.com/2016/11/what-test-engineers-do-at-google.html) Google Testing blog 
post. This is an attempt at doing it for a single application without making tests overly large by 
running the entire app.

The solution consists/may consist of the following parts:
1. A standard way of defining 'module' boundaries+APIs.
    1. Probably will/should include specifying that all parameters and return values are value objects. See 
       https://www.infoq.com/presentations/Value-Values. 
    1. Probably will/should involve using an annotated interface in Java, at least.
1. A way to generate testing mocks/stubs (unclear what right now) from the API definitions.
    1. Use annotation processors to generate classes implementing a testing API.
    1. This testing API should be similar to Mockito, for recognition.
    1. Current [example](integration-test/src/test/java/com/spotify/covenant/example/EasyExampleStub.java) 
       of what it could look like.
1. A solution for recording test invocations made by consumers, and persisting them somewhere.
1. A solution for retrieving test invocations when testing producers.
    1. Should include some kind of execution-specific method of defining where to retrieve invocations
       from. Maybe setting an environment variable, or configuring via a service loader, or sth.
    1. Should also include some kind of filtering capability - you don't want to make it possible
       for consumers to 'randomly' break producers by adding a bad test invocation.
1. A solution for replaying test invocations when testing producers.
    1. Current [example](integration-test/src/test/java/com/spotify/covenant/example/EasyExampleProducerTest.java). 
1. Some management interface, allowing an overview of what producers are defined, which consumers
   use them, and what their test invocations are.

## TODO

### Module Definition

- per-method or per-class annotations?
- write annotation processor that actually generates code

### Testing API

- improve mocking API
    - starting with a basic one, just allowing response stubbing
    - add suppliers/throwing/etc., as the needs arise

### Recording

- pick some data store to use
- define a solution for configuring data store/location

### Retrieving

- determine how to connect to datastore/configure location
- build it

### Replaying

- Theories seems to work well

### Management

- Seems like it will be datastore-dependent
- Plug into Z?!
- Overview of all producers, for each
    - List all consumers, for each
        - List all recordings, for each
            - List all invocations
