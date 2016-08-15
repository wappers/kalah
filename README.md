Game of Kalah for java 8
==============

Started with maven web app archetype
--------------

- The game is reconfigurable to different number of houses and stones by
editing the controller.
- The UI is a bit rough as the task did not require a fancy UI. This
includes things like internationalisation.
- The images are numbered 0-24, after that it is considered 'lots'
- This uses MVC design pattern.
- There are some unit tests which I wrote for testing some early
functionality but they are not exhaustive.

**Usage:**
*Requires java 1.8*
    mvn install
    mvn jetty:run
Visit http://localhost:8080/kalah