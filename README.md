monkeysocks
--------
> A socks proxy in Java. It can be used to record network traffics and replay them for tests. 

### Goals

Record network traffics and replay them for tests. Then you can run tests isolately without considering the unstable external dependencies.

### Ways

Set global socks proxy for Java.

#### Old way we do Tests:

![image](https://raw.github.com/code4craft/monkeysocks/master/mocksocks.png)

#### New way in MockSocks:

![image](https://raw.github.com/code4craft/monkeysocks/master/mocksocks-architect.png)