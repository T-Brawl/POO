all:classes
	cd classes ; jar cvfm ../hanoi.jar ../manifest hanoi io

thegame:
	java -jar thegame.jar 2

negatif:
	java -jar thegame.jar -2

trop:	
	java -jar thegame.jar 20

tour:classes
	javac -classpath test.jar test/TourTest.java
	java -jar test.jar TourTest

disque:classes
	javac -classpath test.jar test/DisqueTest.java
	java -jar test.jar DisqueTest

classes:
	mkdir classes
	cd src ; javac hanoi/Hanoi.java -d ../classes ; cd ..

clean:
	rm -f *.java~