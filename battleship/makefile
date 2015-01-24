all:lejar battleship.jar
	java -jar battleship.jar

lejar:classes
	cd classes ; jar cvfm ../battleship.jar ../manifest naval ; cd ..

docs:
	mkdir -p docs
	cd src ; javadoc -d ../docs -subpackages naval ; cd ..

bateau:test
	java -jar test.jar BateauTest &

case:test
	java -jar test.jar CaseTest &

position:test
	java -jar test.jar PositionTest &

test:classes 
	javac -classpath test.jar test/BateauTest.java
	javac -classpath test.jar test/CaseTest.java
	javac -classpath test.jar test/PositionTest.java

direction:classes
	javac -classpath test.jar test/DirectionTest.java
	java -jar test.jar DirectionTest

classes: 
	mkdir -p classes
	cd src ; javac naval/Jeu.java -d ../classes ; cd ..

clean:
	rm -f *.java~