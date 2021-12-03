run: compile

compile:
	javac -source 1.7 -cp FrontEndInterface/JavaFiles/. FrontEndInterface/JavaFiles/*.java

test: compile
	javac -cp .:junit5.jar Tests.java
	java -jar junit5.jar --class-path . --scan-classpath --details tree

clean:
	$(RM) *.class
