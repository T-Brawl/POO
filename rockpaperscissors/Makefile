all:docs test lejar

pfc:lejar
	java -jar pfc.jar

secours:
	java -jar pfcdesecours.jar	

lejar:classes
	cd classes ; jar cvfm ../pfc.jar ../manifest pfc ; cd ..

docs:
	mkdir -p docs
	cd src ; javadoc -d ../docs -subpackages pfc ; cd ..

joueur:test
	java -jar test.jar JoueurTest &

jeu:test
	java -jar test.jar JeuTest &

test:classes 
	javac -classpath test.jar test/*.java

classes: 
	mkdir -p classes
	cd src ; javac pfc/Jeu.java -d ../classes ; cd ..

clean:
	rm -f pfc.jar
	rm -f *.java~
	rm -rf classes
	rm -rf docs
	cd test ; rm -rf *.class ; cd ..
