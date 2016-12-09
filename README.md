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

