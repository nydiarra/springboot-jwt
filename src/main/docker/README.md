## SpringBoot JWT Container

Following instructions explain how to publish springboot-jwt tutorial APIs via a portable Docker container.

### Pre-requisites
You need to have:
- a Docker installation available locally. See [Docker website](https://docs.docker.com/install/) on installation instructions for Windows and Linux users.
- at least 100MB of local storage.
- springboot-jwt project sources locally compiled, and shell pointing to project root.


### Build image
`mvn clean package docker:build`

Now if you issue a `docker images` command you should see `springboot-jwt:latest` image listed.


### Start container

#### From Maven, default endpoint
Basic usage: server IP 127.0.0.1, server port 9081
`mvn docker:start`

#### From Maven, custom endpoint
Advanced usage: custom server IP and server port
`mvn docker:start "-Dtomcat.ip=<SERVER_IP>"  "-Dtomcat.port=<SERVER_PORT>"`

where `<SERVER_IP>` is the IP address where Maven will test health check against (usually localhost, 127.0.0.1, or 192.168.99.100 on legacy Docker Toolbox running on a VirtualBox default image).

#### From command line
`docker run -d -p 9081:8080 springboot-jwt`

Now if you issue a `docker ps` command you should see a new running container listed.


### Access to APIs
Point your local browser to:
`http://<SERVER_IP>:9091/health`

You should see `{ status: "UP" }` message!
