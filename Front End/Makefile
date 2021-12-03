run: compile
	cgi login.cgi

compile:
	javac -source 1.7 -target 1.7 -cp .:junit5.jar *.java

test: compile
	@echo: The makefile is presently a normal java class, rather than a junit file

clean:
	$(RM) *.class
