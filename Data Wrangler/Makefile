run: compile
	@echo "hello"

compile:
	@echo "compliing"

test: Tests.class
	java -jar junit5.jar --class-path . --scan-classpath --details tree

Tests.class:
	javac -cp .:junit5.jar Tests.java

clean:
	$(RM) *.class
