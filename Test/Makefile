run: compile
	java -jar junit5.jar --class-path . --scan-classpath --details tree

compile: Tests.class CSVReader.class User_1.class Ticket_1.class
	@echo "compliing"

Tests.class:
	javac -cp .:junit5.jar Tests.java

CSVReader.class:
	javac CSVReader.java

User_1.class:
	javac User_1.java

Ticket_1.class:
	javac Ticket_1.java

clean:
	$(RM) *.class
